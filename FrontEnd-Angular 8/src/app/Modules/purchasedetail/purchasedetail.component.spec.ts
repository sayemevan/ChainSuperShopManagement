import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PurchasedetailComponent } from './purchasedetail.component';

describe('PurchasedetailComponent', () => {
  let component: PurchasedetailComponent;
  let fixture: ComponentFixture<PurchasedetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PurchasedetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PurchasedetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
