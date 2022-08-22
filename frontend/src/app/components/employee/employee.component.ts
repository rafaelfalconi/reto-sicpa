import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {DepartmentService} from "../../services/department.service";
import {DepartmentModel} from "../../models/department.model";
import {EmployeesModel} from "../../models/employees.model";
import {EmployeeService} from "../../services/employee.service";
import {MessageService} from "primeng/api";

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css'],
  providers: [MessageService]
})
export class EmployeeComponent implements OnInit {
  statusValues: any[] = [{name: 'enable', value: true}, {name: 'disable', value: false}];
  departments: DepartmentModel[] = [];
  @Input() action: string = '';
  @Output() success = new EventEmitter<{ message: string }>();
  @Input() employee: EmployeesModel = {};

  constructor(private departmentService: DepartmentService, private employeeService: EmployeeService, private messageService: MessageService) {
  }

  ngOnInit(): void {
    this.getDepartments();

  }

  getDepartments(): void {
    this.departmentService.readAll().subscribe(data => this.departments = data);
  }

  create(): void {
    this.employeeService.create(this.employee).subscribe({
      next: data => {
        this.success.emit({message: data});
      },
      error: err => {
        this.messageService.add({severity: 'error', summary: 'error', detail: err});
      }
    })
  }

  edit(): void {
    this.employeeService.edit(this.employee).subscribe({
      next: data => {
        this.success.emit({message: data});
      },
      error: err => {
        this.messageService.add({severity: 'error', summary: 'error', detail: err});
      }
    })
  }

}
