import { NominationPollModule } from './nomination-poll.module';

describe('NominationPollModule', () => {
  let nominationPollModule: NominationPollModule;

  beforeEach(() => {
    nominationPollModule = new NominationPollModule();
  });

  it('should create an instance', () => {
    expect(nominationPollModule).toBeTruthy();
  });
});
