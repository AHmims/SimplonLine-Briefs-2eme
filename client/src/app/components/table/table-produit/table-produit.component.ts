import {Component, Input, OnInit} from '@angular/core';
import {Produit} from '../../../models/produit.model';

@Component({
  selector: 'app-table-produit',
  templateUrl: './table-produit.component.html',
  styleUrls: ['./table-produit.component.css']
})
export class TableProduitComponent implements OnInit {

  @Input() produits: Produit[];

  constructor() {
    this.produits = [];
  }

  ngOnInit(): void {
  }

}
