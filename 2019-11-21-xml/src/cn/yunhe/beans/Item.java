package cn.yunhe.beans;

public class Item {
    private  int num;
    private  String name;
    private  int  itemId;

    public Item() {
    }

    public Item(int num, String name, int itemId) {
        this.num = num;
        this.name = name;
        this.itemId = itemId;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    @Override
    public String toString() {
        return "Item{" +
                "num=" + num +
                ", name='" + name + '\'' +
                ", itemId=" + itemId +
                '}';
    }
}
