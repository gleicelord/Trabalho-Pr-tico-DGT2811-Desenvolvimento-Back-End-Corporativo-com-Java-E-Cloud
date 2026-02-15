<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="cadastroee.model.Produto" %>

<!DOCTYPE html>
<html>
<head>
    <title>Lista de Produtos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-4">

<h2>Lista de Produtos</h2>

<table class="table table-striped">
    <thead>
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Preço</th>
        </tr>
    </thead>
    <tbody>
        <%
            List<Produto> produtos = (List<Produto>) request.getAttribute("produtos");
            if (produtos != null) {
                for (Produto p : produtos) {
        %>
        <tr>
            <td><%= p.getId() %></td>
            <td><%= p.getNome() %></td>
            <td><%= p.getPreco() %></td>
        </tr>
        <%
                }
            }
        %>
    </tbody>
</table>

</body>
</html>
