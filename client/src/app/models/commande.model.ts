import {Deserializable} from './deserializable.model';
import {Adresse} from './adresse.model';
import {Produit} from './produit.model';

export class Commande implements Deserializable {
  dateCommand?: Date;
  status?: number;
  adresse?: Adresse;
  produits?: Produit[];
  //
  deserialize = (input: any): Commande => {
    Object.assign(this, input);
    this.adresse = new Adresse().deserialize(input.adresse);
    this.produits = input.produits.map((produit: Produit) => new Produit().deserialize(produit));
    return this;
  };
}
