import {EnterpriseModel} from "./enterprise.model";

export interface DepartmentModel {
  id?: number;
  createdBy?: string;
  createdDate?: string;
  status?: boolean;
  address?: string;
  name?: string;
  phone?: string;
  enterprise?: EnterpriseModel;

}
