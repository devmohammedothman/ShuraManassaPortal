import { MemberNominationsModule } from './member-nominations.module';

describe('MemberNominationsModule', () => {
  let memberNominationsModule: MemberNominationsModule;

  beforeEach(() => {
    memberNominationsModule = new MemberNominationsModule();
  });

  it('should create an instance', () => {
    expect(memberNominationsModule).toBeTruthy();
  });
});
