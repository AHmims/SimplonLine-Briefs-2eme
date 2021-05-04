import {Component, ComponentFactoryResolver, OnInit, ViewChild, ViewContainerRef} from '@angular/core';
import {UtilisateurService} from '../../../services/utilisateur/utilisateur.service';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

  @ViewChild('usersHolder', {read: ViewContainerRef}) prodsHolder!: ViewContainerRef;

  constructor(private utilisateurService: UtilisateurService, private componentFactoryResolver: ComponentFactoryResolver) {
  }

  ngOnInit(): void {
    this.utilisateurService.getAll().subscribe(data => console.log(data), error => console.error(error));
  }

}
