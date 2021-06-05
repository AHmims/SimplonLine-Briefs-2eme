import {Deserializable} from './deserializable.model';
import {Role} from './role.models';

export class AuthResponse implements Deserializable {
  nom?: string;
  prenom?: string;
  email?: string;
  role?: Role;
  token?: string;
  //
  deserialize = (input: any): AuthResponse => {
    Object.assign(this, input);
    this.role = new Role().deserialize(input.role);
    return this;
  };
}
