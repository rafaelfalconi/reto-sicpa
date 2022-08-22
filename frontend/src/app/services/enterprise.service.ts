import {Injectable} from '@angular/core';
import {HttpService} from "../core/http.service";
import {Observable} from "rxjs";
import {EnterpriseModel} from "../models/enterprise.model";

@Injectable({
  providedIn: 'root'
})
export class EnterpriseService {
  static END_POINT = 'enterprises';

  constructor(private httpService: HttpService) {
  }

  readAll(): Observable<EnterpriseModel[]> {
    return this.httpService.get(EnterpriseService.END_POINT);
  }
}
