import {Injectable} from '@angular/core';
import {_ENV} from '../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {AuthResponse} from '../../models/auth-response.model';
import {Observable} from 'rxjs';
import {LoginData} from '../../models/login-data.model';
import {map} from 'rxjs/operators';

const _BASE_URL: string = _ENV.apiUrl.concat('/auth');

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(private http: HttpClient) {
  }

  login = (loginData: LoginData): Observable<AuthResponse> => {
    return this.http.post(_BASE_URL.concat('/login'), loginData).pipe(map((res: any) => {
      return new AuthResponse().deserialize(res);
    }));
  };
}
