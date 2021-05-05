import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {DashboardLayoutComponent} from '../../layout/dashboard-layout/dashboard-layout.component';
import {HomeComponent} from './home/home.component';
import {UsersComponent} from './users/users.component';
import {CommandesComponent} from './commandes/commandes.component';
import {LoginComponent} from './login/login.component';

const routes: Routes = [
  {
    path: 'admin',
    component: DashboardLayoutComponent,
    children: [
      {
        path: '', component: HomeComponent
      },
      {
        path: 'users', component: UsersComponent
      },
      {
        path: 'commandes/:idUser', component: CommandesComponent
      }
    ]
  },
  {
    path: 'admin/login',
    component: LoginComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})

export class AdminRoutingModule {
}
