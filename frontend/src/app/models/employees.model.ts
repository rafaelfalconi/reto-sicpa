import {DepartmentModel} from "./department.model";

export interface EmployeesModel {
  id?: number;
  createdBy?: string;
  createdDate?: string;
  status?: boolean;
  email?: string;
  name?: string;
  surname?: string;
  position?: string;
  age?:number;
  department?:DepartmentModel;
}
