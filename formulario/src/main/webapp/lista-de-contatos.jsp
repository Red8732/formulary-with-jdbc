<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<!-- Cria o DAO -->
<jsp:useBean id="dao" class="br.com.formulario.jdbc.dao.ContatoDao"/>

<html>
<head>
<meta charset="UTF-8">

<title>Contatos</title>

</head>
<body>
	<table>
		<!--  Percorre contatos montando as linhas da tabela -->
		<c:forEach var="contato" items="${dao.lista}">
			<tr>
				<td>${contato.nome}</td>
				
				<td>
				  <c:choose>
					<c:when test="${not empty contato.email}">
					  <a href="mailto:${contato.email}">${contato.email}</a>
					</c:when>
					
					<c:otherwise>
					  E-mail não informado.
					</c:otherwise>
				  </c:choose>
				</td>
				
				<td>${contato.endereco}</td>
				
				<td> <fmt:formatDate value="${contato.dataNascimento.time}"
					pattern="dd/MM/yyyy" /> 
				</td>
			</tr>
		 </c:forEach>
	</table>
	
</body>
</html>