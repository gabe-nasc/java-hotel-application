package model;

import java.util.ArrayList;
import java.util.Objects;

public class Categoria {
    ArrayList<Produto> listaProdutos;
    String nome;

    public Categoria(String nome) {
        this.listaProdutos = new ArrayList<Produto>();
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
        for (Produto p : listaProdutos) {
            Builder.append(p.listarProduto());
        }
        
        return Builder.toString();
    };

    public void addProduto(Produto produto){
        listaProdutos.add(produto);
    }

    public void removeProduto(String codBarras){
        listaProdutos.removeIf(obj -> Objects.equals(obj.codBarras, codBarras));
    }
}
