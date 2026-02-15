package cadastroee.web;

import cadastroee.facade.ProdutoFacadeLocal;
import cadastroee.model.Produto;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/produtos")
public class ProdutoServlet extends HttpServlet {

    @EJB
    private ProdutoFacadeLocal produtoFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Produto> lista = produtoFacade.findAll();
        request.setAttribute("produtos", lista);
        request.getRequestDispatcher("produtos.jsp").forward(request, response);
    }
}
