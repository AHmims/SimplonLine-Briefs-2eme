import {Component, Input, OnInit} from '@angular/core';
import {Utilisateur} from '../../../models/utilisateur.model';

@Component({
  selector: 'app-table-users',
  templateUrl: './table-users.component.html',
  styleUrls: ['./table-users.component.css']
})
export class TableUsersComponent implements OnInit {

  @Input() utilisateurs: Utilisateur[];

  constructor() {
    this.utilisateurs = [];
  }

  ngOnInit(): void {
  }

}
