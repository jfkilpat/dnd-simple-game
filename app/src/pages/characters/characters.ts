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

@Component({
  selector: 'page-characters',
  templateUrl: 'characters.html'
})
export class CharactersPage {

  characters = [];

  constructor(private ajaxService: AjaxService) {
    this.ajaxService = ajaxService;
  }

  ngOnInit() {
    this.ajaxService.findCharacters().subscribe(
      data => {
        console.log(data.results);
        this.characters = [data.results[0].name.title, data.results[0].name.first, data.results[0].name.last];
      }
    );
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad CharactersPage');
  }

}
