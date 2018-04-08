public class Product {

    private String name;
    private double price;
    private DiscountType discountType;
    private boolean buyOneGetOneFreeItem;


    public Product(String name, double price, boolean buyOneGetOneFreeItem){
        this.name = name;
        this.price = price;
        this.discountType = discountType;
        this.buyOneGetOneFreeItem = buyOneGetOneFreeItem;
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

    public boolean getBuyOneGetOneFreeItem(){
        return this.buyOneGetOneFreeItem;
    }
}
