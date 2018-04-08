public enum DiscountType {

    BOGOF("Bogof", 1.0),
    LOYALTYCARD("LoyaltyCard", 0.02),
    HIGHSPENDER("HighSpender", 0.1),
    FULLPRICE("FullPrice", 0.0);

    private String name;
    private double value;

    DiscountType(String name, double value){
        this.name = name;
        this.value=value;
    }

    public double getValue(){
        return this.value;
    }

    public String getName(){
        return this.name;
    }

}
