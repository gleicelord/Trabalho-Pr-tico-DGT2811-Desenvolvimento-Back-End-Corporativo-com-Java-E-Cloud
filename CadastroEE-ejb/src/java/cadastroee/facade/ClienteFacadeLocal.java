package cadastroee.facade;

import cadastroee.model.Cliente;
import java.util.List;

public interface ClienteFacadeLocal {
    List<Cliente> findAll();
}
