package model;

import java.io.Serializable;

public class Quarto implements IQuarto, Serializable {
    private Integer numero, vagas;
    private boolean disponivel;

    public Quarto(Integer numero, Integer vagas) {
        this.numero = numero;
        this.disponivel = true;
        this.vagas = vagas;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void liberar() {
        this.disponivel = true;
    }

    public void alocar() {
        this.disponivel = false;
    }

    @Override
    public Integer getNumero() {
        return this.numero;
    }

    @Override
    public Integer getQtdVagas() {
        return this.vagas;
    }

    @Override
    public boolean isDisponivel() {
        return this.disponivel;
    }

}
