import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TableCouponsComponent } from './table-coupons.component';

describe('TableCouponsComponent', () => {
  let component: TableCouponsComponent;
  let fixture: ComponentFixture<TableCouponsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TableCouponsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TableCouponsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
