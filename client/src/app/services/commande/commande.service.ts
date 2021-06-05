import {Injectable} from '@angular/core';
import {_ENV} from '../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {EMPTY, Observable} from 'rxjs';
import {RequestOptions} from '../../util/request-options';
import {map} from 'rxjs/operators';
import {Produit} from '../../models/produit.model';
import {Utilisateur} from '../../models/utilisateur.model';
import {Commande} from '../../models/commande.model';

const _BASE_URL: string = _ENV.apiUrl.concat('/commande');

@Injectable({
  providedIn: 'root'
})
export class CommandeService {

  constructor(private http: HttpClient, private requestOptions: RequestOptions) {
  }

  getByUser = (idUser: string): Observable<any> => {
    return this.http.get(_BASE_URL.concat('/user/' + idUser), this.requestOptions.getAuthOptions()).pipe(map((res: any) => {
      if (res == null || res.length == 0) {
        return EMPTY;
      }
      console.log(res);
      return res.map((commande: Commande) => new Commande().deserialize(commande));
    }));
  };
}
