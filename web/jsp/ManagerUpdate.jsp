

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员-更新车辆</title>
<link rel="stylesheet" type="text/css" href="../css/ManagerUpdate.css"/>
</head>
<body>
<div class="content">
			<div class="title">
				Easy-Car 易人租车管理系统
			</div>
			<div class="update-cars">
				<div class="easy-update">
					<div class="ti">更新车辆</div>
					<div class="search">
						<label for="brand">品牌</label>
						<input type="text" name="brand-search" id="brand" />&nbsp;&nbsp;
						<input type="submit" value="查询" class="submit"/>
						<a href="####">添加新车</a>
					</div>
					<table border="0">
						<tr align="center">
							<th>#</th>
							<th>品牌</th>
							<th>型号</th>
							<th>结构</th>
							<th>排量</th>
							<th>变速箱</th>
							<th>乘坐人数</th>
							<th>原价</th>
							<th>折扣</th>
							<th>操作</th>
						</tr>
					<c:forEach items="${easy-cars}" varStatus="i" var="car">
							<tr>
	<!--  							<td>${ }</td>
								<td>${ }</td>
								<td>${ }</td>
								<td>${ }</td>
								<td>${ }</td>
								<td>${ }</td>
								<td>${ }</td>
								<td>${ }</td>
								<td>${ }</td>
								<td><a href="####">更新</a><a href="####">删除</a></td> -->
							</tr>
						</c:forEach>
						<tr>
							<td>当前第1页</td>
							<td><<上一页&nbsp;&nbsp;下一页>></td>
							<td>共计10页到第<input type="text" name="page">页</td>
							<td><button>确定</button></td>
						</tr>
					</table>
				</div>
			</div>
		    </div>
</body>
</html>