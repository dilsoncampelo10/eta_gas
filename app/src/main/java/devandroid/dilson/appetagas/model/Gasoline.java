package devandroid.dilson.appetagas.model;

public class Gasoline extends Fuel{
    public Gasoline(Double price){
        super("Gasolina",price);
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
