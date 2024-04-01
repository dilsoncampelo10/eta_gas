package devandroid.dilson.appetagas.model;

public abstract class Fuel {
    protected String name;
    protected Double price;

    public Fuel(String name, Double price){
        this.name = name;
        this.price = price;
    }

    public abstract String getName();

    public abstract  Double getPrice();

}
