package model;

import java.io.Serializable;
import java.util.Date;

public class Pagamento implements Serializable {
    Date data;
    Double value;
    ETipoPagamento tipo;

    public Pagamento(Date data, Double value, ETipoPagamento tipo) {
        this.data = data;
        this.value = value;
        this.tipo = tipo;
    }

    public Date getData() {
        return data;
    }

    public Double getValue() {
        return value;
    }

    public ETipoPagamento getTipo() {
        return tipo;
    }
}
