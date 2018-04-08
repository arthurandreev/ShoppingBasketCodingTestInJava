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

    public double highSpenderDiscount() {
        double total = subtotal();
        if (total > 20.00) {
            total -= (total * discountType.HIGHSPENDER.getValue());
        }
        return total;
    }

    public double loyaltyCardHolderDiscount(Customer customer) {
        double total = subtotal();
        if (customer.getLoyaltyCardHolderStatus() == true) {
            total -= (total * discountType.LOYALTYCARD.getValue());
        }
        return total;
    }

    public double calculateTotal(Customer customer) {
        double total = subtotal();

        //high spenders who spend over 20 pounds get a discount of 10%
        if (total > 20.00) {
            total -= (total * discountType.HIGHSPENDER.getValue());
        }

        //loyalty card holders get a discount of 2%
        if (customer.getLoyaltyCardHolderStatus() == true) {
            total -= (total * discountType.LOYALTYCARD.getValue());
        }
        return total;
    }

    }

// switch case statement
//    public double applyDiscounts() {
//        double total = subtotal();
//        switch (product.getDiscountType()) {
//            case BOGOF:
//                products.add(product);
//                total = (total - product.getPrice());
//                break;
//            case HIGHSPENDER:
//                if (subtotal() > 10.00) {
//                    total -= (total * discountType.getValue());
//                }
//                break;
//            case LOYALTYCARD:
//                total -= (total * discountType.getValue());
//                break;
//
//            default:
//                return subtotal();
//        }
//
//        return total;
//    }

