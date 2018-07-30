import { MemberWishesModule } from './member-wishes.module';

describe('MemberWishesModule', () => {
  let memberWishesModule: MemberWishesModule;

  beforeEach(() => {
    memberWishesModule = new MemberWishesModule();
  });

  it('should create an instance', () => {
    expect(memberWishesModule).toBeTruthy();
  });
});
