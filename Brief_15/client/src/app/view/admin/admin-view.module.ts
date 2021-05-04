import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {LayoutModule} from '../../layout/layout.module';
import {UsersComponent} from './users/users.component';
import {HeaderComponent} from '../../components/header/header.component';
import {HomeComponent} from './home/home.component';
import { CommandesComponent } from './commandes/commandes.component';
import {AdminRoutingModule} from './admin-routing.module';
import {LoginComponent} from './login/login.component';
import {TableProduitComponent} from '../../components/table/table-produit/table-produit.component';
import {ReactiveFormsModule} from '@angular/forms';

@NgModule({
  declarations: [
    UsersComponent,
    HomeComponent,
    HeaderComponent,
    CommandesComponent,
    LoginComponent,
    TableProduitComponent
  ],
  imports: [
    CommonModule,
    AdminRoutingModule,
    LayoutModule,
    ReactiveFormsModule
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
