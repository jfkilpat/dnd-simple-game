import { Component } from '@angular/core';
import { NavController, NavParams } from 'ionic-angular';

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

    games = [
      'Legends of Avalon',
      'Ordinal Waypath',
      'Fungeons and Flagons?',
      'Zac is a nerd lmao',
      'Steven Unicorn',
      'Steven Uniform?',
      'Oh, Steven Universe',
      'I am delirious',
      'From a lack',
      'of sleep'
    ];

  ionViewDidLoad() {
    console.log('ionViewDidLoad GamesPage');
  }

}
