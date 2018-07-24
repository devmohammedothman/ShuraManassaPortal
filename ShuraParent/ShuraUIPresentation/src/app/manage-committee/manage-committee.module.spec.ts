import { ManageCommitteeModule } from './manage-committee.module';

describe('ManageCommitteeModule', () => {
  let manageCommitteeModule: ManageCommitteeModule;

  beforeEach(() => {
    manageCommitteeModule = new ManageCommitteeModule();
  });

  it('should create an instance', () => {
    expect(manageCommitteeModule).toBeTruthy();
  });
});
