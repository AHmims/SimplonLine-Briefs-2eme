import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';

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

  constructor(private fb: FormBuilder) {
  }

  ngOnInit(): void {
  }

  onSubmit() {
    console.log(this.couponForm.value);
  }
}
