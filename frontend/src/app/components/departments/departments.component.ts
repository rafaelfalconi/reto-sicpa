import {Component, OnInit} from '@angular/core';
import {DepartmentModel} from "../../models/department.model";
import {DepartmentService} from "../../services/department.service";
import {MessageService} from "primeng/api";


@Component({
  selector: 'app-departments',
  templateUrl: './departments.component.html',
  styleUrls: ['./departments.component.css'],
  providers: [MessageService]
})
export class DepartmentsComponent implements OnInit {
  public departments: DepartmentModel[] = [];
  public department = {status: true};
  first = 0;
  display = false;
  title = 'Crate Department';
  action = 'create';

  constructor(private departmentsService: DepartmentService, private messageService: MessageService) {
  }

  ngOnInit(): void {
    this.getDepartments();
  }

  getDepartments(): void {
    this.departmentsService.readAll().subscribe(data => this.departments = data);
  }

  showDialog(): void {
    this.display = true;
  }

  createOrDepartments(evenData: { message: string }) {
    this.display = false;
    this.messageService.add({severity: 'success', summary: 'success', detail: evenData.message});
    this.getDepartments();
  }

}
