import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {EnterprisesComponent} from "./components/enterprises/enterprises.component";
import {EnterpriseComponent} from "./components/enterprise/enterprise.component";

const routes: Routes = [
  {path: '', component: EnterprisesComponent},
  {path: 'enterprise', component: EnterpriseComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
