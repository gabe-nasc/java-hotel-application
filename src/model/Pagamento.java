package model;

import java.io.Serializable;
import java.util.Date;

public class Pagamento implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -2581897276928429239L;
	private Date data;
    private Double value;
    private ETipoPagamento tipo;

    public Pagamento(Date data, Double value, ETipoPagamento tipo) {
        this.setData(data);
        this.setValue(value);
        this.setTipo(tipo);
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

    public void setData(Date data) {
        this.data = data;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public void setTipo(ETipoPagamento tipo) {
        this.tipo = tipo;
    }
}
