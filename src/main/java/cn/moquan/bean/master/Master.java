package cn.moquan.bean.master;

public class Master {

    private int id;
    private String name;
    private int gender;
    private String tel;
    private String mail;
    private String address;
    private int balance;
    private int vip;
    private String message;

    public Master() {
    }

    public Master(String message) {
        this.message = message;
    }

    public Master(int id, String name, int gender, String tel, String mail, String address, int balance, int vip) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.tel = tel;
        this.mail = mail;
        this.address = address;
        this.balance = balance;
        this.vip = vip;
    }

    public Master(int id, String name, int gender, String tel, String mail, String address, int balance, int vip, String message) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.tel = tel;
        this.mail = mail;
        this.address = address;
        this.balance = balance;
        this.vip = vip;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
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

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getVip() {
        return vip;
    }

    public void setVip(int vip) {
        this.vip = vip;
    }

    @Override
    public String toString() {
        return "Master{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", tel='" + tel + '\'' +
                ", mail='" + mail + '\'' +
                ", address='" + address + '\'' +
                ", balance=" + balance +
                ", vip=" + vip +
                '}';
    }
}
