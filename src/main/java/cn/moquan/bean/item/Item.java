package cn.moquan.bean.item;

public class Item {

    /*
        CREATE TABLE IF NOT EXISTS item(
            item_id INT PRIMARY KEY AUTO_INCREMENT,
            NAME VARCHAR(20),
            price INT,
            `DESCRIBE` VARCHAR(50),
            checkout_time INT
        );
    */

    private int id;
    private String name;
    private int price;
    private String describe;
    private int checkoutTime;
    private String message;

    public Item() {
    }

    public Item(String message) {
        this.message = message;
    }

    public Item(int id, String name, int price, String describe, int checkoutTime, String message) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.describe = describe;
        this.checkoutTime = checkoutTime;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public int getCheckoutTime() {
        return checkoutTime;
    }

    public void setCheckoutTime(int checkoutTime) {
        this.checkoutTime = checkoutTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", describe='" + describe + '\'' +
                ", CheckoutTime='" + checkoutTime + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
