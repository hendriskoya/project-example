package netgloo.models;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Hendris on 9/10/2016.
 */
@Entity
@Table(name = "horario_funcionamento")
public class HorarioFuncionamento {

    private int id;
    private Horario domingo;
    private Horario segunda;
    private Horario terca;
    private Horario quarta;
    private Horario quinta;
    private Horario sexta;
    private Horario sabado;

    public HorarioFuncionamento() {
        this.domingo = new Horario(DiaDaSemana.DOMINGO);
        this.segunda = new Horario(DiaDaSemana.SEGUNDA);
        this.terca = new Horario(DiaDaSemana.TERCA);
        this.quarta = new Horario(DiaDaSemana.QUARTA);
        this.quinta = new Horario(DiaDaSemana.QUINTA);
        this.sexta = new Horario(DiaDaSemana.SEXTA);
        this.sabado = new Horario(DiaDaSemana.SABADO);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Horario getDomingo() {
        return domingo;
    }

    public void setDomingo(Horario domingo) {
        this.domingo = domingo;
    }

    public Horario getSegunda() {
        return segunda;
    }

    public void setSegunda(Horario segunda) {
        this.segunda = segunda;
    }

    public Horario getTerca() {
        return terca;
    }

    public void setTerca(Horario terca) {
        this.terca = terca;
    }

    public Horario getQuarta() {
        return quarta;
    }

    public void setQuarta(Horario quarta) {
        this.quarta = quarta;
    }

    public Horario getQuinta() {
        return quinta;
    }

    public void setQuinta(Horario quinta) {
        this.quinta = quinta;
    }

    public Horario getSexta() {
        return sexta;
    }

    public void setSexta(Horario sexta) {
        this.sexta = sexta;
    }

    public Horario getSabado() {
        return sabado;
    }

    public void setSabado(Horario sabado) {
        this.sabado = sabado;
    }
}
