<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <link rel="stylesheet" type="text/css" href="../css/OrderCenter.css"/>
</head>
<body>
<div class="content">
    <div class="title">Easy-Car易人租车管理系统</div>
    <div class="modify-cars">
        <div class="modify-car">
            <div class="ti">
                <div class="ti-l">订单中心</div>
            </div>
            <div class="cars-description">
                <form action="####" method="post">
                    <table border="0">
                        <tr>
                            <th>订单号</th>
                            <th>车型</th>
                            <th>取车时间</th>
                            <th>还车时间</th>
                            <th>订单状态</th>
                        </tr>
                        <c:forEach items="${}" varStatus="i" var="">
                            <tr>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                            </tr>
                        </c:forEach>
                    </table>
                </form>

            </div>
        </div>
    </div>
</html>