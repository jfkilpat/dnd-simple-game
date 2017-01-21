import {
  Injectable
} from '@angular/core';
import {
  Http
} from '@angular/http';
import 'rxjs/add/operator/map';

let gamesURL = 'https://randomuser.me/api/';
let charactersURL = 'https://randomuser.me/api/';

@Injectable()
export class AjaxService {

  constructor(public http: Http) {
    this.http = http;
  }

  findGames() {
    var response = this.http.get(gamesURL).map(res => res.json());
    console.log(response);
    return response;
  }

  findCharacters() {
    var response = this.http.get(charactersURL).map(res => res.json());
    console.log(response);
    return response;
  }
}
