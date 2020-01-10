<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/27
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jQueryAjax</title>
</head>
<body>
<button>get Ajax</button>
<button>post Ajax</button>
<script src="./js/jquery-3.4.1.min.js"></script>
<script>
    $('button:eq(0)').click(function () {
        $.ajax({
            url: "jQueryAjaxServlet.do",
            type: "post",
            code: "200",
            msg: "success",
            data: {
                "name": "小张",
                "sex": "男",
                "age": 12
            },
            success: function (resultData) {
                console.log("resultData", resultData);
            }
        })
    })
</script>
</body>
</html>
