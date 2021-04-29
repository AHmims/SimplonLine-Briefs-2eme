import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {UsersRoutingModule} from './admin/users/users-routing.module';
import {LayoutModule} from '../layout/layout.module';
import {HomeRoutingModule} from './admin/home/home-routing.module';
import {UsersComponent} from './admin/users/users.component';
import {HeaderComponent} from '../components/header/header.component';
import {HomeComponent} from './admin/home/home.component';

@NgModule({
  declarations: [
    UsersComponent,
    HomeComponent,
    HeaderComponent
  ],
  imports: [
    CommonModule,
    UsersRoutingModule,
    HomeRoutingModule,
    LayoutModule
  ],
  exports: [
    HomeComponent,
    UsersComponent
  ]
})

export class ViewModule {
}
