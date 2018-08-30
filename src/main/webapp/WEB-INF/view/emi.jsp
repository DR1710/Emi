<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ page isELIgnored="false"%>
<title>CALCEMI</title>
</head>
<body>
	<div class="well" style="margin-top: 150px;">
		<!-- Text input-->
		<div class="form-group">
			<label class="col-md-4 control-label" for="textinput">EMI
				Amount Payable per Month:</label>
			<div class="col-md-4">${emi_payable}</div>
		</div>
	</div>
</body>
</html>