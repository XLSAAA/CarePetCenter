package cn.moquan.bean.order;

public class OrderStatusInfo {

    private int id;
    private int status;

    public OrderStatusInfo() {
    }

    public OrderStatusInfo(int id, int status) {
        this.id = id;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "OrderStatusInfo{" +
                "id=" + id +
                ", status=" + status +
                '}';
    }
}
