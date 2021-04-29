import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {DashboardLayoutComponent} from '../../../layout/dashboard-layout/dashboard-layout.component';
import {UsersComponent} from './users.component';

const routes: Routes = [
  {
    path: 'users',
    component: DashboardLayoutComponent,
    children: [
      {path: '', component: UsersComponent}
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})

export class UsersRoutingModule { }
