import {Component, Input, OnInit} from '@angular/core';
import {Utilisateur} from '../../../models/utilisateur.model';
import {Coupon} from '../../../models/coupon.model';

@Component({
  selector: 'app-table-coupons',
  templateUrl: './table-coupons.component.html',
  styleUrls: ['./table-coupons.component.css']
})
export class TableCouponsComponent implements OnInit {

  @Input() coupons: Coupon[];

  constructor() {
    this.coupons = [];
  }

  ngOnInit(): void {
  }

}
