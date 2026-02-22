package cadastroee.facade;

import cadastroee.model.Pedido;
import java.util.List;
import jakarta.ejb.Local;

@Local
public interface PedidoFacadeLocal {

    void create(Pedido pedido);

    void edit(Pedido pedido);

    void remove(Pedido pedido);

    Pedido find(Object id);

    List<Pedido> findAll();
}