import {Deserializable} from './deserializable.model';

export class LoginData implements Deserializable {
  email?: string;
  password?: string;

  deserialize(input: any): any {
    Object.assign(this, input);
    return this;
  }

  //
}
