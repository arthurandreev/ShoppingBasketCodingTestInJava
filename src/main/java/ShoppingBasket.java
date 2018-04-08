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

    //subtotal method calculates total value of basket excluding any discounts
    public double subtotal() {
        ArrayList<Product> shoppingCart = new ArrayList<>();
        double total = 0;
        for (Product item : products) {
            shoppingCart.add(item);
            total += item.getPrice();
        }

        return total;
    }
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
        //calculates total price of basket including all the relevant discounts
    public double calculateTotal(Customer customer, Product item) {
        double total = subtotal();

        //high spenders who spend over 20 pounds get a discount of 10%
        if (total > 20.00) {
            total -= (total * discountType.HIGHSPENDER.getValue());
        }

        //loyalty card holders get a discount of 2%
        if (customer.getLoyaltyCardHolderStatus() == true) {
            total -= (total * discountType.LOYALTYCARD.getValue());
        }
        //buy one get one free method discount
//        if (item.getBuyOneGetOneFreeItem() == true){
//            products.add(item);
//            total -= (total - item.getPrice());
//        }
        return total;
    }

    }

