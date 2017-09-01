package netgloo.models;

/**
 * Created by Hendris on 9/10/2016.
 */
public enum DiaDaSemana {

    DOMINGO(1),
    SEGUNDA(2),
    TERCA(3),
    QUARTA(4),
    QUINTA(5),
    SEXTA(6),
    SABADO(7);

    private final int id;

    private DiaDaSemana(final int id) {
        this.id = id;
    }
}
