package netgloo.services;

import netgloo.models.Credenciado;
import netgloo.models.CredenciadoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
@Transactional
public class CredenciadoServiceImpl implements CredenciadoService{

    @Autowired
    private CredenciadoDao credenciadoDao;

    @Override
    public void criarCredenciado(final Credenciado credenciado) {
        credenciadoDao.save(credenciado);
    }

    @Override
    public Credenciado findById(final Long id) {
        return credenciadoDao.findOne(id);
    }

    @Override
    public Iterable<Credenciado> findAll() {
        return credenciadoDao.findAll();
    }
}
