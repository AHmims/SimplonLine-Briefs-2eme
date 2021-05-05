import { Injectable } from '@angular/core';
import {_ENV} from '../../environments/environment';

const _BASE_URL: string = _ENV.apiUrl.concat('/');

@Injectable({
  providedIn: 'root'
})
export class CommandeService {

  constructor() { }
}
