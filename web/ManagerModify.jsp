<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="css/ManagerModify.css"/>
    </head>
    <body>
    	<div class="content">
			<div class="title">
				Easy-Car易人租车管理系统
			</div>
			<div class="modify-cars">
				<div class="modify-car">
					<div class="ti">更改车辆</div>

					<div class="cars-description">
					<form action="####" method="post">
						<table border="0">
						<tr>
							<td><label for="brand">品牌:</label><input type="text" name="brand" id="brand" disabled="disabled" value="奥迪"/></td>
						</tr>
						<tr>
							<td><label for="level">级别:</label><input type="text" name="level" id="level" placeholder="请输入级别" /></td>
						</tr>
						<tr>
							<td><label for="type">型号:</label><input type="text" name="type" id="type" placeholder="请输入型号" /></td>
						</tr>
						<tr>
							<td><label for="structure">结构:</label><input type="text" name="structure" id="structure" placeholder="请输入结构" /></td>
						</tr>
						<tr>
							<td><label for="output">排量:</label><input type="text" name="output" id="output" placeholder="请输入排量" /></td>
						</tr>
						<tr>
							<td><label for="velocity">变速箱:</label><input type="text" name="velocity" id="velocity" placeholder="请输入变速箱" /></td>
						</tr>
						<tr>
							<td><label for="load">乘坐人数:</label><input type="text" name="load" id="load" placeholder="请输入乘坐人数" /></td>
						</tr>
						<tr>
							<td><label for="price">原价:</label><input type="text" name="price" id="price" placeholder="请输入原价" /></td>
						</tr>
						<tr>
							<td><label for="discount">折扣:</label><input type="text" name="discount" id="discount" placeholder="请输入折扣" /></td>
						</tr>
						<tr>
							<td><label for="image">图片:</label><input type="text" name="image" id="image" placeholder="请输入图片" /></td>
						</tr>
						<tr><td><input type="submit" value="提交" class="submit"/></td></tr>
						</table>
					</form>
					</div>
				</div>
			</div>
		</div>
		
 	</body>
</html>