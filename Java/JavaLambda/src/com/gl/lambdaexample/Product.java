class Product<P extends Number, D extends Number, U extends Number> {
    private String name;
    private P price;
    private D discount;
    private U unit;

    // Constructor
    public Product(String name, P price, D discount, U unit) {
        this.name = name;
        this.price = price;
        this.discount = discount;
        this.unit = unit;
    }

    // Getters
    public String getName() {
        return name;
    }

    public P getPrice() {
        return price;
    }
     public D getDiscount() {
        return discount;
    }

    public U getUnit() {
        return unit;
    }
    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(P price) {
        this.price = price;
    }

    public void setDiscount(D discount) {
        this.discount = discount;
    }

    public void setUnit(U unit) {
        this.unit = unit;
    }

    // Method to calculate total
    public double getTotal() {
        return (price.doubleValue() - discount.doubleValue()) * unit.doubleValue();
    }







}
