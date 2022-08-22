import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {DepartmentModel} from "../../models/department.model";
import {DepartmentService} from "../../services/department.service";
import {MessageService} from "primeng/api";
import {EnterpriseService} from "../../services/enterprise.service";
import {EnterpriseModel} from "../../models/enterprise.model";

@Component({
  selector: 'app-department',
  templateUrl: './department.component.html',
  styleUrls: ['./department.component.css'],
  providers: [MessageService]
})
export class DepartmentComponent implements OnInit {
  @Input() department: DepartmentModel = {};
  @Input() action: string = '';
  statusValues: any[] = [{name: 'enable', value: true}, {name: 'disable', value: false}];
  enterprises: EnterpriseModel[] = [];
  @Output() success = new EventEmitter<{ message: string }>();

  constructor(private departmentService: DepartmentService, private messageService: MessageService, private enterpriseService: EnterpriseService) {
  }

  ngOnInit(): void {
    this.getEnterprise();
  }

  getEnterprise(): void {
    this.enterpriseService.readAll().subscribe(data => this.enterprises = data);
  }

  create(): void {
    this.departmentService.create(this.department).subscribe({
      next: data => {
        this.success.emit({message: data});
      },
      error: err => {
        this.messageService.add({severity: 'error', summary: 'error', detail: err});
      }
    })
  }


}
