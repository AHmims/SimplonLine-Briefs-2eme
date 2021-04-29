import {Deserializable} from './deserializable.model';

export class Image implements Deserializable {
  url?: string;

  //
  deserialize = (input: any): this => {
    Object.assign(this, input);
    return this;
  };
}
