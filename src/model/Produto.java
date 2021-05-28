package model;

import java.io.Serializable;

public class Produto implements IProduto, Serializable {
    String nome;
    double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String listarProduto(){
        StringBuilder Builder = new StringBuilder();
        Builder.append("Nome: ").append(this.getNome()).append('\t')
                .append("Valor: ").append(this.getPreco()).append("\n");

        return Builder.toString();
    }
}
