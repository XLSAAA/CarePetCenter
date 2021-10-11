package cn.moquan.bean.user;

public class User{
    private int id;
    private String name;
    private String username;
    private String password;
    private String category;
    private int errorCount;
    private String freezeTime;
    private int status;
    private String message;

    public User() {
    }

    public User(String message) {
        this.message = message;
    }

    public User(int id, String name, String username, String password, String category, int errorCount, String freezeTime, int status) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.category = category;
        this.errorCount = errorCount;
        this.freezeTime = freezeTime;
        this.status = status;
    }

    public User(int id, String name, String username, String password, String category, int errorCount, String freezeTime, int status, String message) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.category = category;
        this.errorCount = errorCount;
        this.freezeTime = freezeTime;
        this.status = status;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getErrorCount() {
        return errorCount;
    }

    public void setErrorCount(int errorCount) {
        this.errorCount = errorCount;
    }

    public String getFreezeTime() {
        return freezeTime;
    }

    public void setFreezeTime(String freezeTime) {
        this.freezeTime = freezeTime;
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
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", category='" + category + '\'' +
                ", errorCount=" + errorCount +
                ", freezeTime=" + freezeTime +
                ", status=" + status +
                ", message='" + message + '\'' +
                '}';
    }
}
