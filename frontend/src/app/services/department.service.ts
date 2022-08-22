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

  create(department: DepartmentModel): Observable<any> {
    return this.httpService.post(DepartmentService.END_POINT, department);
  }

  edit(department: DepartmentModel): Observable<any> {
    return this.httpService.put(DepartmentService.END_POINT + '/' + department.id, department);
  }
}
