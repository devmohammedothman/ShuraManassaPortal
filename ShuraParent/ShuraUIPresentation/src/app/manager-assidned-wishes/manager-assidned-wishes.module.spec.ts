import { ManagerAssidnedWishesModule } from './manager-assidned-wishes.module';

describe('ManagerAssidnedWishesModule', () => {
  let managerAssidnedWishesModule: ManagerAssidnedWishesModule;

  beforeEach(() => {
    managerAssidnedWishesModule = new ManagerAssidnedWishesModule();
  });

  it('should create an instance', () => {
    expect(managerAssidnedWishesModule).toBeTruthy();
  });
});
