import {Component, OnInit} from '@angular/core';
import {DepartmentModel} from "../../models/department.model";
import {DepartmentService} from "../../services/department.service";

@Component({
  selector: 'app-departments',
  templateUrl: './departments.component.html',
  styleUrls: ['./departments.component.css']
})
export class DepartmentsComponent implements OnInit {
  public departments: DepartmentModel[] = [];
  first = 0;

  constructor(private departmentsService: DepartmentService) {
  }

  ngOnInit(): void {
    this.getDepartments();
  }

  getDepartments(): void {
    this.departmentsService.readAll().subscribe(data => this.departments = data);
  }

}
