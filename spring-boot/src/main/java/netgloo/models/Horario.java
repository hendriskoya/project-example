package netgloo.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by Hendris on 9/10/2016.
 */
@Entity
@Table(name = "horario")
public class Horario {

    private int id;
    private DiaDaSemana diaDaSemana;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Periodo> periodos;
    private boolean fechado;

    public Horario(final DiaDaSemana diaDaSemana) {
        this.diaDaSemana = diaDaSemana;
    }

    public DiaDaSemana getDiaDaSemana() {
        return diaDaSemana;
    }

    public void setDiaDaSemana(DiaDaSemana diaDaSemana) {
        this.diaDaSemana = diaDaSemana;
    }

    public List<Periodo> getPeriodos() {
        return periodos;
    }

    public void setPeriodos(List<Periodo> periodos) {
        this.periodos = periodos;
    }

    public boolean isFechado() {
        return fechado;
    }

    public void setFechado(boolean fechado) {
        this.fechado = fechado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
