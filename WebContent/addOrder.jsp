<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastrar Pedido</title>
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
    input[type="text"], input[type="number"], input[type="date"] {
        padding: 8px;
        border: 1px solid #ddd;
        border-radius: 4px;
    }
    button {
        padding: 10px;
        background-color: #28a745;
        color: white;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }
    button:hover {
        background-color: #5cd65c;
    }
</style>
</head>
<body>
<div class="container">
    <h1>
        <c:choose>
            <c:when test="${param.status == 'edit'}">Editar Pedido</c:when>
            <c:otherwise>Cadastrar Pedido</c:otherwise>
        </c:choose>
    </h1>

    <c:if test="${param.status == 'ok'}">
        <div class="message success">Pedido cadastrado com sucesso!</div>
    </c:if>
    <c:if test="${param.status == 'updated'}">
        <div class="message success">Pedido atualizado com sucesso!</div>
    </c:if>
    <c:if test="${param.status == 'error'}">
        <div class="message error">Erro ao processar a operação!</div>
    </c:if>

    <!-- Formulário de Cadastro / Edição -->
    <div class="form-container">
        <form action="${param.status == 'edit' ? 'editOrder' : 'addOrder'}" method="post">
            <c:if test="${param.status == 'edit'}">
                <input type="hidden" name="orderNo" value="${param.orderNo}" />
            </c:if>

            <c:if test="${param.status != 'edit'}">
                <input type="text" name="orderNo" placeholder="Nº Pedido" required>
            </c:if>

            <input type="number" name="purchaseAmt" step="0.01" placeholder="Valor da compra"
                   value="${param.purchaseAmt}" required>

            <input type="date" name="orderDate" placeholder="Data"
                   value="${param.orderDate}" required>

            <input type="number" name="customerId" placeholder="ID Cliente"
                   value="${param.customerId}" required>

            <input type="number" name="salesmanId" placeholder="ID Vendedor"
                   value="${param.salesmanId}" required>

            <button type="submit">${param.status == 'edit' ? 'Atualizar Pedido' : 'Cadastrar Pedido'}</button>
        </form>
    </div>

    <!-- Tabela de Consulta Read-Only -->
    <div class="table-container">
        <sql:setDataSource var="ds" driver="com.mysql.cj.jdbc.Driver"
                           url="jdbc:mysql://localhost:3306/servlet?serverTimezone=America/Sao_Paulo"
                           user="root" password="*Consagrado712"/>
        <sql:query var="orders" dataSource="${ds}">
            SELECT ORD_NO, PURCH_AMT, ORD_DATE, CUSTOMER_ID, SALESMAN_ID FROM orders
        </sql:query>

        <table>
            <tr>
                <th>Nº Pedido</th>
                <th>Valor</th>
                <th>Data</th>
                <th>ID Cliente</th>
                <th>ID Vendedor</th>
            </tr>
            <c:forEach var="order" items="${orders.rows}">
                <tr>
                    <td>${order.ORD_NO}</td>
                    <td>${order.PURCH_AMT}</td>
                    <td>${order.ORD_DATE}</td>
                    <td>${order.CUSTOMER_ID}</td>
                    <td>${order.SALESMAN_ID}</td>
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
