package cn.yunhe.beans;

public class Item {

    private int id;

    private double price;

    private String name;

    private String type;

    public Item() {
    }

    public Item(int id, double price, String name, String type) {
        super();
        this.id = id;
        this.price = price;
        this.name = name;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Item [id=" + id + ", price=" + price + ", name=" + name
                + ", type=" + type + "]";
    }

}
