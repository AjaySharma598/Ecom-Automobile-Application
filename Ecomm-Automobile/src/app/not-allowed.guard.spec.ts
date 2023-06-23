import { TestBed } from '@angular/core/testing';

import { NotAllowedGuard } from './not-allowed.guard';

describe('NotAllowedGuard', () => {
  let guard: NotAllowedGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(NotAllowedGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
