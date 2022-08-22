import {Component, OnInit} from '@angular/core';
import {EnterpriseModel} from "../../models/enterprise.model";
import {EnterpriseService} from "../../services/enterprise.service";
import {MessageService} from 'primeng/api';

@Component({
  selector: 'app-enterprises',
  templateUrl: './enterprises.component.html',
  styleUrls: ['./enterprises.component.css'],
  providers: [MessageService]
})
export class EnterprisesComponent implements OnInit {
  public enterprises: EnterpriseModel[] = [];
  first = 0;
  title = 'Crate Enterprise';
  enterprise = {};
  action = 'create';

  constructor(private enterpriseService: EnterpriseService, private messageService: MessageService) {
  }

  ngOnInit(): void {
    this.getEnterprises();
  }

  getEnterprises(): void {
    this.enterpriseService.readAll().subscribe(data => this.enterprises = data);
  }

  display: boolean = false;

  showDialog(): void {
    this.display = true;
  }

  showDialogEdit(enterprise: EnterpriseModel) {
    this.enterprise = enterprise;
    this.title = 'Edit Enterprise';
    this.action = 'edit';
    this.display = true;
  }

  createOrEditEnterprise(evenData: { message: string }) {
    this.display = false;
    this.messageService.add({severity: 'success', summary: 'success', detail: evenData.message});
    this.getEnterprises();
  }
}
