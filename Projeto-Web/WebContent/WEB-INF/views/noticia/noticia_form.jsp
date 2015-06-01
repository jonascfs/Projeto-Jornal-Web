<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastrar Notícia</title>
</head>
<body>
	<form action="cadastrarNoticia" method="POST">
		<table>
			<tr>
				<td>Título</td>
				<td><input name = "titulo" type="text" ></td>
			</tr>
			<tr>
				<td>Subtitulo</td>
				<td><input name = "subTitulo" type="text" ></td>
			</tr>
			<tr>
				<td>Texto</td>
				<td><input name = "texto" type="text" ></td>
			</tr>
			<tr>
				<td>Seção</td>
				<td> 
					<select size="1" name="idSecao">
						<c:forEach var="secao" items="${secoes}">
							<option value = ${secao.idSecao } >${secao.titulo}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Publicar" /></td>
			</tr>
		</table>
	</form>	
</body>
</html>