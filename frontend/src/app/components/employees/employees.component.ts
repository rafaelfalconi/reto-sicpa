import {Component, OnInit} from '@angular/core';
import {MessageService} from "primeng/api";
import {DepartmentModel} from "../../models/department.model";
import {EmployeesModel} from "../../models/employees.model";
import {EmployeeService} from "../../services/employee.service";

@Component({
  selector: 'app-employees',
  templateUrl: './employees.component.html',
  styleUrls: ['./employees.component.css'],
  providers: [MessageService]
})
export class EmployeesComponent implements OnInit {
  public employees: EmployeesModel[] = [];
  first = 0;
  display = false;
  title = 'Crate Employee';
  action = 'create';

  constructor(private messageService: MessageService, private employeeService: EmployeeService) {
  }

  ngOnInit(): void {
    this.getEmployees();
  }

  private getEmployees(): void {
    this.employeeService.readAll().subscribe(data => this.employees = data);
  }

}
