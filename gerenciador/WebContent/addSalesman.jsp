<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastrar Vendedor</title>
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
    .form-container, .table-container {
        background: white;
        padding: 20px;
        border-radius: 10px;
        box-shadow: 0px 0px 10px #ccc;
        margin-bottom: 20px;
    }
    table {
        width: 100%;
        border-collapse: collapse;
        overflow: hidden;
    }
    th, td {
        padding: 12px;
        text-align: left;
        border-bottom: 1px solid #ddd;
    }
    th {
        background-color: #f2f2f2;
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
    form {
        display: flex;
        flex-direction: column;
        gap: 10px;
        max-width: 400px;
        margin: 0 auto;
    }
    input[type="text"], input[type="number"] {
        padding: 8px;
        border: 1px solid #ddd;
        border-radius: 4px;
    }
    button {
        padding: 10px;
        background-color: #007BFF;
        color: white;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }
    button:hover {
        background-color: #0056b3;
    }
</style>
</head>
<body>
<div class="container">
    <h1>Cadastrar Vendedor</h1>
    <c:if test="${param.status == 'ok'}">
        <div class="message success">Vendedor cadastrado/atualizado com sucesso!</div>
    </c:if>
    <c:if test="${param.status == 'error'}">
        <div class="message error">Erro ao processar a operação!</div>
    </c:if>

    <!-- Formulário de Cadastro/Edição -->
<div class="form-container">
    <form action="${param.status == 'edit' ? 'editSalesman' : 'addSalesman'}" method="post">
        <input type="number" name="salesmanId" placeholder="ID do vendedor" value="${param.salesmanId}" required ${param.status == 'edit' ? 'readonly' : ''} />
        <input type="text" name="name" placeholder="Nome" value="${param.name}" required />
        <input type="text" name="city" placeholder="Cidade" value="${param.city}" required />
        <input type="number" step="0.01" name="commission" placeholder="Comissão (%)" value="${param.commission}" required />
        <button type="submit">${param.status == 'edit' ? 'Atualizar Vendedor' : 'Cadastrar Vendedor'}</button>
    </form>
</div>

    <!-- Tabela de Consulta Read-Only -->
    <div class="table-container">
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
            </tr>
            <c:forEach var="salesman" items="${salesmen.rows}">
                <tr>
                    <td>${salesman.SALESMAN_ID}</td>
                    <td>${salesman.NAME}</td>
                    <td>${salesman.CITY}</td>
                    <td>${salesman.COMMISSION}</td>
                </tr>
            </c:forEach>
        </table>
    </div>

    <div class="back-link">
        <a href="index.jsp">Voltar ao Menu</a>
    </div>
</div>
</body>
</html>