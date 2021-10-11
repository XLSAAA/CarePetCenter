package cn.moquan.bean.order;

public class Order {

    /*

    	order_id INT PRIMARY KEY AUTO_INCREMENT,
        item_id INT,
        master_id INT,
        pet_id INT,
        nurse_id INT,
        user_id INT,
        create_time DATETIME,
        end_time DATETIME,
        remake VARCHAR(50),
        STATUS INT,
        FOREIGN KEY (item_id) REFERENCES item(item_id),
        FOREIGN KEY (master_id) REFERENCES `master`(master_id),
        FOREIGN KEY (pet_id) REFERENCES pet(pet_id),
        FOREIGN KEY (nurse_id) REFERENCES nurse(nurse_id),
        FOREIGN KEY (user_id) REFERENCES `user`(user_id)

     */

    private int id;
    private int itemId;
    private int masterId;
    private int petId;
    private int nurseId;
    private int userId;
    private int pay;
    private String createTime;
    private String endTime;
    private String remake;
    private int status;
    private String message;

    public Order() {
    }

    public Order(String message) {
        this.message = message;
    }

    public Order(int itemId, int masterId, int petId, int nurseId, int userId, int pay, String createTime, String endTime, String remake, int status) {
        this.itemId = itemId;
        this.masterId = masterId;
        this.petId = petId;
        this.nurseId = nurseId;
        this.userId = userId;
        this.pay = pay;
        this.createTime = createTime;
        this.endTime = endTime;
        this.remake = remake;
        this.status = status;
    }

    public Order(int id, int itemId, int masterId, int petId, int nurseId, int userId, int pay, String createTime, String endTime, String remake, int status) {
        this.id = id;
        this.itemId = itemId;
        this.masterId = masterId;
        this.petId = petId;
        this.nurseId = nurseId;
        this.userId = userId;
        this.pay = pay;
        this.createTime = createTime;
        this.endTime = endTime;
        this.remake = remake;
        this.status = status;
    }

    public Order(int id, int itemId, int masterId, int petId, int nurseId, int userId, int pay, String createTime, String endTime, String remake, int status, String message) {
        this.id = id;
        this.itemId = itemId;
        this.masterId = masterId;
        this.petId = petId;
        this.nurseId = nurseId;
        this.userId = userId;
        this.pay = pay;
        this.createTime = createTime;
        this.endTime = endTime;
        this.remake = remake;
        this.status = status;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getMasterId() {
        return masterId;
    }

    public void setMasterId(int masterId) {
        this.masterId = masterId;
    }

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public int getNurseId() {
        return nurseId;
    }

    public void setNurseId(int nurseId) {
        this.nurseId = nurseId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getRemake() {
        return remake;
    }

    public void setRemake(String remake) {
        this.remake = remake;
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

    public int getPay() {
        return pay;
    }

    public void setPay(int pay) {
        this.pay = pay;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", itemId=" + itemId +
                ", masterId=" + masterId +
                ", petId=" + petId +
                ", nurseId=" + nurseId +
                ", userId=" + userId +
                ", pay=" + pay +
                ", createTime='" + createTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", remake='" + remake + '\'' +
                ", status=" + status +
                ", message='" + message + '\'' +
                '}';
    }
}
