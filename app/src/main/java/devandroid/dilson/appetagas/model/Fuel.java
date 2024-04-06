package devandroid.dilson.appetagas.model;

public class Fuel {
    protected Integer id;
    protected Double price;
    protected String msg;


    protected String name;

    public Fuel(){

    }

    public Fuel(String name, Double price){
        this.name = name;
        this.price = price;
    }

    public Fuel(Integer id, String name, Double price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
