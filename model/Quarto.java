public class Quarto implements IQuarto {
    int numero, categoria;
    boolean disponivel;
    double valor;

    public Quarto(int numero, int categoria, double valor) {
        this.numero = numero;
        this.categoria = categoria;
        this.valor = valor;
        this.disponivel = true;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public int getNumero() {
        return this.numero;
    }

    @Override
    public boolean isDisponivel() {
        return this.disponivel;
    }

    @Override
    public double getValor() {
        return this.valor;
    }

    @Override
    public int getCategoria() {
        return this.categoria;
    }
}
