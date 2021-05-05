import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {CommandeService} from '../../../services/commande/commande.service';

@Component({
  selector: 'app-commandes',
  templateUrl: './commandes.component.html',
  styleUrls: ['./commandes.component.css']
})
export class CommandesComponent implements OnInit {
  userId: string = '';

  constructor(private route: ActivatedRoute, private commandeService: CommandeService) {
  }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.userId = params['idUser'];
    });
    //
    this.commandeService.getByUser(this.userId).subscribe(data => {
      console.log(data);
    }, error => {
      console.error(error);
    });
  }

}
