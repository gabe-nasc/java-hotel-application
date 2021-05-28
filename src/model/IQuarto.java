package model;

public interface IQuarto {
    public Integer getNumero();
    public Integer getQtdVagas();
    public boolean isDisponivel();
    public void alocar();
    public void liberar();
    public String toString();
}
