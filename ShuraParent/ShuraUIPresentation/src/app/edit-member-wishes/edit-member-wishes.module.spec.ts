import { EditMemberWishesModule } from './edit-member-wishes.module';

describe('EditMemberWishesModule', () => {
  let editMemberWishesModule: EditMemberWishesModule;

  beforeEach(() => {
    editMemberWishesModule = new EditMemberWishesModule();
  });

  it('should create an instance', () => {
    expect(editMemberWishesModule).toBeTruthy();
  });
});
