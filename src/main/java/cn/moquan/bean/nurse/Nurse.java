package cn.moquan.bean.nurse;

public class Nurse {

    /*
    	nurse_id INT PRIMARY KEY AUTO_INCREMENT,
        NAME VARCHAR(20),
        gender INT,
        `describe` VARCHAR(100)
     */

    private int id;
    private String name;
    private int gender;
    private String describe;
    private String message;

    public Nurse() {
    }

    public Nurse(String message) {
        this.message = message;
    }

    public Nurse(int id, String name, int gender, String describe) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.describe = describe;
    }

    public Nurse(int id, String name, int gender, String describe, String message) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.describe = describe;
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

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Nurse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", describe=" + describe +
                ", message='" + message + '\'' +
                '}';
    }
}
