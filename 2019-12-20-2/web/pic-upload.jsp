<%@ page import="org.apache.commons.fileupload.FileItem" %>
<%@ page import="org.apache.commons.fileupload.FileUploadBase" %>
<%@ page import="org.apache.commons.fileupload.disk.DiskFileItemFactory" %>
<%@ page import="org.apache.commons.fileupload.servlet.ServletFileUpload" %>
<%@ page import="java.io.File" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/20
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    request.setCharacterEncoding("utf-8");
    //获取创建ServletFileUpload的工厂对象
    DiskFileItemFactory df = new DiskFileItemFactory();
    //创建解析request的ServletFileUpload对象
    ServletFileUpload slf = new ServletFileUpload(df);
    try {

        slf.setFileSizeMax(1024 * 300);
        session.setAttribute("size", slf.getSizeMax());
        //解析request对象获得一个FileItem的List集合
        List<FileItem> fileItems = slf.parseRequest(request);
        if (fileItems != null) {
            //遍历集合
            for (FileItem fileItem : fileItems) {
                //判断fileItem是普通字段名还是file字段
                //普通字段名返回true file字段返回false
                if (fileItem.isFormField()) {
                    //获取字段名
                    String fileName = fileItem.getFieldName();
                    //获取字段的值 编码格式为UTF-8
                    String fileVal = fileItem.getString("utf-8");
                } else {
                    System.out.println(fileItem.getSize());
                    //获取字段名
                    String fileName = fileItem.getName();

                    //利用数组的.contains()方法判断文件的后缀名是否符合要求
                    String[] picPatten = {".jpg", ".png", ".PNG", ".JPG", ".JPEG"};
                    //获取文件的后缀
                    String suffix = fileName.substring(fileName.lastIndexOf("."));
                    List filePatten = Arrays.asList(picPatten);
                    if (!filePatten.contains(suffix)) {
                        session.setAttribute("picMsg", "图片格式错，格式为" + Arrays.toString(picPatten));
                        response.sendRedirect("index.jsp");
                    }
                    //设置新文件名 以时间加后缀的格式
                    String newFileName = new Date().getTime() + suffix;
                    //创建文件夹路径
                    String path = request.getServletContext().getRealPath("/") + "imgs/";
                    File file = new File(path);
                    if (!file.exists()) {
                        //如果不存在就创建文件夹
                        file.mkdir();
                    }

                    //将文件路径传入session域中
                    session.setAttribute("picPath", "imgs/" + newFileName);
                    //创建文件
                    fileItem.write(new File(path, newFileName));
                    response.sendRedirect("show.jsp");
                }
            }
        }
    } catch (FileUploadBase.FileSizeLimitExceededException e) {
        session.setAttribute("sizeMsg", "最大可上传的文件大小：" + (slf.getFileSizeMax() / 1024.0 / 1024.0) + "M");
        response.sendRedirect("index.jsp");
    }
%>
</body>
</html>
