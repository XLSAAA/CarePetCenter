package cn.moquan.bean.mail;

public class Mail {

//    mail_id INT PRIMARY KEY AUTO_INCREMENT,
//    master_email VARCHAR(50),
//    pet_name VARCHAR(20),
//    item_name VARCHAR(20),
//    order_id INT,
//    send_date DATETIME,
//    STATUS INT,

    private int id;
    private String masterEmail;
    private String petName;
    private String itemName;
    private int orderId;
    private String sendDate;
    private int status;
    private String message;

    public Mail() {
    }

    public Mail(String message) {
        this.message = message;
    }

    public Mail(String masterEmail, String petName, String itemName, int orderId, String sendDate, int status) {
        this.masterEmail = masterEmail;
        this.petName = petName;
        this.itemName = itemName;
        this.orderId = orderId;
        this.sendDate = sendDate;
        this.status = status;
    }

    public Mail(int id, String masterEmail, String petName, String itemName, int orderId, String sendDate, int status) {
        this.id = id;
        this.masterEmail = masterEmail;
        this.petName = petName;
        this.itemName = itemName;
        this.orderId = orderId;
        this.sendDate = sendDate;
        this.status = status;
    }

    public Mail(int id, String masterEmail, String petName, String itemName, int orderId, String sendDate, int status, String message) {
        this.id = id;
        this.masterEmail = masterEmail;
        this.petName = petName;
        this.itemName = itemName;
        this.orderId = orderId;
        this.sendDate = sendDate;
        this.status = status;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMasterEmail() {
        return masterEmail;
    }

    public void setMasterEmail(String masterEmail) {
        this.masterEmail = masterEmail;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getSendDate() {
        return sendDate;
    }

    public void setSendDate(String sendDate) {
        this.sendDate = sendDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Mail{" +
                "id=" + id +
                ", masterEmail='" + masterEmail + '\'' +
                ", petName='" + petName + '\'' +
                ", itemName='" + itemName + '\'' +
                ", orderId=" + orderId +
                ", sendDate='" + sendDate + '\'' +
                ", status=" + status +
                ", message='" + message + '\'' +
                '}';
    }
}
