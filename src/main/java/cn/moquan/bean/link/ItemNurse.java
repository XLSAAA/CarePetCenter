package cn.moquan.bean.link;

public class ItemNurse {

    private int itemId;
    private int nurseId;

    public ItemNurse() {
    }

    public ItemNurse(int itemId, int nurseId) {
        this.itemId = itemId;
        this.nurseId = nurseId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getNurseId() {
        return nurseId;
    }

    public void setNurseId(int nurseId) {
        this.nurseId = nurseId;
    }

    @Override
    public String toString() {
        return "ItemAndNurse{" +
                "itemId=" + itemId +
                ", nurseId=" + nurseId +
                '}';
    }
}
