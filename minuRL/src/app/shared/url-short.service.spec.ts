import { TestBed } from '@angular/core/testing';

import { UrlShortService } from './url-short.service';

describe('UrlShortService', () => {
  let service: UrlShortService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UrlShortService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
