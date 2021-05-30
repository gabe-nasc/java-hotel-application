package model;

import java.io.Serializable;

public class Produto implements IProduto, Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 4634123718223975739L;
	private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        this.setNome(nome);
        this.setPreco(preco);
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

}
