import {Injectable} from '@angular/core';
import {_ENV} from '../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {Utilisateur} from '../../models/utilisateur.model';
import {EMPTY, Observable} from 'rxjs';
import {map} from 'rxjs/operators';
import {RequestOptions} from '../../util/request-options';

const _BASE_URL: string = _ENV.apiUrl.concat('/user');

@Injectable({
  providedIn: 'root'
})
export class UtilisateurService {

  constructor(private http: HttpClient, private requestOptions: RequestOptions) {
  }

  getAll = (): Observable<Utilisateur[]> => {
    return this.http.get(_BASE_URL.concat('/all'), this.requestOptions.getAuthOptions()).pipe(map((res: any) => {
      if (res == null || res.count == 0) {
        return EMPTY;
      }
      return res.utilisateurs.map((utilisateur: Utilisateur) => new Utilisateur().deserialize(utilisateur));
    }));
  };
}
