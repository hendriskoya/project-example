package netgloo.services;

import com.websystique.springmvc.model.User;
import netgloo.models.Credenciado;

import java.util.List;


public interface CredenciadoService {

    void criarCredenciado(final Credenciado credenciado);

    Credenciado findById(Long id);

    Iterable<Credenciado> findAll();
}
