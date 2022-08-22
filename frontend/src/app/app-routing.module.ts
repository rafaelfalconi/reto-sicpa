import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {EnterprisesComponent} from "./components/enterprises/enterprises.component";
import {DepartmentsComponent} from "./components/departments/departments.component";

const routes: Routes = [
  {path: '', component: EnterprisesComponent},
  {path: 'departments', component: DepartmentsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
