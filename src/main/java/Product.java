public class Product {

    private String name;
    private double price;
    private DiscountType discountType;


    public Product(String name, double price){
        this.name = name;
        this.price = price;
        this.discountType = discountType;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public DiscountType getDiscountType() {
        return this.discountType;
    }

    public void setDiscountType(DiscountType discountType){
        this.discountType = discountType;
    }
}
