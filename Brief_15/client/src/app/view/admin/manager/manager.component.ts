import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {ProduitService} from '../../../services/produit/produit.service';
import {CategorieService} from '../../../services/categorie/categorie.service';
import {Categorie} from '../../../models/categorie.model';
import {HttpErrorResponse} from '@angular/common/http';

@Component({
  selector: 'app-manager',
  templateUrl: './manager.component.html',
  styleUrls: ['./manager.component.css']
})
export class ManagerComponent implements OnInit {

  categorieList: Categorie[] = [];

  categorieForm: FormGroup = this.fb.group({
    libelle: ['', Validators.required],
    image: ['', Validators.required]
  });

  produitForm: FormGroup = this.fb.group({
    libelle: ['', Validators.required],
    description: '',
    prix: [0, [Validators.required, Validators.min(1)]],
    categorie: ['', Validators.required],
    images: ['', Validators.required]
  });

  constructor(private fb: FormBuilder, private categorieService: CategorieService, private produitService: ProduitService) {
  }

  ngOnInit(): void {
    this.categorieService.getAll().subscribe(data => {
      if (!!data.length) {
        this.categorieList = data;
      }
    }, (error: HttpErrorResponse) => console.error(error));
  }

  onCategorieSubmit(): void {
    console.log(this.categorieForm.value);
    this.categorieService.add(this.categorieForm.value).subscribe((response: Categorie) => {
      alert('Category added');
      console.log(response);
      this.categorieList.push(response);
      this.categorieForm.reset();
    }, (error: HttpErrorResponse) => console.error(error));
  }

  onProduitSubmit(): void {
    console.log(this.produitForm.value);
    let produitImages = this.produitForm.value.images.split(' ');
    if (produitImages.length >= 4 && produitImages.length <= 8) {
      this.produitForm.value.images = produitImages;
      console.log(this.produitForm.value);
      this.produitService.add(this.produitForm.value).subscribe(response => {
        alert('Produit added');
        this.produitForm.reset();
      }, (error: HttpErrorResponse) => console.error(error));
    } else {
      console.error('A product should have a count of images from 4 to 8');
    }
  }
}
