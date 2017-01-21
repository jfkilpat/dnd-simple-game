import { NgModule, ErrorHandler } from '@angular/core';
import { IonicApp, IonicModule, IonicErrorHandler } from 'ionic-angular';
import { MyApp } from './app.component';
import { HomePage } from '../pages/home/home';
import { GamesPage } from '../pages/games/games';
import { CharactersPage } from '../pages/characters/characters';

import { AjaxService } from '../providers/ajax-service';

@NgModule({
  declarations: [
    MyApp,
    HomePage,
    GamesPage,
    CharactersPage
  ],
  imports: [
    IonicModule.forRoot(MyApp)
  ],
  bootstrap: [IonicApp],
  entryComponents: [
    MyApp,
    HomePage,
    GamesPage,
    CharactersPage
  ],
  providers: [AjaxService, {provide: ErrorHandler, useClass: IonicErrorHandler}]
})
export class AppModule {}
