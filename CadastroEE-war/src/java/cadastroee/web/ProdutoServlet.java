package cadastroee.web;

import cadastroee.facade.ProdutoFacadeLocal;
import cadastroee.model.Produto;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@WebServlet("/produtos")
public class ProdutoServlet extends HttpServlet {

    @EJB
    private ProdutoFacadeLocal produtoFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String acao = request.getParameter("acao");

        // NOVO
        if ("novo".equals(acao)) {
            request.getRequestDispatcher("produto-form.jsp")
                   .forward(request, response);
            return;
        }

        // EDITAR
        if ("editar".equals(acao)) {
            Integer id = Integer.parseInt(request.getParameter("id"));
            Produto produto = produtoFacade.find(id);
            request.setAttribute("produto", produto);
            request.getRequestDispatcher("produto-form.jsp")
                   .forward(request, response);
            return;
        }

        // EXCLUIR
        if ("excluir".equals(acao)) {
            Integer id = Integer.parseInt(request.getParameter("id"));
            Produto produto = produtoFacade.find(id);
            produtoFacade.remove(produto);
            response.sendRedirect("produtos");
            return;
        }

        // LISTAR (default)
        List<Produto> lista = produtoFacade.findAll();
        request.setAttribute("produtos", lista);
        request.getRequestDispatcher("produtos.jsp")
               .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idParam = request.getParameter("id");
        String nome = request.getParameter("nome");
        Integer quantidade = Integer.parseInt(request.getParameter("quantidade"));
        String precoStr = request.getParameter("preco").replace(",", ".");
        BigDecimal preco = new BigDecimal(precoStr);

        Produto produto;

        // UPDATE
        if (idParam != null && !idParam.isEmpty()) {
            produto = produtoFacade.find(Integer.parseInt(idParam));
        } else {
            produto = new Produto();
        }

        produto.setNome(nome);
        produto.setQuantidade(quantidade);
        produto.setPreco(preco);

        if (produto.getId() == null) {
            produtoFacade.create(produto);
        } else {
            produtoFacade.edit(produto);
        }

        response.sendRedirect("produtos");
    }
}