import { Component } from '@angular/core';
import {UrlShortService} from "../../shared/url-short.service";
import {ToastrService} from "ngx-toastr";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {

  constructor(private urlShortenerService:UrlShortService,private toastr: ToastrService) {
  }

  originalURL:string = '';
  isShortUrlRcvd: boolean = false;
  shortUrl: string = '';
  errorMessage: string = '';

  copyUrl() {
    var dummy = document.createElement("input");
    document.body.appendChild(dummy);
    dummy.setAttribute('value', this.shortUrl);
    dummy.select();
    document.execCommand('copy');
    document.body.removeChild(dummy);
    this.toastr.success('URL copied to clipboard', 'Success!');
  }
  shorten() {
    if (this.originalURL.trim() === '') {
      this.isShortUrlRcvd = false;
      // Show error message for empty input
      this.errorMessage = 'Please enter a valid URL';
      return;
    }

    // Clear error message if input is not empty
    this.errorMessage = '';

    this.urlShortenerService.getShortUrl(this.originalURL).subscribe(
      res => {
        this.shortUrl = res;
        this.isShortUrlRcvd = true;
      },
      err => console.log(err)
    );
  }
}
