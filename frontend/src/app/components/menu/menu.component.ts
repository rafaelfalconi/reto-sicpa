import { Component, OnInit } from '@angular/core';
import {MenuItem} from "primeng/api";

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {
  public items:MenuItem[];
  constructor() {
    this.items=[
      {
        label:'Enterprises',
        icon: 'pi pi-fw pi-building',
        url: '/#/'
      },
      {
        label:'Departments',
        icon: 'pi pi-fw pi-folder',
        url: '/#/departments'
      },
      {
        label:'Employees',
        icon: 'pi pi-fw pi-user',
        url: '/#/employees'
      }
    ];
  }

  ngOnInit(): void {
  }

}
