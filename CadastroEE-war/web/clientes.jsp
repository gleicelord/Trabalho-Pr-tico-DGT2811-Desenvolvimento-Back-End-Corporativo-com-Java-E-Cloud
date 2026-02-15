<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="cadastroee.model.Cliente" %>

<!DOCTYPE html>
<html>
<head>
    <title>Lista de Clientes</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-4">

<h2>Lista de Clientes</h2>

<table class="table table-striped">
    <thead>
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Email</th>
        </tr>
    </thead>
    <tbody>
        <%
            List<Cliente> clientes = (List<Cliente>) request.getAttribute("clientes");
            if (clientes != null) {
                for (Cliente c : clientes) {
        %>
        <tr>
            <td><%= c.getId() %></td>
            <td><%= c.getNome() %></td>
            <td><%= c.getEmail() %></td>
        </tr>
        <%
                }
            }
        %>
    </tbody>
</table>

</body>
</html>
