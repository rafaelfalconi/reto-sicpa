import {Injectable} from '@angular/core';
import {HttpService} from "../core/http.service";
import {Observable} from "rxjs";
import {DepartmentModel} from "../models/department.model";

@Injectable({
  providedIn: 'root'
})
export class DepartmentService {
  static END_POINT = 'departments';

  constructor(private httpService: HttpService) {
  }

  readAll(): Observable<DepartmentModel[]> {
    return this.httpService.get(DepartmentService.END_POINT);
  }
}
