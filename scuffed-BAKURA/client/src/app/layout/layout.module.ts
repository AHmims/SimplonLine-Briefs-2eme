import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RouterModule} from '@angular/router';
import {DashboardLayoutComponent} from './dashboard-layout/dashboard-layout.component';
import {SidebarComponent} from '../components/sidebar/sidebar.component';
import {HeaderComponent} from '../components/header/header.component';

@NgModule({
  declarations: [
    SidebarComponent,
    DashboardLayoutComponent
  ],
  imports: [
    CommonModule,
    RouterModule.forChild([])
  ],
  exports: [
    DashboardLayoutComponent
  ]
})
export class LayoutModule {
}
