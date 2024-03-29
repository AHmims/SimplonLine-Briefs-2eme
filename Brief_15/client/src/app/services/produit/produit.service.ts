import {Injectable} from '@angular/core';
import {_ENV} from '../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {EMPTY, Observable} from 'rxjs';
import {map} from 'rxjs/operators';
import {Produit} from '../../models/produit.model';
import {RequestOptions} from '../../util/request-options';

const _BASE_URL: string = _ENV.apiUrl.concat('/produit');

@Injectable({
  providedIn: 'root'
})

export class ProduitService {
  constructor(private http: HttpClient, private requestOptions: RequestOptions) {
  }

  getAll = (): Observable<Produit[]> => {
    return this.http.get(_BASE_URL.concat('/all'), this.requestOptions.getAuthOptions()).pipe(map((res: any) => {
      if (res == null || res.length == 0) {
        return EMPTY;
      }
      return res.map((prodit: Produit) => new Produit().deserialize(prodit));
    }));
  };

  add = (produitData: any): Observable<Produit> => {
    return this.http.post(_BASE_URL.concat('/add'), produitData, this.requestOptions.getAuthOptions()).pipe(map((res: any) => {
      return new Produit().deserialize(res);
    }));
  };
}
