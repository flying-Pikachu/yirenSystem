<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <link rel="stylesheet" type="text/css" href="../css/OrderModify.css"/>
</head>
<body>
<div class="content">
    <div class="title">Easy-Car易人租车管理系统</div>
    <div class="modify-cars">
        <div class="modify-car">
            <div class="ti">
                <div class="ti-l">修改订单</div>
            </div>
            <div class="ti-detail">
                <div class="order-no">订单号</div>
                <div class="order-name">租车人</div>
            </div>
            <div class="car-message">车辆信息</div>
            <div class="cars-description">
                <div class="car-image"></div>
                <div class="cars-detail">
                    <form action="####" method="post">
                        <table border="0">
                            <tr>
                                <td>取车时间</td>
                                <td>
                                    <input type="text" name="fetch-year" id="fetch-year" class="inputfield"/>年
                                    <input type="text" name="fetch-month" id="fetch-month" class="inputfield" />月
                                    <input type="text" name="fetch-day" id="fetch-day" class="inputfield"/>日
                                </td>
                            </tr>
                            <tr>
                                <td>还车时间</td>
                                <td>
                                    <input type="text" name="return-year" id="return-year" class="inputfield"/>年
                                    <input type="text" name="return-month" id="return-month" class="inputfield" />月
                                    <input type="text" name="return-day" id="return-day" class="inputfield"/>日
                                </td>
                            </tr>
                            <tr>
                                <td>取车地点</td>
                                <td><input type="text" name="fetch-place" id="fetch-place"  class="inputfield"/></td>
                            </tr>
                            <tr>
                                <td>还车地点</td>
                                <td><input type="text" name="return-place" id="return-place"  class="inputfield"/></td>
                            </tr>
                            <tr>
                                <td>车辆租赁费</td>
                                <td >219*2=<label>￥438</label></td>
                            </tr>
                            <tr>
                                <td><input type="submit" value="提交订单" class="submit"/></td>
                            </tr>
                        </table>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>