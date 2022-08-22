import {Injectable} from '@angular/core';
import {environment} from '../../environments/environment';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import {catchError, map, Observable, throwError} from 'rxjs';

@Injectable()
export class HttpService {
  static API_END_POINT = environment.url;

  private headers: HttpHeaders = new HttpHeaders();
  private params: HttpParams = new HttpParams();
  private responseType: string | undefined;


  constructor(private http: HttpClient) {
    this.resetOptions();
  }

  private resetOptions(): void {
    this.headers = new HttpHeaders();
    this.params = new HttpParams();
    this.responseType = 'json';
  }

  param(key: string, value: string): HttpService {
    this.params = this.params.append(key, value); // This class is immutable
    return this;
  }

  private header(key: string, value: string): HttpService {
    this.headers = this.headers.append(key, value); // This class is immutable
    return this;
  }

  authToken(): HttpService {
    return this.header('Authorization', 'Bearer ' + sessionStorage.getItem('token'));
  }

  post(endpoint: string, body?: object): Observable<any> {
    return this.http.post(HttpService.API_END_POINT + endpoint, body, this.createOptions()).pipe(
      map(response => HttpService.extractData(response)
      ), catchError((error: any) => {
        return HttpService.handleError(error);
      })
    );
  }

  put(endpoint: string, body?: object): Observable<any> {
    return this.http.put(HttpService.API_END_POINT + endpoint, body, this.createOptions()).pipe(
      map(response => HttpService.extractData(response)
      ), catchError((error: any) => {
        return HttpService.handleError(error);
      })
    );
  }

  get(endpoint: string): Observable<any> {
    return this.http.get(HttpService.API_END_POINT + endpoint, this.createOptions()).pipe(
      map(response => HttpService.extractData(response)
      ), catchError((error: any) => {
        return HttpService.handleError(error);
      })
    );
  }


  private createOptions(): any {
    const options: any = {
      headers: this.headers,
      params: this.params,
      responseType: this.responseType,
      observe: 'response',
      reportProgress: true

    };
    this.resetOptions();
    return options;
  }

  private static extractData(response: any): any {
    return response.body;
  }

  private static handleError(response: any): any {

    return throwError(response.error);
  }
}
