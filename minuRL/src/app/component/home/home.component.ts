import { Component } from '@angular/core';
import {UrlShortService} from "../../shared/url-short.service";
import {catchError, tap} from "rxjs";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {

  constructor(private urlShortenerService:UrlShortService) {
  }

  originalURL:string = '';
  isShortUrlRcvd: boolean = false;
  shortUrl: string = '';

  copyUrl() {
    return null
  }
  shorten() {
    this.urlShortenerService.getShortUrl(this.originalURL).subscribe(
      res => {
        this.shortUrl = res;
        this.isShortUrlRcvd = true;
      },
      err => console.log(err)
    );
  }
}
