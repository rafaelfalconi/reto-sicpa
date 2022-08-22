import {Injectable} from '@angular/core';
import {HttpService} from "../core/http.service";
import {Observable} from "rxjs";
import {EmployeesModel} from "../models/employees.model";

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  static END_POINT = 'employees';

  constructor(private httpService: HttpService) {
  }

  readAll(): Observable<EmployeesModel[]> {
    return this.httpService.get(EmployeeService.END_POINT);
  }
}
