import {Component, OnInit} from '@angular/core';
import {EnterpriseModel} from "../../models/enterprise.model";
import {EnterpriseService} from "../../services/enterprise.service";
import {MessageService} from 'primeng/api';

@Component({
  selector: 'app-enterprise',
  templateUrl: './enterprise.component.html',
  styleUrls: ['./enterprise.component.css'],
  providers: [MessageService]
})
export class EnterpriseComponent implements OnInit {
  enterprise: EnterpriseModel = {};
  statusValues: any[] = [{name: 'enable', value: true}, {name: 'disable', value: false}];
  status: boolean = false;

  constructor(private enterpriseService: EnterpriseService, private messageService: MessageService) {
  }

  ngOnInit(): void {
  }

  create(): void {
    this.enterprise.status = this.status;
    this.enterpriseService.create(this.enterprise).subscribe({
      next: data => {
        this.messageService.add({severity: 'success', summary: 'success', detail: data});
      },
      error: err => {
        this.messageService.add({severity: 'error', summary: 'error', detail: err});
      }
    })

  }

}
