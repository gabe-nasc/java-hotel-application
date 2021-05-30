package model;

import java.io.Serializable;
import java.util.ArrayList;

public class CategoriaProduto implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -3996405795224563777L;
	private ArrayList<IProduto> listaProdutos;
    private String nome;

    public ArrayList<IProduto> getProdutos() {
        return listaProdutos;
    }

    public CategoriaProduto(String nome) {
        this.listaProdutos = new ArrayList<IProduto>();
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String listarCategoria(){
        StringBuilder Builder = new StringBuilder();
        Builder.append(getNome()).append(":\n");
        for (IProduto p : listaProdutos) {
            Builder.append("Nome: " + p.getNome() + '\t' + "Valor: " + p.getPreco() + '\n');
        }
        
        return Builder.toString();
    };

    public void addProduto(IProduto produto){
        listaProdutos.add(produto);
    }

    public void removeProduto(IProduto produto){
        listaProdutos.remove(produto);
    }
}
