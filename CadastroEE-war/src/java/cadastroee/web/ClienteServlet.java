package cadastroee.web;

import cadastroee.facade.ClienteFacadeLocal;
import cadastroee.model.Cliente;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/clientes")
public class ClienteServlet extends HttpServlet {

    @EJB
    private ClienteFacadeLocal clienteFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Cliente> lista = clienteFacade.findAll();
        request.setAttribute("clientes", lista);
        request.getRequestDispatcher("clientes.jsp")
               .forward(request, response);
    }
}
