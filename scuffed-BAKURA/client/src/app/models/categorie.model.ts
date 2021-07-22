import {Image} from './image.model';
import {Deserializable} from './deserializable.model';

export class Categorie implements Deserializable {
  libelle?: string;
  image?: Image;

  //
  deserialize = (input: any): Categorie => {
    Object.assign(this, input);
    this.image = new Image().deserialize(input.image);
    return this;
  };
}
