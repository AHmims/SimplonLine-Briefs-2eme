import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {HomeRoutingModule} from './home-routing.module';
import {LayoutModule} from '../../../layout/layout.module';
import {HeaderComponent} from '../../../components/header/header.component';
import {HomeComponent} from './home.component';

@NgModule({
  declarations: [
    HomeComponent,
    HeaderComponent
  ],
  imports: [
    CommonModule,
    HomeRoutingModule,
    LayoutModule
  ],
  exports: [HomeComponent]
})

export class HomeModule {
}
