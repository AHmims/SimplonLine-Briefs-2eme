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
import {CardCommandeComponent} from '../../components/cards/card-commande/card-commande.component';
import { CouponComponent } from './coupon/coupon.component';
import {TableUsersComponent} from '../../components/table/table-users/table-users.component';
import {TableCouponsComponent} from '../../components/table/table-coupons/table-coupons.component';

@NgModule({
  declarations: [
    UsersComponent,
    HomeComponent,
    HeaderComponent,
    CommandesComponent,
    LoginComponent,
    TableProduitComponent,
    CardCommandeComponent,
    CouponComponent,
    TableUsersComponent,
    TableCouponsComponent
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
