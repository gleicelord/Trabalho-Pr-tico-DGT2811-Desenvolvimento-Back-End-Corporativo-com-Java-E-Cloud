<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="cadastroee.model.Produto" %>

<!DOCTYPE html>
<html>
<head>
    <title>Listagem de Produtos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-4">

<h2 class="mb-4">Listagem de Produtos</h2>

<a href="produtos?acao=novo" class="btn btn-primary mb-3">
    Novo Produto
</a>

<table class="table table-striped table-bordered">
    <thead class="table-dark">
        <tr>
            <th>#</th>
            <th>Nome</th>
            <th>Quantidade</th>
            <th>Preço de Venda</th>
            <th>Opções</th>
        </tr>
    </thead>
    <tbody>
        <%
            List<Produto> produtos = (List<Produto>) request.getAttribute("produtos");
            if (produtos != null && !produtos.isEmpty()) {
                for (Produto p : produtos) {
        %>
        <tr>
            <td><%= p.getId() %></td>
            <td><%= p.getNome() %></td>
            <td><%= p.getQuantidade() %></td>
            <td><%= p.getPreco() %></td>
            <td>
                <a href="produtos?acao=editar&id=<%= p.getId() %>" 
                   class="btn btn-primary btn-sm">
                   Alterar
                </a>

                <a href="produtos?acao=excluir&id=<%= p.getId() %>" 
                   class="btn btn-danger btn-sm"
                   onclick="return confirm('Confirma exclusão?')">
                   Excluir
                </a>
            </td>
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="5" class="text-center">
                Nenhum produto cadastrado.
            </td>
        </tr>
        <%
            }
        %>
    </tbody>
</table>

</body>
</html>