package cadastroee.facade;

import cadastroee.model.ItemPedido;
import java.util.List;
import jakarta.ejb.Local;

@Local
public interface ItemPedidoFacadeLocal {

    void create(ItemPedido itemPedido);

    void edit(ItemPedido itemPedido);

    void remove(ItemPedido itemPedido);

    ItemPedido find(Object id);

    List<ItemPedido> findAll();
}