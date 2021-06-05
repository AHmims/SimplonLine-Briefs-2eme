import {LocalstorageService} from '../services/localstorage/localstorage.service';
import {HttpHeaders} from '@angular/common/http';
import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})

export class RequestOptions {
  constructor(private localStorage: LocalstorageService) {
  }

  getAuthOptions = (): any => {
    return {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        Authorization: `bearer ${this.localStorage.get('token')}` || ''
      })
    };
  };
}
