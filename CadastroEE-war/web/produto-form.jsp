<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="cadastroee.model.Produto" %>

<%
    Produto produto = (Produto) request.getAttribute("produto");
    boolean editando = (produto != null);
%>

<!DOCTYPE html>
<html>
<head>
    <title>Cadastro de Produto</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-4">

<h2><%= editando ? "Editar Produto" : "Novo Produto" %></h2>

<form method="post" action="produtos">

    <% if (editando) { %>
        <input type="hidden" name="id" value="<%= produto.getId() %>">
    <% } %>

    <div class="mb-3">
        <label>Nome</label>
        <input type="text" name="nome" class="form-control"
               value="<%= editando ? produto.getNome() : "" %>" required>
    </div>

    <div class="mb-3">
        <label>Quantidade</label>
        <input type="number" name="quantidade" class="form-control"
               value="<%= editando ? produto.getQuantidade() : "" %>" required>
    </div>

    <div class="mb-3">
        <label>Preço</label>
        <input type="text" name="preco" class="form-control"
               value="<%= editando ? produto.getPreco() : "" %>" required>
    </div>

    <button type="submit" class="btn btn-success">Salvar</button>
    <a href="produtos" class="btn btn-secondary">Voltar</a>

</form>

</body>
</html>