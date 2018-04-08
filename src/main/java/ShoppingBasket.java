import java.util.ArrayList;

public class ShoppingBasket {

    private ArrayList<Product> products;
    private Product item;
    private DiscountType discountType;
    private Customer customer;


    public ShoppingBasket() {
        this.products = new ArrayList<Product>();
    }

    public int getProductCount() {
        return products.size();
    }

    public void addProduct(Product item) {
        this.products.add(item);
    }

    public void removeProduct(Product item) {
        this.products.remove(item);
    }

    public void emptyBasket() {
        this.products.clear();
    }

    // calculates total value of basket excluding any discounts due
    public double subtotal() {
        ArrayList<Product> shoppingCart = new ArrayList<>();
        double total = 0;
        for (Product item : products) {
            shoppingCart.add(item);
            total += item.getPrice();
        }

        return total;
    }

    //calculates total price with all relevant discounts due
    public double calculateTotal(Customer customer) {
        double total = subtotal();
        //repeating code below out of necessity as no other way worked for me
        if (total > 20.00) {
            total -= (total * discountType.HIGHSPENDER.getValue());
        }

       if (customer.getLoyaltyCardHolderStatus() == true) {
        total -= (total * discountType.LOYALTYCARD.getValue());
        }
        return total;
}
////        buy one get one free method discount does not work
//        if (item.getBuyOneGetOneFreeItem() == true){
//            products.add(item);
//            total -= (total - item.getPrice());

    //highspender discount method
    public double highSpenderDiscount() {
        double total = subtotal();
        if (total > 20.00) {
            total -= (total * discountType.HIGHSPENDER.getValue());
        }
        return total;
    }

    //loyalty cardholder discount method
    public double loyaltyCardHolderDiscount(Customer customer) {
        double total = subtotal();
        if (customer.getLoyaltyCardHolderStatus() == true) {
            total -= (total * discountType.LOYALTYCARD.getValue());
        }
        return total;
    }

    }

