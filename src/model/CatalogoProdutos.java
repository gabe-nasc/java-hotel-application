package model;

import java.util.ArrayList;
import java.util.Objects;

public class CatalogoProdutos {
    ArrayList<Categoria> listaCategorias = new ArrayList<>();

    public void addCategoriaProduto(Categoria categoria){
        listaCategorias.add(categoria);
    }

    public void removeProduto(String nome){
        listaCategorias.removeIf(obj -> Objects.equals(obj.nome, nome));
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
