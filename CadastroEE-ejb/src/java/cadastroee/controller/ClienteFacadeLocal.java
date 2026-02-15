package cadastroee.controller;

import cadastroee.model.Cliente;
import java.util.List;

public interface ClienteFacadeLocal {
    List<Cliente> findAll();
}
