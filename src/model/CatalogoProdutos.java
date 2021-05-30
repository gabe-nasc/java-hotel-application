package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class CatalogoProdutos implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 4394652138725956779L;
	private ArrayList<CategoriaProduto> listaCategoriaProdutos = new ArrayList<>();

    public ArrayList<CategoriaProduto> getCategorias() {
        return listaCategoriaProdutos;
    }

    public void addCategoriaProduto(CategoriaProduto categoriaProduto){
    	System.out.println("Adicionando: " + categoriaProduto);
        listaCategoriaProdutos.add(categoriaProduto);
    }

    public void removeProduto(String nome){
        listaCategoriaProdutos.removeIf(obj -> Objects.equals(obj.getNome(), nome));
    }

    public String listarCatalogo(){
        StringBuilder tmp = new StringBuilder();
        tmp.append("-- CATALOGO RESTAURANTE --").append("\n");
        for (CategoriaProduto c : listaCategoriaProdutos) {
            tmp.append(c.listarCategoria());
        }
        return tmp.toString();
    }
}
