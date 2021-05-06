import {Deserializable} from './deserializable.model';

export class Adresse implements Deserializable {
  details?: string;
  ville?: string;
  codePostal?: string;
  tel?: number;
  nomDestinataire?: string;
  prenomDestinataire?: string;
  //
  deserialize = (input: any): this => {
    Object.assign(this, input);
    return this;
  };
  //
  display = (): string => {
    return `${this.details} ${this.ville} ${this.codePostal}\n${this.tel} ${this.nomDestinataire} ${this.prenomDestinataire}`;
  };
}
