import {Component, OnInit} from '@angular/core';
import {ProduitService} from '../../../services/produit/produit.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private profileService: ProduitService) {
  }

  ngOnInit(): void {
    this.profileService.getAll().subscribe(data => console.log(data), error => console.log(error));
  }

}
