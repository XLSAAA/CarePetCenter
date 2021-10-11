package cn.moquan.bean.pet;

public class Pet {

    /*
        CREATE TABLE IF NOT EXISTS pet(
            pet_id INT PRIMARY KEY AUTO_INCREMENT,
            master_id INT,
            NAME VARCHAR(20),
            age INT,
            gender INT,
            kind VARCHAR(30),
            FOREIGN KEY (master_id) REFERENCES MASTER(master_id)
        );
    * */

    private int id;
    private int masterId;
    private String name;
    private int age;
    private int gender;
    private String kind;
    private String message;

    public Pet() {
    }

    public Pet(String message) {
        this.message = message;
    }

    public Pet(int id, int masterId, String name, int age, int gender, String kind, String message) {
        this.id = id;
        this.masterId = masterId;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.kind = kind;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMasterId() {
        return masterId;
    }

    public void setMasterId(int masterId) {
        this.masterId = masterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", masterId=" + masterId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", kind='" + kind + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
