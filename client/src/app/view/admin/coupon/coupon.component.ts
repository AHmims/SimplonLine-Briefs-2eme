import {Component, ComponentFactoryResolver, OnInit, ViewChild, ViewContainerRef} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {CouponService} from '../../../services/coupon/coupon.service';
import {HttpErrorResponse} from '@angular/common/http';
import {Coupon} from '../../../models/coupon.model';
import {TableProduitComponent} from '../../../components/table/table-produit/table-produit.component';
import {TableCouponsComponent} from '../../../components/table/table-coupons/table-coupons.component';

@Component({
  selector: 'app-coupon',
  templateUrl: './coupon.component.html',
  styleUrls: ['./coupon.component.css']
})
export class CouponComponent implements OnInit {
  @ViewChild('couponsHolder', {read: ViewContainerRef}) couponsHolder!: ViewContainerRef;

  couponForm = this.fb.group({
    code: ['', Validators.required],
    remise: [0, [Validators.required, Validators.min(1), Validators.max(100)]],
    dateExpiration: ['', Validators.required],
    active: [true, Validators.required]
  });

  constructor(private fb: FormBuilder, private couponService: CouponService, private componentFactoryResolver: ComponentFactoryResolver) {
  }

  ngOnInit(): void {
    this.couponService.getAll().subscribe(data => {
      if (!!data.length) {
        this.displayCoupons(data);
      }
    }, error => console.error(error));
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
  displayCoupons = (data: Coupon[]) => {
    this.couponsHolder.clear();
    const componentFactory = this.componentFactoryResolver.resolveComponentFactory(TableCouponsComponent);
    const dyynamicComponent = <TableCouponsComponent> this.couponsHolder.createComponent(componentFactory).instance;
    dyynamicComponent.coupons = data;
  };
}
