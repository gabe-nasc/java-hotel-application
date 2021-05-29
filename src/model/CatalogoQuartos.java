package model;

import javax.swing.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CatalogoQuartos implements Serializable {
    private List<CategoriaQuarto> categorias;

    public CatalogoQuartos() {
        this.categorias = new ArrayList<CategoriaQuarto>();
    }

    public CategoriaQuarto getCategoria(String nome){
        return categorias.stream().filter(obj -> obj.getNome().equals(nome)).findFirst().orElse(null);
    };

    public void addCategoria(String nome, String descricao, Double tarifa){
        categorias.add(new CategoriaQuarto(nome, descricao, tarifa));
    }

    public void removeCategoria(String nome){
        categorias.removeIf(obj -> obj.getNome().equals(nome));
    }

    public void addQuarto(Integer numero, Integer vagas, String categoria){
        CategoriaQuarto tmp = categorias.stream().filter(ctg -> ctg.getNome().equals(categoria)).findFirst().orElse(null);
        if (tmp != null){
            tmp.addQuarto(numero, vagas);
        }
    }

    public IQuarto alocaQuarto(Integer numeroQuarto, String categoria){
        CategoriaQuarto ctg = getCategoria(categoria);

        return ctg.alocaQuarto(numeroQuarto);
    }

    public List<CategoriaQuarto> getCategorias() {
        return this.categorias;
    }

}
