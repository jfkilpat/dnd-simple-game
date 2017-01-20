import { Component } from '@angular/core';
import { NavController, NavParams } from 'ionic-angular';

/*
  Generated class for the Characters page.

  See http://ionicframework.com/docs/v2/components/#navigation for more info on
  Ionic pages and navigation.
*/
@Component({
  selector: 'page-characters',
  templateUrl: 'characters.html'
})
export class CharactersPage {

    characters = [
      'Ardent',
      'Grum',
      'Magicus Michael',
      'Magicus Philip',
      'Steve'
    ];

  ionViewDidLoad() {
    console.log('ionViewDidLoad CharactersPage');
  }

}
