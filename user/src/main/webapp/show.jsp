
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <style>
        table{
            width:600px;
            height:280px;
            border: 1px solid blue;
            margin:0px auto;
            text-align: center;
        }
    </style>
</head>
<body>
    <table cellspacing="0" cellpadding="0" border="1">
        <tr>
            <td>用户编号</td>
            <td>用户名</td>
            <td>用户密码</td>
        </tr>
        <c:forEach items="${usersPage.list}" var="users">
            <tr>
                <td>${users.userId}</td>
                <td>${users.userName}</td>
                <td>${users.password}</td>
            </tr>
        </c:forEach>
    </table>
    <div>
        总${usersPage.totalCount}条 | 总${usersPage.totalPageCount}页 | 当前${usersPage.currentPageNo}页 |
        <a href="showServlet?currentPageNo=1">首页</a> |
        <a href="showServlet?currentPageNo=${usersPage.currentPageNo - 1}">上一页</a> |
        <a href="showServlet?currentPageNo=${usersPage.currentPageNo + 1}">下一页</a> |
        <a href="showServlet?currentPageNo=${usersPage.totalPageCount}">末页</a> |
    </div>
</body>
</html>
