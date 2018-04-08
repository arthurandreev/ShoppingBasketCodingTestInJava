public enum DiscountType {

    LOYALTYCARD("LoyaltyCard", 0.02),
    HIGHSPENDER("HighSpender", 0.1);

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
