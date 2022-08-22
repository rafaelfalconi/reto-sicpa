import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {EnterprisesComponent} from "./components/enterprises/enterprises.component";

const routes: Routes = [
  {path:'',component:EnterprisesComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
