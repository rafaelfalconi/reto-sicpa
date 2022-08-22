import {Component, OnInit} from '@angular/core';
import {MessageService} from "primeng/api";
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
  title = 'Create Employee';
  action = 'create';
  employee = {};

  constructor(private messageService: MessageService, private employeeService: EmployeeService) {
  }

  ngOnInit(): void {
    this.getEmployees();
  }

  private getEmployees(): void {
    this.employeeService.readAll().subscribe(data => this.employees = data);
  }

  showDialog(): void {
    this.display = true;
  }

  showDialogEdit(id: number) {
    this.employeeService.readById(id).subscribe(data => this.employee = data);
    this.title = 'Edit department';
    this.action = 'edit';
    this.display = true;
  }

  createOrEmployees(evenData: { message: string }) {
    this.display = false;
    this.messageService.add({severity: 'success', summary: 'success', detail: evenData.message});
    this.getEmployees();
  }

}
