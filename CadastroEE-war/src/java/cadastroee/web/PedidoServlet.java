package cadastroee.web;

import cadastroee.facade.PedidoFacadeLocal;
import cadastroee.model.Pedido;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/pedidos")
public class PedidoServlet extends HttpServlet {

    @EJB
    private PedidoFacadeLocal pedidoFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String acao = request.getParameter("acao");

        // EXCLUIR
        if ("excluir".equals(acao)) {
            Integer id = Integer.parseInt(request.getParameter("id"));
            Pedido pedido = pedidoFacade.find(id);
            pedidoFacade.remove(pedido);
            response.sendRedirect("pedidos");
            return;
        }

        // LISTAR
        List<Pedido> lista = pedidoFacade.findAll();
        request.setAttribute("pedidos", lista);
        request.getRequestDispatcher("pedidos.jsp").forward(request, response);
    }
}