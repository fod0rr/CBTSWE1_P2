<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Vendedores</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background: #f9f9f9;
        padding: 20px;
    }
    .container {
        max-width: 1200px;
        margin: auto;
    }
    h1 {
        text-align: center;
        color: #333;
    }
    table {
        width: 100%;
        border-collapse: collapse;
        background: white;
        box-shadow: 0px 0px 10px #ccc;
        border-radius: 10px;
        overflow: hidden;
        margin-top: 20px;
    }
    th, td {
        padding: 12px;
        text-align: left;
        border-bottom: 1px solid #ddd;
    }
    th {
        background-color: #f2f2f2;
    }
    .action-buttons button {
        margin-right: 10px;
        padding: 8px;
        border-radius: 4px;
        cursor: pointer;
        font-size: 16px;
        border: none;
    }
    .edit-btn {
        background-color: #007BFF;
        color: white;
    }
    .edit-btn:hover {
        background-color: #0056b3;
    }
    .delete-btn {
        background-color: #dc3545;
        color: white;
    }
    .delete-btn:hover {
        background-color: #c82333;
    }
    .message {
        padding: 10px;
        margin-bottom: 20px;
        border-radius: 6px;
        text-align: center;
    }
    .success {
        background-color: #d4edda;
        color: #155724;
    }
    .error {
        background-color: #f8d7da;
        color: #721c24;
    }
    .back-link {
        display: block;
        text-align: center;
        margin-top: 20px;
    }
    .back-link a {
        text-decoration: none;
        color: white;
        background-color: #6c757d;
        padding: 10px 20px;
        border-radius: 6px;
    }
    .back-link a:hover {
        background-color: #5a6268;
    }
</style>
</head>
<body>
<div class="container">
    <h1>Lista de Vendedores</h1>
    <c:if test="${param.status == 'updated'}">
        <div class="message success">Vendedor atualizado com sucesso!</div>
    </c:if>
    <c:if test="${param.status == 'deleted'}">
        <div class="message success">Vendedor deletado com sucesso!</div>
    </c:if>
    <c:if test="${param.status == 'error'}">
        <div class="message error">Erro ao processar a operação!</div>
    </c:if>

    <sql:setDataSource var="ds" driver="com.mysql.cj.jdbc.Driver"
                       url="jdbc:mysql://localhost:3306/p2?serverTimezone=America/Sao_Paulo"
                       user="root" password="*Consagrado712"/>
    <sql:query var="salesmen" dataSource="${ds}">
        SELECT SALESMAN_ID, NAME, CITY, COMMISSION FROM salesman
    </sql:query>

    <table>
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Cidade</th>
            <th>Comissão</th>
            <th>Ações</th>
        </tr>
        <c:forEach var="salesman" items="${salesmen.rows}">
            <tr>
                <td>${salesman.SALESMAN_ID}</td>
                <td>${salesman.NAME}</td>
                <td>${salesman.CITY}</td>
                <td>${salesman.COMMISSION}</td>
                <td class="action-buttons">
                    <form action="addSalesman.jsp" method="get" style="display:inline;">
                        <input type="hidden" name="status" value="edit">
                        <input type="hidden" name="salesmanId" value="${salesman.SALESMAN_ID}">
                        <input type="hidden" name="name" value="${salesman.NAME}">
                        <input type="hidden" name="city" value="${salesman.CITY}">
                        <input type="hidden" name="commission" value="${salesman.COMMISSION}">
                        <button type="submit" class="edit-btn">✎</button>
                    </form>
                    <form action="deleteSalesman" method="get" style="display:inline;">
                        <input type="hidden" name="salesmanId" value="${salesman.SALESMAN_ID}">
                        <button type="submit" class="delete-btn" onclick="return confirm('Tem certeza que deseja deletar?')">🗑</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
    <div class="back-link">
        <a href="index.jsp">Voltar ao Menu</a>
    </div>
</div>
</body>
</html>