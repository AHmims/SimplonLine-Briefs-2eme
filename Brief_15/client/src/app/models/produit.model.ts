import {Categorie} from './categorie.model';
import {Image} from './image.model';
import {Deserializable} from './deserializable.model';

export class Produit implements Deserializable {
  libelle?: string;
  description?: string;
  prix?: number;
  categorie?: Categorie;
  images?: Image[];
  dateAjout?: Date;

  //
  deserialize = (input: any): Produit => {
    Object.assign(this, input);
    this.categorie = new Categorie().deserialize(input.categorie);
    this.images = input.images.map((image: Image) => new Image().deserialize(image));
    return this;
  };
}
