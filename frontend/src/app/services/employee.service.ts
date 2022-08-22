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

  create(employeesModel: EmployeesModel): Observable<any> {
    return this.httpService.post(EmployeeService.END_POINT, employeesModel);
  }

  readById(id: number | undefined): Observable<EmployeesModel> {
    return this.httpService.get(EmployeeService.END_POINT + "/" + id);
  }

  edit(employeesModel: EmployeesModel): Observable<any> {
    return this.httpService.put(EmployeeService.END_POINT + "/" + employeesModel.id, employeesModel);
  }

}
