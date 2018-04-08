import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestShoppingBasket {

    private ShoppingBasket shoppingBasket;
    private Product beans;
    private Product whisky;
    private Product caviar;
    private DiscountType discountType;
    private Customer dave;

    @Before

    public void before(){
        beans = new Product("Heinz baked beans", 6.00);
        whisky = new Product("Johny Walker", 25.00);
        caviar = new Product("Beluga Finest", 20.00);
        shoppingBasket = new ShoppingBasket();
        dave = new Customer(true);
    }

    @Test
    public void canGetProductCount(){
        assertEquals(0, shoppingBasket.getProductCount());
    }

    @Test
    public void canAddProductToBasket(){
        shoppingBasket.addProduct(beans);
        shoppingBasket.addProduct(beans);
        assertEquals(2, shoppingBasket.getProductCount());
    }

    @Test
    public void canRemoveProductFromBasket(){
        shoppingBasket.addProduct(caviar);
        shoppingBasket.addProduct(beans);
        shoppingBasket.removeProduct(caviar);
        assertEquals(1,shoppingBasket.getProductCount());
    }

    @Test
    public void canEmptyBasket(){
        shoppingBasket.addProduct(caviar);
        shoppingBasket.addProduct(beans);
        shoppingBasket.emptyBasket();
        assertEquals(0, shoppingBasket.getProductCount());
    }

    @Test
    public void checkSubtotal() {
        shoppingBasket.addProduct(beans);
        shoppingBasket.addProduct(beans);
        shoppingBasket.addProduct(beans);
        shoppingBasket.addProduct(whisky);
        assertEquals(43.00, shoppingBasket.subtotal(), 0.01);
    }

    @Test
    public void checkHighSpenderDiscount__lessthan20poundspend(){
        shoppingBasket.addProduct(beans);
        shoppingBasket.addProduct(beans);
        assertEquals(12, shoppingBasket.highSpenderDiscount(), 0.01);
    }

    @Test
    public void checkHighSpenderDiscount__at20poundspend(){
        shoppingBasket.addProduct(caviar);
        assertEquals(20, shoppingBasket.highSpenderDiscount(), 0.01);
    }

    @Test
    public void checkHighSpenderDiscount__over20poundspend(){
        shoppingBasket.addProduct(beans);
        shoppingBasket.addProduct(whisky);
        assertEquals(27.90, shoppingBasket.highSpenderDiscount(), 0.01);
    }

    @Test
    public void checkLoyaltyCardholderDiscount(){
        shoppingBasket.addProduct(whisky);
        assertEquals(24.50, shoppingBasket.loyaltyCardHolderDiscount(dave), 0.01);
    }

    @Test
    public void checkCalculateTotal(){
        shoppingBasket.addProduct(caviar);
        shoppingBasket.addProduct(whisky);
        assertEquals(44.10, shoppingBasket.loyaltyCardHolderDiscount(dave), 0.01);
    }
}
