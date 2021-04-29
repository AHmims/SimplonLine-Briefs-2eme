import {Component, OnInit} from '@angular/core';
import {NavigationStart, Router} from '@angular/router';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {

  navType: number = 0;

  constructor(router: Router) {
    this.setNavType(router.url);
    router.events.forEach((event) => {
      if (event instanceof NavigationStart) {
        this.setNavType(event.url);
      }
    });
  }

  ngOnInit = (): void => {
  };

  setNavType = (url: string): void => {
    switch (url.split('/')[2]) {
      case 'users':
        this.navType = 1;
        break;
      case 'commandes':
        this.navType = 2;
        break;
      default:
        this.navType = 0;
    }
  };
}
