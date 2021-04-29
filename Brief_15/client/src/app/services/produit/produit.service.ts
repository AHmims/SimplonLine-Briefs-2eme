import {Injectable} from '@angular/core';
import {_ENV} from '../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {map} from 'rxjs/operators';
import {Produit} from '../../models/produit.model';

const _BASE_URL: string = _ENV.apiUrl.concat('/produit');

@Injectable({
  providedIn: 'root'
})

export class ProduitService {
  constructor(private http: HttpClient) {
  }

  getAll = (): Observable<Produit[]> => {
    return this.http.get(_BASE_URL.concat('/all')).pipe(map((res: any) => {
      if (res == null || res.length == 0) {
        return new Observable<Produit[]>();
      }
      return res.map((prodit: Produit) => new Produit().deserialize(prodit));
    }));
  };
}
