import {Deserializable} from './deserializable.model';

export class Image implements Deserializable {
  lien?: string;

  //
  deserialize = (input: any): this => {
    Object.assign(this, input);
    return this;
  };
}
