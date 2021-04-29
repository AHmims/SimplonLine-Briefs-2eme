import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {LayoutModule} from '../../layout/layout.module';
import {UsersComponent} from './users/users.component';
import {HeaderComponent} from '../../components/header/header.component';
import {HomeComponent} from './home/home.component';
import { CommandesComponent } from './commandes/commandes.component';
import {AdminRoutingModule} from './admin-routing.module';
import {LoginComponent} from './login/login.component';

@NgModule({
  declarations: [
    UsersComponent,
    HomeComponent,
    HeaderComponent,
    CommandesComponent,
    LoginComponent
  ],
  imports: [
    CommonModule,
    AdminRoutingModule,
    LayoutModule
  ],
  exports: [
    HomeComponent,
    UsersComponent,
    CommandesComponent,
    LoginComponent
  ]
})

export class AdminViewModule {
}
