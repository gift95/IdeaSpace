package cn.yunhe.service;

import cn.yunhe.beans.Order;

import cn.yunhe.beans.User;
import cn.yunhe.main.Manager;
import cn.yunhe.utils.Dateutil;
import cn.yunhe.utils.JDBCUtil;

import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class OrderService {
    Scanner scanner = new Scanner(System.in);
    private OrderService os = new OrderService();

    /**
     * 按行读取 防止在输入时间时 格式中有空格导致 添加数据失败
     */
    public String readByLine(String str) {
        BufferedReader bf = new BufferedReader(new StringReader(str));
        String s = null;
        try {
            s = bf.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }

    /**
     * 传入user 根据user的ID查询订单
     *
     * @param user
     * @return
     */
    public List<Order> queryOrder(User user) {
        List<Order> list = new ArrayList<>();
        Connection conn = JDBCUtil.getConnection();
        Statement ps = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM ordertable WHERE userId = " + user.getUserId();
            ps = conn.createStatement();
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                Order order = new Order();
                order.setOrderId(rs.getInt(1));
                order.setOrderCreateTime(rs.getTimestamp(2));
                order.setOrderEndTime(rs.getTimestamp(3));
                order.setUserId(rs.getInt(4));
                String str = rs.getString(5);
                order.setRoomId(str.split(","));
                list.add(order);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.connectClosed(conn, ps, rs);
        }
        return null;
    }

    /**
     * 通过传入的user对象，结束时间 以及选择的房间号生成订单
     *
     * @param endTime
     * @param user
     * @param roomId
     * @return
     */
    public int addOrder(String endTime, User user, String roomId) {
        String sql = "insert into ordertable values(null,?,?,?,?);";
        return JDBCUtil.cud(sql, new Date(), Dateutil.strToDate(endTime), user.getUserId(), roomId);
    }

    /**
     * 根据订单号删除数据
     *
     * @param orderId
     * @return
     */
    public int delOrder(int orderId) {
        String sql = "delete from ordertable where orderId=? ;";
        return JDBCUtil.cud(sql, orderId);
    }

    /**
     * 目的 根据订单号修改数据
     * 根据输入的数字不同 改变选择的字段名 拼接到sql语句中
     *
     * @param num
     * @param orderId
     * @return1 根据订单编号来修改订单属性
     * 1 订单id
     * 2 订单结束时间
     * 3 房间id
     */

    public int updateOrder(int num, int orderId, Object object) {
        String column = null;
        switch (num) {
            case 1:
                column = "orderId";
                break;
            case 2:
                column = "orderEndTime";
                break;
            case 3:
                column = "roomId";
                break;
            default:
                break;
        }
        String sql = "update ordertable set " + column + " = ? where orderId = " + orderId + ";";
        return JDBCUtil.cud(sql, object);
    }


    /**
     * 遍历输出订单列表
     *
     * @param user
     */
    public void showOrder(User user) {
        List<Order> list = queryOrder(user);
        for (Order order : list
                ) {
            System.out.println("订单编号" + order.getOrderId() +
                    "\t" + "用户名" + order.getUserId() +
                    "\t 订单创建时间 " + order.getOrderCreateTime() +
                    "\t 订单结束时间" + order.getOrderEndTime() +
                    "\t 房间号" + Arrays.toString(order.getRoomId()));
        }
    }

    /**
     * 根据传入的User对象的userId 选择对应的订单号
     *
     * @param user
     */
    public void changeOrder(User user) throws IOException {


        System.out.println("请输入要修改的订单号");
        int orderId = scanner.nextInt();
        System.out.println("请选择要修改的订单项目：1 订单Id 2 订单结束时间 3 房间名");
        int attributeNum = scanner.nextInt();
        switch (attributeNum) {
            case 1:
                System.out.println("请输入修改后的订单号");
                int newOrderId = scanner.nextInt();
                os.updateOrder(1, orderId, newOrderId);
                break;
            case 2:
                System.out.println("请输入修改后的订单结束时间 格式为'yyyy-MM-dd HH:mm:ss'");
                String newEndTime = scanner.next();
                //按行读取
                String s = readByLine(newEndTime);
                os.updateOrder(2, orderId, s);
                break;

            case 3:
                System.out.println("请输入修改后的房间号");
                String newRoomId = scanner.next();
                os.updateOrder(3, orderId, newRoomId);
                break;
            case 0:
            default:
                //默认返回订单操作菜单
                Manager ma = new Manager();
                ma.operateOrder(user);
                break;
        }

    }

    /**
     * 增加订单
     *
     * @param user
     */
    public void addOrder(User user) throws IOException {
        Manager ma = new Manager();
        System.out.println("请输入退房时间 格式为yyyy-MM-dd HH:mm:ss");
        String endTime = scanner.next();
        //按行读取
        String s = readByLine(endTime);
        System.out.println("请输入房间号");
        String roomId = scanner.nextLine();
        OrderService os = new OrderService();
        int num = os.addOrder(s, user, roomId);
        if (num == 1) {
            //预订成功后返回主菜单
            System.out.println("预订成功");

            ma.mainMenu(user);
        } else {
            //预定失败返回订单操作菜单
            ma.operateOrder(user);
        }


    }
}
