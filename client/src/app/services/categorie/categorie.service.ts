import {Injectable} from '@angular/core';
import {_ENV} from '../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {RequestOptions} from '../../util/request-options';
import {EMPTY, Observable} from 'rxjs';
import {Categorie} from '../../models/categorie.model';
import {map} from 'rxjs/operators';

const _BASE_URL: string = _ENV.apiUrl.concat('/categorie');

@Injectable({
  providedIn: 'root'
})
export class CategorieService {

  constructor(private http: HttpClient, private requestOptions: RequestOptions) {
  }

  add = (categoryData: any): Observable<Categorie> => {
    return this.http.post(_BASE_URL.concat('/add'), categoryData, this.requestOptions.getAuthOptions()).pipe(map((res: any) => {
      return new Categorie().deserialize(res);
    }));
  };

  getAll = (): Observable<Categorie[]> => {
    return this.http.get(_BASE_URL.concat('/all'), this.requestOptions.getAuthOptions()).pipe(map((res: any) => {
      if (res == null || res.length == 0) {
        return EMPTY;
      }

      return res.map((categorie: Categorie) => new Categorie().deserialize(categorie));
    }));
  };
}
