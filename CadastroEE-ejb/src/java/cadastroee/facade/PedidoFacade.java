package cadastroee.facade;

import cadastroee.model.Pedido;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class PedidoFacade implements PedidoFacadeLocal {

    @PersistenceContext(unitName = "CadastroEE-ejbPU")
    private EntityManager em;

    @Override
    public void create(Pedido pedido) {
        em.persist(pedido);
    }

    @Override
    public void edit(Pedido pedido) {
        em.merge(pedido);
    }

    @Override
    public void remove(Pedido pedido) {
        em.remove(em.merge(pedido));
    }

    @Override
    public Pedido find(Object id) {
        return em.find(Pedido.class, id);
    }

    @Override
    public List<Pedido> findAll() {
        return em.createQuery("SELECT p FROM Pedido p", Pedido.class)
                 .getResultList();
    }
}