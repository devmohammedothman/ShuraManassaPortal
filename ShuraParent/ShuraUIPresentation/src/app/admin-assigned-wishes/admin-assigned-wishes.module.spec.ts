import { AdminAssignedWishesModule } from './admin-assigned-wishes.module';

describe('AdminAssignedWishesModule', () => {
  let adminAssignedWishesModule: AdminAssignedWishesModule;

  beforeEach(() => {
    adminAssignedWishesModule = new AdminAssignedWishesModule();
  });

  it('should create an instance', () => {
    expect(adminAssignedWishesModule).toBeTruthy();
  });
});
