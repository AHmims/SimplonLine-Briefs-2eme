import {Deserializable} from './deserializable.model';

export class Role implements Deserializable {
  libelleRole?: string;
  nivRole?: number;
  //
  deserialize = (input: any): this => {
    Object.assign(this, input);
    return this;
  };
}
