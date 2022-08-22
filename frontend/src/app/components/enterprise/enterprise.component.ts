import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
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
  @Input() enterprise: EnterpriseModel = {};
  @Input() action: string = '';
  @Output() success = new EventEmitter<{ message: string }>();
  statusValues: any[] = [{name: 'enable', value: true}, {name: 'disable', value: false}];


  constructor(private enterpriseService: EnterpriseService, private messageService: MessageService) {

  }

  ngOnInit(): void {
    console.log(this.action);
  }

  create(): void {
    this.enterpriseService.create(this.enterprise).subscribe({
      next: data => {
        this.success.emit({message: data});
      },
      error: err => {
        this.messageService.add({severity: 'error', summary: 'error', detail: err});
      }
    })
  }

  edit(): void {
    this.enterpriseService.edit(this.enterprise).subscribe({
      next: data => {
        this.success.emit({message: data});
      },
      error: err => {
        this.messageService.add({severity: 'error', summary: 'error', detail: err});
      }
    })
  }

}
