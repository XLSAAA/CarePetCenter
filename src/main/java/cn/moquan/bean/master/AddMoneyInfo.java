package cn.moquan.bean.master;

public class AddMoneyInfo {

    private int id;
    private int money;

    public AddMoneyInfo() {
    }

    public AddMoneyInfo(int id, int money) {
        this.id = id;
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "AddMoneyInfo{" +
                "id=" + id +
                ", money=" + money +
                '}';
    }
}
