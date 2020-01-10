package cn.yunhe.main;

import cn.yunhe.beans.User;
import cn.yunhe.service.LoginService;
import cn.yunhe.service.OrderService;
import cn.yunhe.service.RoomService;
import cn.yunhe.service.UserService;

import java.io.IOException;
import java.util.Scanner;

/**
 * 此类是用来控制控制台菜单显示
 *
 * @author Administrator
 */
public class Manager {
    /**
     * 创建对象用于调用其类中的方法
     */
    private Scanner scanner = new Scanner(System.in);
    private LoginService ls = new LoginService();
    private RoomService rs = new RoomService();
    private OrderService os = new OrderService();
    private UserService us = new UserService();

    /**
     * 开始菜单
     * 如果User对象为空就返回此菜单
     */
    public void startMenu() throws IOException {
        System.out.println("请选择：1 登陆 ，2 注册 ");
        User user;
        int num = scanner.nextInt();
        switch (num) {
            case 1:
                user = loginMenu();
                if (user != null) {
                    mainMenu(user);
                } else {
                    startMenu();
                }
                break;
            default:
                user = register();
                mainMenu(user);
                break;
        }
    }

    /**
     * 登陆菜单 返回一个User对象
     * 此对象存储的是数据库中对应手机号 密码的 那条数据
     *
     * @return User
     */
    public User loginMenu() {
        System.out.println("请输入手机号和密码登陆系统");
        System.out.println("请输入手机号");
        String userPhone = scanner.next();
        System.out.println();
        System.out.println("请输入密码");
        String userPassword = scanner.next();
        return ls.login(userPhone, userPassword);
    }

    /**
     * 注册用户 向数据库中的usertable添加一条数据
     *
     * @return
     */
    public User register() {

        System.out.println("请输入注册信息");
        System.out.println("请输入用户Id");
        int userId = scanner.nextInt();
        System.out.println("请输入用户名");
        String userName = scanner.next();
        System.out.println("请输入用户性别");
        String userSex = scanner.next();
        System.out.println("请输入用户手机号");
        String userPhone = scanner.next();
        System.out.println("请输入用户密码");
        String userPassword = scanner.next();
        return ls.register(userId, userName, userSex, userPhone, userPassword);
    }

    /**
     * 主菜单 显示各种功能
     *
     * @param user
     * @throws IOException
     */
    public void mainMenu(User user) throws IOException {
        System.out.println("1 查看历史订单");
        System.out.println("2 查看房间信息");
        System.out.println("3 查看人员列表");
        System.out.println("4 查看Vip人员列表");
        System.out.println("5 退出");
        int num = scanner.nextInt();
        switch (num) {
            case 1:
                os.showOrder(user);
                operateOrder(user);
                break;
            case 2:
                rs.showRoom();
                System.out.println("请输入数字选择：\n1 下订单 2 增加房间 3 删除房间 4 修改房间信息\t 0 返回上一层 ");
                addRooms(user);
                break;
            case 3:
                userManagerMenu(user);
                break;
            case 4:
                us.showVipUser();
                break;
            case 5:
                System.exit(0);
            default:
                mainMenu(user);
                break;
        }
        mainMenu(user);

    }

    /**
     * 订单操作菜单
     * 传入一个User对象 包含各种数据
     * 根据user对象的id 查找对应的订单号对其操作
     *
     * @param user
     * @throws IOException
     */
    public void operateOrder(User user) throws IOException {
        System.out.println("请输入数字选择：\n1 删除订单 \n 2 修改订单 \n 0 返回上一层 ");
        int num = scanner.nextInt();
        int orderId;
        switch (num) {
            case 1:
                System.out.println("请输入要删除的订单号");
                orderId = scanner.nextInt();
                int flag = os.delOrder(orderId);
                if (flag == 1) {
                    System.out.println("删除成功");
                    os.showOrder(user);
                    operateOrder(user);
                }
                break;
            case 2:
                os.changeOrder(user);
                mainMenu(user);
                break;
            default:
                mainMenu(user);
                break;

        }
    }

    /**
     * 1 下订单 2 增加房间 3 删除房间 4 修改房间信息	 0 返回上一层
     *
     * @param user
     */
    public void addRooms(User user) throws IOException {
        int flag = scanner.nextInt();
        switch (flag) {
            case 1:
                os.addOrder(user);
                break;
            case 2:
                // addRoom(int roomID, String roomType, Double roomPrice, String roomDesc)
                //增加房间
                System.out.println("请输入要添加的房间Id");
                int addRoomID = scanner.nextInt();
                System.out.println("请输入数字 添加的房间类型 ：1 单人间,2 标间,3 三人间,4 四人间");
                String addRoomType = scanner.next();
                System.out.println("请输入要添加的房间价格");
                Double addRoomPrice = scanner.nextDouble();
                System.out.println("请输入要添加的房间描述");
                String addRoomDesc = scanner.next();
                int addResult = rs.addRoom(addRoomID, addRoomType, addRoomPrice, addRoomDesc);
                if (addResult == 1) {
                    System.out.println("添加成功");
                }

                break;
            case 3:
                System.out.println("请输入要删除的房间Id");
                String delRoomId = scanner.next();
                int delResult = rs.delRoom(delRoomId);
                if (delResult == 1) {
                    System.out.println("删除成功");
                }

                break;
            case 4:
                //修改房间的属性 根据num的不同 使判断的字段不一样
                System.out.println("请输入要修改的房间Id");
                String updateRoomId = scanner.next();
                System.out.println("请输入数字 修改的房间属性 ：1 房间Id \n2 房间类型  \n 3 房间价格 4 房间描述");
                int num = scanner.nextInt();
                System.out.println("请输入修改的值");
                switch (num) {
                    case 1:
                        String updateNewId = scanner.next();
                        rs.updateRoom(1, updateRoomId, updateNewId);

                        break;
                    case 2:
                        System.out.println("请输入数字添加 房间类型 ：1 单人间,2 标间,3 三人间,4 四人间");
                        String updateNewTy = scanner.next();
                        rs.updateRoom(2, updateRoomId, updateNewTy);
                        break;
                    case 3:
                        double updatePrice = scanner.nextDouble();
                        rs.updateRoom(3, updateRoomId, updatePrice);
                        break;
                    case 4:
                        String updateDesc = scanner.next();
                        rs.updateRoom(4, updateRoomId, updateDesc);
                        break;
                    default:

                        break;
                }

            case 0:
            default:

                break;
        }
        mainMenu(user);
    }

    /**
     * 修改用户属性 根据输入的数字不同 选择不同的字段 读取不同的数据类型
     *
     * @param user
     */
    public void userManagerMenu(User user) {
        us.showUser();
        Object object = null;
        System.out.println("请输入数字进行操作");
        System.out.println("1 修改用户Id");
        System.out.println("2 修改用户名");
        System.out.println("3 修改用户性别");
        System.out.println("4 修改用户手机");
        System.out.println("5 删除用户");
        System.out.println("6 加入Vip");
        System.out.println("0 返回主菜单");
        int choose = scanner.nextInt();
        System.out.println("请输入修改后的数据");
        switch (choose) {
            case 1:
                object = scanner.nextInt();
                break;
            case 2:
            case 3:
            case 4:
                object = scanner.next();
                break;
            case 5:
            case 6:
                object = "1";
                break;
            case 0:
            default:
                //删除用户后让其返回到登陆菜单
                try {
                    if (5 != choose) {
                        mainMenu(user);
                    } else {
                        startMenu();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }
        us.updateUser(choose, user, object);
    }

}
