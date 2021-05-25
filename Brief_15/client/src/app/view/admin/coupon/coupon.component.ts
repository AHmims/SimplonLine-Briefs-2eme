import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {CouponService} from '../../../services/coupon/coupon.service';
import {HttpErrorResponse} from '@angular/common/http';

@Component({
  selector: 'app-coupon',
  templateUrl: './coupon.component.html',
  styleUrls: ['./coupon.component.css']
})
export class CouponComponent implements OnInit {

  couponForm = this.fb.group({
    code: ['', Validators.required],
    remise: [0, [Validators.required, Validators.min(1), Validators.max(100)]],
    dateExpiration: ['', Validators.required],
    active: [true, Validators.required]
  });

  constructor(private fb: FormBuilder, private couponService: CouponService) {
  }

  ngOnInit(): void {
  }

  onSubmit() {
    console.log(this.couponForm.value);
    this.couponService.add(this.couponForm.value).subscribe(data => {
      console.log(data);
      alert('Coupon added');
    }, (error: HttpErrorResponse) => {
      console.error(error);
      alert(error.error.message);
    });
  }

  /**
   * */

}
