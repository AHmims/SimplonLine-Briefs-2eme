import {Component, ComponentFactoryResolver, OnInit, ViewChild, ViewContainerRef} from '@angular/core';
import {ProduitService} from '../../../services/produit/produit.service';
import {Produit} from '../../../models/produit.model';
import {TableProduitComponent} from '../../../components/table/table-produit/table-produit.component';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  @ViewChild('prodsHolder', {read: ViewContainerRef}) prodsHolder!: ViewContainerRef;

  constructor(private profileService: ProduitService, private componentFactoryResolver: ComponentFactoryResolver) {
  }

  ngOnInit(): void {
    this.profileService.getAll().subscribe(data => {
      console.log(data);
      this.displayProducts(data);
    }, error => console.error(error));
  }

  displayProducts = (produits: Produit[]) => {
    this.prodsHolder.clear();
    const componentFactory = this.componentFactoryResolver.resolveComponentFactory(TableProduitComponent);
    const dyynamicComponent = <TableProduitComponent> this.prodsHolder.createComponent(componentFactory).instance;
    dyynamicComponent.produits = produits;
  };

}
