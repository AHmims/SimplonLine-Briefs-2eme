import {Deserializable} from './deserializable.model';
import {Role} from './role.models';

export class Utilisateur implements Deserializable {
  id?: string;
  nom?: string;
  prenom?: string;
  email?: string;
  image?: string;
  role?: Role;
  typeUtilisateur?: string;
  //
  deserialize = (input: any): Utilisateur => {
    Object.assign(this, input);
    this.role = new Role().deserialize(input.role);
    return this;
  };
}
