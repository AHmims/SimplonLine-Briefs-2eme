import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {ProduitService} from '../../../services/produit/produit.service';
import {CategorieService} from '../../../services/categorie/categorie.service';
import {Categorie} from '../../../models/categorie.model';

@Component({
  selector: 'app-manager',
  templateUrl: './manager.component.html',
  styleUrls: ['./manager.component.css']
})
export class ManagerComponent implements OnInit {

  categorieList: Categorie[] = [];

  categorieForm: FormGroup = this.fb.group({
    libelle: ['', Validators.required],
    image: ['', [Validators.required]]
  });

  produitForm: FormGroup = this.fb.group({
    libelle: ['', [Validators.required]],
    description: '',
    prix: [0, [Validators.required, Validators.min(1)]],
    categorie: '',
    images: ['', [Validators.required]]
  });

  constructor(private fb: FormBuilder, private categoryService: CategorieService, private producerService: ProduitService) {
  }

  ngOnInit(): void {
    this.categoryService.getAll().subscribe(data => {
      if (!!data.length) {
        this.categorieList = data;
      }
    }, error => console.error(error));
  }

  onCategorieSubmit(): void {
    console.log(this.categorieForm.value);
  }

  onProduitSubmit(): void {
    console.log(this.produitForm.value);
  }
}
