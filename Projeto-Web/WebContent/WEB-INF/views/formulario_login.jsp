<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<h2>
		Login
	</h2>
	<form action="efetuarLogin" method="post">
		Login: <input type="text" name="login" /> <br />
		Senha: <input type="password" name="senha" /> <br />
		<select size="1" name = "idRole">
			<c:forEach var="role" items="${roles }">
				<option value=${role.idRole }>${role.roleName }</option>
			</c:forEach>
		</select><br />
		<input type="submit" value = "Logar">
	</form>
</body>
</html>