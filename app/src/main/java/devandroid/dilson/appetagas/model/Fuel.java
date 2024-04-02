package devandroid.dilson.appetagas.model;

public abstract class Fuel {
    protected String name;
    protected Double price;
    protected String msg;

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Fuel(String name, Double price){
        this.name = name;
        this.price = price;
    }

    public abstract String getName();

    public abstract  Double getPrice();

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
