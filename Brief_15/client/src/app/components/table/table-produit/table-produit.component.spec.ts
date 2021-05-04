import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TableProduitComponent } from './table-produit.component';

describe('TableProduitComponent', () => {
  let component: TableProduitComponent;
  let fixture: ComponentFixture<TableProduitComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TableProduitComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TableProduitComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
