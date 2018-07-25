import { GroupPermModule } from './group-perm.module';

describe('GroupPermModule', () => {
  let groupPermModule: GroupPermModule;

  beforeEach(() => {
    groupPermModule = new GroupPermModule();
  });

  it('should create an instance', () => {
    expect(groupPermModule).toBeTruthy();
  });
});
