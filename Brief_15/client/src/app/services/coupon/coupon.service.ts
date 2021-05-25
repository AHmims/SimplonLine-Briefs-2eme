import {Injectable} from '@angular/core';
import {RequestOptions} from '../../util/request-options';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Coupon} from '../../models/coupon.model';
import {_ENV} from '../../environments/environment';
import {map} from 'rxjs/operators';

const _BASE_URL: string = _ENV.apiUrl.concat('/coupon');

@Injectable({
  providedIn: 'root'
})
export class CouponService {

  constructor(private http: HttpClient, private requestOptions: RequestOptions) {
  }

  add = (couopnData: any): Observable<Coupon> => {
    return this.http.post(_BASE_URL.concat('/add'), couopnData,this.requestOptions.getAuthOptions()).pipe(map((res: any) => {
      return new Coupon().deserialize(res);
    }));
  };
}
