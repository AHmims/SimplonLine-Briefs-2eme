import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {AdminViewModule} from './view/admin/admin-view.module';
import {HttpClientModule} from '@angular/common/http';
import { TableUsersComponent } from './components/table/table-users/table-users.component';

@NgModule({
  declarations: [
    AppComponent,
    TableUsersComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    AdminViewModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})

export class AppModule {
}
