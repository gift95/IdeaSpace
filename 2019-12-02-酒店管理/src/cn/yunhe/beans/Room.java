package cn.yunhe.beans;

public class Room {
    private int roomId;
    private String roomType;
    private double roomPrice;
    private String roomDesc;

    public Room() {
    }

    public Room(int roomId, String roomType, double roomPrice, String roomDesc) {
        this.roomId = roomId;
        this.roomType = roomType;
        this.roomPrice = roomPrice;
        this.roomDesc = roomDesc;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public double getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(double roomPrice) {
        this.roomPrice = roomPrice;
    }

    public String getRoomDesc() {
        return roomDesc;
    }

    public void setRoomDesc(String roomDesc) {
        this.roomDesc = roomDesc;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomId=" + roomId +
                ", roomType='" + roomType + '\'' +
                ", roomPrice=" + roomPrice +
                ", roomDesc='" + roomDesc + '\'' +
                '}';
    }
}
