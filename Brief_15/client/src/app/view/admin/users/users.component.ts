import {Component, ComponentFactoryResolver, OnInit, ViewChild, ViewContainerRef} from '@angular/core';
import {UtilisateurService} from '../../../services/utilisateur/utilisateur.service';
import {Utilisateur} from '../../../models/utilisateur.model';
import {TableUsersComponent} from '../../../components/table/table-users/table-users.component';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

  @ViewChild('usersHolder', {read: ViewContainerRef}) usersHolder!: ViewContainerRef;

  constructor(private utilisateurService: UtilisateurService, private componentFactoryResolver: ComponentFactoryResolver) {
  }

  ngOnInit(): void {
    this.utilisateurService.getAll().subscribe(data => {
      console.log(data);
      this.displayUsers(data);
    }, error => console.error(error));
  }

  displayUsers = (utilisateurs: Utilisateur[]) => {
    this.usersHolder.clear();
    const componentFactory = this.componentFactoryResolver.resolveComponentFactory(TableUsersComponent);
    const dynamicComponent = <TableUsersComponent> this.usersHolder.createComponent(componentFactory).instance;
    dynamicComponent.utilisateurs = utilisateurs;
  };
}
