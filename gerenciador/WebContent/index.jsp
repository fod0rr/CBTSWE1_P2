<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gerenciador de Vendas</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background: #f2f2f2;
        text-align: center;
        padding: 50px;
    }
    h1 {
        color: #333;
        margin-bottom: 40px;
    }
    .button-container {
        display: flex;
        justify-content: center;
        gap: 20px;
        margin-bottom: 20px;
    }
    a {
        text-decoration: none;
        color: white;
        background-color: #007BFF;
        padding: 12px 30px;
        border-radius: 8px;
        font-size: 16px;
        transition: background 0.3s, transform 0.2s;
        display: inline-block;
    }
    a:hover {
        background-color: #0056b3;
        transform: scale(1.05);
    }
    .credits {
        margin-top: 50px;
        font-size: 14px;
        color: #666;
    }
</style>
</head>
<body>
<h1>Gerenciador de Vendas</h1>
<div class="button-container">
    <a href="addCustomer.jsp">Cadastrar Cliente</a>
    <a href="addSalesman.jsp">Cadastrar Vendedor</a>
    <a href="addOrder.jsp">Cadastrar Pedido</a>
</div>
<div class="button-container">
    <a href="listCustomers.jsp">Editar Clientes</a>
    <a href="listSalesmen.jsp">Editar Vendedores</a>
    <a href="listOrders.jsp">Editar Pedidos</a>
</div>

<div class="credits">
    Desenvolvido por Leandro Félix e Kaik Persike
</div>
</body>
</html>
