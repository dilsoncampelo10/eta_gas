package devandroid.dilson.appetagas.model;

public class Ethanol extends  Fuel{
    public Ethanol(Double price){
        super("Etanol",price);
    }


    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Double getPrice() {
        return this.price;
    }
}
