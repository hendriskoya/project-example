package netgloo.controllers;

import netgloo.models.Credenciado;
import netgloo.models.Endereco;
import netgloo.models.User;
import netgloo.models.UserDao;
import netgloo.services.CredenciadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * A class to test interactions with the MySQL database using the UserDao class.
 *
 * @author netgloo
 */
@RestController
@RequestMapping("/credenciado")
public class CredenciadoController {

    // ------------------------
    // PUBLIC METHODS
    // ------------------------
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(String nome, String descricao, String logradouro) {
        Credenciado credenciado = null;
        try {
            Endereco endereco = new Endereco();
            endereco.setLogradouro(logradouro);

            credenciado = new Credenciado(nome, descricao, endereco);
            credenciadoService.criarCredenciado(credenciado);
        } catch (Exception ex) {
            return "Error creating the credenciado: " + ex.toString();
        }
        return "ok " + credenciado.getId();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Credenciado get(@PathVariable Long id) {
        final Credenciado credenciado = credenciadoService.findById(id);
        if (credenciado == null) {
            throw new CredenciadoNotFoundException(id);
        }
        return credenciado;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Credenciado> all() {
        //TODO Incluir paginação
        return credenciadoService.findAll();
    }

    /**
     * /delete  --> Delete the user having the passed id.
     *
     * @param id The id of the user to delete
     * @return A string describing if the user is succesfully deleted or not.
     */
    @RequestMapping("/delete")
    @ResponseBody
    public String delete(long id) {
        try {
            User user = new User(id);
            userDao.delete(user);
        } catch (Exception ex) {
            return "Error deleting the user:" + ex.toString();
        }
        return "User succesfully deleted!";
    }

    /**
     * /get-by-email  --> Return the id for the user having the passed email.
     *
     * @param email The email to search in the database.
     * @return The user id or a message error if the user is not found.
     */
    @RequestMapping("/get-by-email")
    @ResponseBody
    public String getByEmail(String email) {
        String userId;
        try {
            User user = userDao.findByEmail(email);
            userId = String.valueOf(user.getId());
        } catch (Exception ex) {
            return "User not found";
        }
        return "The user id is: " + userId;
    }

    @RequestMapping("/{id}")
    @ResponseBody
    public User getById(@PathVariable("id") String id) {
        User user;
        try {
            user = userDao.findOne(Long.valueOf(id));
        } catch (Exception ex) {
            return null;
        }
        return user;
    }

    /**
     * /update  --> Update the email and the name for the user in the database
     * having the passed id.
     *
     * @param id    The id for the user to update.
     * @param email The new email.
     * @param name  The new name.
     * @return A string describing if the user is succesfully updated or not.
     */
    @RequestMapping("/update")
    @ResponseBody
    public String updateUser(long id, String email, String name) {
        try {
            User user = userDao.findOne(id);
            user.setEmail(email);
            user.setName(name);
            userDao.save(user);
        } catch (Exception ex) {
            return "Error updating the user: " + ex.toString();
        }
        return "User succesfully updated!";
    }

    // ------------------------
    // PRIVATE FIELDS
    // ------------------------

    @Autowired
    private UserDao userDao;

    @Autowired
    private CredenciadoService credenciadoService;
} // class UserController