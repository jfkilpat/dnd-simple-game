import {
  Component
} from '@angular/core';
import {
  NavController,
  NavParams
} from 'ionic-angular';

import {
  AjaxService
} from '../../providers/ajax-service';

/*
  Generated class for the Games page.

  See http://ionicframework.com/docs/v2/components/#navigation for more info on
  Ionic pages and navigation.
*/
@Component({
  selector: 'page-games',
  templateUrl: 'games.html'
})
export class GamesPage {

  games = [];
  constructor(private ajaxService: AjaxService) {
    this.ajaxService = ajaxService;
  }

  ngOnInit() {
    this.ajaxService.findGames().subscribe(
      data => {
        console.log(data.results);
        this.games = [data.results[0].cell, data.results[0].dob, data.results[0].email];
      }
    );
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad GamesPage');
  }

}
