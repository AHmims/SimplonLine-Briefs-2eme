import {Component, Input, OnInit} from '@angular/core';
import {Commande} from '../../../models/commande.model';

@Component({
  selector: 'app-card-commande',
  templateUrl: './card-commande.component.html',
  styleUrls: ['./card-commande.component.css']
})
export class CardCommandeComponent implements OnInit {

  @Input() commande: Commande;

  constructor() {
    this.commande = new Commande();
  }

  ngOnInit(): void {
  }

}
