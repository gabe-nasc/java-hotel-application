package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class CatalogoProdutos implements Serializable {
    private ArrayList<Categoria> listaCategorias = new ArrayList<>();

    public ArrayList<Categoria> getCategorias() {
        return listaCategorias;
    }

    public void addCategoriaProduto(Categoria categoria){
        listaCategorias.add(categoria);
    }

    public void removeProduto(String nome){
        listaCategorias.removeIf(obj -> Objects.equals(obj.getNome(), nome));
    }

    public String listarCatalogo(){
        StringBuilder tmp = new StringBuilder();
        tmp.append("-- CATALOGO RESTAURANTE --").append("\n");
        for (Categoria c : listaCategorias) {
            tmp.append(c.listarCategoria());
        }
        return tmp.toString();
    }
}
