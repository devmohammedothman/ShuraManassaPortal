import { TestBed, inject } from '@angular/core/testing';

import { Services\storageService } from './services\storage.service';

describe('Services\storageService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [Services\storageService]
    });
  });

  it('should be created', inject([Services\storageService], (service: Services\storageService) => {
    expect(service).toBeTruthy();
  }));
});
