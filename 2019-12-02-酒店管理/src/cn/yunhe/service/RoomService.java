package cn.yunhe.service;

import cn.yunhe.beans.Room;
import cn.yunhe.utils.JDBCUtil;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class RoomService {
    Connection conn = JDBCUtil.getConnection();

    /**
     * 房间查询 返回一个集合
     *
     * @return list
     */
    public List<Room> queryRoom() {
        List<Room> list = new ArrayList<>();

        Statement ps = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM roomtable";
            ps = conn.createStatement();
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                Room room = new Room();
                room.setRoomId(rs.getInt(1));
                room.setRoomType(rs.getString(2));
                room.setRoomPrice(rs.getDouble(3));
                room.setRoomDesc(rs.getString(4));
                list.add(room);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.connectClosed(conn, ps, rs);
        }
        return null;
    }

    public String showRoomType(String type) {
        String showType = "";
        switch (type) {
            case "1":
            default:
                showType = "单人间";
                break;
            case "2":
                showType = "标间";
                break;
            case "3":
                showType = "三人间";
                break;
            case "4":
                showType = "四人间";
                break;
        }
        return showType;
    }

    /**
     * 遍历集合 显示房间信息
     */
    public void showRoom() {
        RoomService rs = new RoomService();
        List<Room> roomList = rs.queryRoom();
        for (Room room : roomList
                ) {
            System.out.println("房间描述 ：" + room.getRoomDesc() + "\t 房间类型" + showRoomType(room.getRoomType()) + "\t 房间号" + room.getRoomId() + "\t 房间价格" + room.getRoomPrice()
            );
        }
    }

    /**
     * 增加房间
     *
     * @param roomID
     * @param roomType
     * @param roomPrice
     * @param roomDesc
     * @return
     */
    public int addRoom(int roomID, String roomType, Double roomPrice, String roomDesc) {
        String sql = "insert into roomtable values(?,?,?,?)";
        return JDBCUtil.cud(sql, roomID, roomType, roomPrice, roomDesc);
    }

    /**
     * 根据房间id删除房间
     *
     * @param roomID
     * @return
     */
    public int delRoom(String roomID) {
        String sql = "delete from  roomtable where roomId = ?";
        return JDBCUtil.cud(sql, roomID);
    }

    /**
     * 根据房间id 修改房间信息
     *
     * @param num
     * @param roomId
     * @param object
     * @return
     */
    public int updateRoom(int num, String roomId, Object object) {
        String column;
        switch (num) {
            case 1:
                column = "roomId";
                break;
            case 2:
                column = "roomType";
                break;
            case 3:
                column = "roomPrice";
                break;
            default:
                column = "roomDesc";
                break;
        }
        String sql = "update roomtable set " + column + " = ? where roomId = " + roomId + ";";

        return JDBCUtil.cud(sql, object);
    }

}
