<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="cadastroee.model.Pedido" %>

<!DOCTYPE html>
<html>
<head>
    <title>Lista de Pedidos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-4">

<h2>Lista de Pedidos</h2>

<table class="table table-striped">
    <thead>
        <tr>
            <th>ID</th>
            <th>Data</th>
            <th>Ações</th>
        </tr>
    </thead>
    <tbody>
        <%
            List<Pedido> pedidos = (List<Pedido>) request.getAttribute("pedidos");
            if (pedidos != null) {
                for (Pedido p : pedidos) {
        %>
        <tr>
            <td><%= p.getId() %></td>
            <td><%= p.getData() %></td>
            <td>
                <a href="pedidos?acao=excluir&id=<%= p.getId() %>"
                   class="btn btn-danger btn-sm"
                   onclick="return confirm('Deseja excluir?');">
                   Excluir
                </a>
            </td>
        </tr>
        <%
                }
            }
        %>
    </tbody>
</table>

</body>
</html>