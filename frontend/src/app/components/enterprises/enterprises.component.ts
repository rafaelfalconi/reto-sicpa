import {Component, OnInit} from '@angular/core';
import {EnterpriseModel} from "../../models/enterprise.model";
import {EnterpriseService} from "../../services/enterprise.service";

@Component({
  selector: 'app-enterprises',
  templateUrl: './enterprises.component.html',
  styleUrls: ['./enterprises.component.css']
})
export class EnterprisesComponent implements OnInit {
  public enterprises: EnterpriseModel[] = [];
  first = 0;
  constructor(private enterpriseService: EnterpriseService) {
  }

  ngOnInit(): void {
    this.getEnterprises();
  }

  getEnterprises(): void {
    this.enterpriseService.readAll().subscribe(data => this.enterprises = data);
  }




}
