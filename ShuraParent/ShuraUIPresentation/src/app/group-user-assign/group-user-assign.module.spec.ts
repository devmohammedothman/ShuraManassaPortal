import { GroupUserAssignModule } from './group-user-assign.module';

describe('GroupUserAssignModule', () => {
  let groupUserAssignModule: GroupUserAssignModule;

  beforeEach(() => {
    groupUserAssignModule = new GroupUserAssignModule();
  });

  it('should create an instance', () => {
    expect(groupUserAssignModule).toBeTruthy();
  });
});
