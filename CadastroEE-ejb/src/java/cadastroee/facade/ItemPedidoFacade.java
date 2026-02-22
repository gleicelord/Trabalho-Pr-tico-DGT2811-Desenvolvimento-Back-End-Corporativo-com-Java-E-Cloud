package cadastroee.facade;

import cadastroee.model.ItemPedido;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ItemPedidoFacade implements ItemPedidoFacadeLocal {

    @PersistenceContext(unitName = "CadastroEE-ejbPU")
    private EntityManager em;

    @Override
    public void create(ItemPedido itemPedido) {
        em.persist(itemPedido);
    }

    @Override
    public void edit(ItemPedido itemPedido) {
        em.merge(itemPedido);
    }

    @Override
    public void remove(ItemPedido itemPedido) {
        em.remove(em.merge(itemPedido));
    }

    @Override
    public ItemPedido find(Object id) {
        return em.find(ItemPedido.class, id);
    }

    @Override
    public List<ItemPedido> findAll() {
        return em.createQuery("SELECT i FROM ItemPedido i", ItemPedido.class)
                 .getResultList();
    }
}