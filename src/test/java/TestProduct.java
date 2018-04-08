import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestProduct {

    private Product bread;
    private DiscountType discountType;

    @Before
    public void before(){
        bread = new Product("White Bread", 1.99, true);
    }

    @Test
    public void getName(){
        assertEquals("White Bread", bread.getName());
    }

    @Test
    public void canGetPrice(){
        assertEquals(1.99, bread.getPrice(), 0.01);
    }

    @Test
    public void canSetAndGetDiscountType(){
        bread.setDiscountType(discountType.HIGHSPENDER);
        assertEquals(discountType.HIGHSPENDER, bread.getDiscountType());
    }

    @Test
    public void canGetBogof(){
        assertEquals(true, bread.getBuyOneGetOneFreeItem());
    }

}
