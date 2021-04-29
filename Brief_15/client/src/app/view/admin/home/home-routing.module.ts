import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {DashboardLayoutComponent} from '../../../layout/dashboard-layout/dashboard-layout.component';
import {HomeComponent} from './home.component';

const routes: Routes = [
  {
    path: 'dashboard',
    component: DashboardLayoutComponent,
    children: [
      {path: '', component: HomeComponent}
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class HomeRoutingModule {
}
