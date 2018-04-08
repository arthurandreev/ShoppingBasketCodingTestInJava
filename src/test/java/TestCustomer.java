import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestCustomer {
    private Customer customer;
    private ShoppingBasket shoppingBasket;
    private Product beans;
    private DiscountType discountType;

    @Before

    public void before(){
        customer = new Customer(true);
    }

    @Test
    public void checkLoyaltyCardHolderStatus(){
        assertEquals(true, customer.getLoyaltyCardHolderStatus());
    }
}
