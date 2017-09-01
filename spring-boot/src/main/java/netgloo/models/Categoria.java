package netgloo.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * An entity User composed by three fields (id, email, name).
 * The Entity annotation indicates that this class is a JPA entity.
 * The Table annotation specifies the name for the table in the db.
 *
 * @author netgloo
 */
@Entity
@Table(name = "categoria")
public class Categoria {

    // ------------------------
    // PRIVATE FIELDS
    // ------------------------

    // An autogenerated id (unique for each user in the db)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    // The user's email
    @NotNull
    private String nome;

    // ------------------------
    // PUBLIC METHODS
    // ------------------------

    public Categoria() {
    }

    public Categoria(long id) {
        this.id = id;
    }

    public Categoria(String nome) {
        this.nome = nome;
    }

    // Getter and setter methods

    public long getId() {
        return id;
    }

    public void setId(long value) {
        this.id = value;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
} // class User