<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ page import="org.apache.commons.fileupload.FileItem" %>
<%@ page import="org.apache.commons.fileupload.FileUploadBase" %>
<%@ page import="org.apache.commons.fileupload.disk.DiskFileItemFactory" %>
<%@ page import="org.apache.commons.fileupload.servlet.ServletFileUpload" %>
<%@ page import="java.io.File" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/20
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
    上传图片
        1、获取上传的图片
            1、获取上传的图片名称
            2、判断上传的是否是符合要求的图片
                格式
                大小
        2、存储图片
            存储到本地
            存储到数据库
                存储图片所在的相对路径
                将图片存储在指定的服务器上
                将图片转换为base64的字符串----不建议
        3、图片回显
            获取到存储图片的路径，通过img标签进行回显
--%>
<%
    //设置字符编码
    request.setCharacterEncoding("utf-8");
    //获取创建FileItem对象的工厂对象
    DiskFileItemFactory factory = new DiskFileItemFactory();
    //获取创建用于创建FileItem的服务对象ServletFileUpload
    ServletFileUpload fileUpload = new ServletFileUpload(factory);
    try {
        //设置可上传的最大字节数
        fileUpload.setSizeMax(1024 * 30);
        //解析request对象
        List<FileItem> fileItemList = fileUpload.parseRequest(request);
        if (null != fileItemList) {
            for (FileItem fileItem : fileItemList) {
                if (fileItem.isFormField()) {//true 代表是普通字段，例如uname,pwd之类的
                    String fieldName = fileItem.getFieldName();
                    if ("uname".equals(fieldName)) {
                        String uname = fileItem.getString("utf-8");
                    } else if ("pwd".equals(fieldName)) {
                        String pwd = fileItem.getString("utf-8");
                    }
                } else {//该字段为file字段
                    //获取到上传的文件的名字
                    String fileName = fileItem.getName();
                    //定义可以上传的图片格式对应的后缀
                    String[] picPattrn = {".png", ".jpg", ".JPEG", ".gif"};
                    //获取上传的文件名字的后缀 aaa.txt.png
                    String suffix = fileName.substring(fileName.lastIndexOf("."), fileName.length());
                    //判断该后缀实在指定的后缀数组中
                    if (Arrays.asList(picPattrn).contains(suffix) == false) {
                        session.setAttribute("picMsg", "图片格式只能为：" + Arrays.asList(picPattrn));
                        response.sendRedirect("pic-upload.jsp");
                        return;
                    }
                    //将当前时间的时间戳作为图片的名称
                    String newFileName = new Date().getTime() + suffix;
                    //先获取到项目部署的路径
                    String path = request.getServletContext().getRealPath("/") + "imgs/";
                    //判断如果指定的文件夹不存在就创建出来
                    File file = new File(path);
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    session.setAttribute("picPath", "imgs/" + newFileName);
                    fileItem.write(new File(path, newFileName));
                    response.sendRedirect("show.jsp");
                }
            }
        }
    } catch (FileUploadBase.SizeLimitExceededException e) {
        session.setAttribute("sizeMsg", "可上传的最大字节数为：" + fileUpload.getSizeMax());
        response.sendRedirect("pic-upload.jsp");
    }
%>

</body>
</html>
