import { Component } from '@angular/core';

import {GamesPage} from '../games/games';
import {CharactersPage} from '../characters/characters';

import { NavController } from 'ionic-angular';

@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
})
export class HomePage {
    gamesPage = GamesPage;
    charactersPage = CharactersPage;

}
