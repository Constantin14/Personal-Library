import { TestBed } from '@angular/core/testing';

import { SubmitPageService } from './submit-page.service';

describe('SubmitPageService', () => {
  let service: SubmitPageService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SubmitPageService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
