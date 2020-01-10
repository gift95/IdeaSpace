package cn.yunhe.beans;

import java.io.Serializable;

public class Item implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private int num;
    private int id;
    private int price;
    private String name;
    private String adr;

    public Item() {
    }

    public Item(int num, int id, int price, String name, String adr) {
        super();
        this.num = num;
        this.id = id;
        this.price = price;
        this.name = name;
        this.adr = adr;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdr() {
        return adr;
    }

    public void setAdr(String adr) {
        this.adr = adr;
    }

    @Override
    public String toString() {
        return "Item [num=" + num + ", id=" + id + ", price=" + price
                + ", name=" + name + ", adr=" + adr + "]";
    }

}
