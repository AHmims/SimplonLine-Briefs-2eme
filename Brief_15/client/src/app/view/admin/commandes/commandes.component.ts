import {Component, ComponentFactoryResolver, OnInit, ViewChild, ViewContainerRef} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {CommandeService} from '../../../services/commande/commande.service';
import {Commande} from '../../../models/commande.model';
import {TableUsersComponent} from '../../../components/table/table-users/table-users.component';
import {CardCommandeComponent} from '../../../components/cards/card-commande/card-commande.component';

@Component({
  selector: 'app-commandes',
  templateUrl: './commandes.component.html',
  styleUrls: ['./commandes.component.css']
})
export class CommandesComponent implements OnInit {
  userId: string = '';
  @ViewChild('cmdsHolder', {read: ViewContainerRef}) cmdsHolder!: ViewContainerRef;

  constructor(private route: ActivatedRoute, private commandeService: CommandeService, private componentFactoryResolver: ComponentFactoryResolver) {
  }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.userId = params['idUser'];
    });
    //
    this.commandeService.getByUser(this.userId).subscribe((data) => {
      console.log(data);
      this.displayCommandes(data);
    }, error => {
      console.error(error);
    });
  }

  //
  private displayCommandes = (commandes: Commande[]): void => {
    this.cmdsHolder.clear();
    const componentFactory = this.componentFactoryResolver.resolveComponentFactory(CardCommandeComponent);
    commandes.forEach((commande: Commande) => {
      const dynamicComponent = <CardCommandeComponent> this.cmdsHolder.createComponent(componentFactory).instance;
      dynamicComponent.commande = commande;
    });
  };
}
