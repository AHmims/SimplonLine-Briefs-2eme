import {Deserializable} from './deserializable.model';

export class Coupon implements Deserializable {
  id?: string;
  code?: string;
  remise?: number;
  dateCreation?: Date;
  dateExpiration?: Date;
  active?: boolean;
  nbCommandes?: number;

  deserialize = (input: any): this => {
    Object.assign(this, input);
    return this;
  };
}
