import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {EnterprisesComponent} from './components/enterprises/enterprises.component';
import {MenuComponent} from './components/menu/menu.component';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {HashLocationStrategy, LocationStrategy} from "@angular/common";
import {CoreModule} from './core/core.module';
import {MenubarModule} from 'primeng/menubar';
import {TableModule} from 'primeng/table';
import {ToastModule} from 'primeng/toast';
import {InputTextModule} from 'primeng/inputtext';
import {DialogModule} from 'primeng/dialog';
import {EnterpriseComponent} from './components/enterprise/enterprise.component';
import {RadioButtonModule} from 'primeng/radiobutton';
import {ButtonModule} from 'primeng/button';
import {DepartmentsComponent} from './components/departments/departments.component';
import {DepartmentComponent} from './components/department/department.component';
import {DropdownModule} from 'primeng/dropdown';
import {InputTextareaModule} from 'primeng/inputtextarea';
import {EmployeeComponent} from './components/employee/employee.component';
import {EmployeesComponent} from './components/employees/employees.component';
import {InputNumberModule} from 'primeng/inputnumber';


@NgModule({
  declarations: [
    AppComponent,
    EnterprisesComponent,
    MenuComponent,
    EnterpriseComponent,
    DepartmentsComponent,
    DepartmentComponent,
    EmployeeComponent,
    EmployeesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    FormsModule,
    CoreModule,
    MenubarModule,
    TableModule,
    ToastModule,
    InputTextModule,
    RadioButtonModule,
    ButtonModule,
    DialogModule,
    DropdownModule,
    InputTextareaModule,
    InputNumberModule
  ],
  providers: [{provide: LocationStrategy, useClass: HashLocationStrategy}],
  bootstrap: [AppComponent]
})
export class AppModule {
}
