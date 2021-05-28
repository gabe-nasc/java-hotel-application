package controller;

import model.*;

import java.io.Serializable;
import java.util.Date;

public class RestauranteController implements Serializable {
    private CatalogoProdutos catalogo = new CatalogoProdutos();

    public CatalogoProdutos getCatalogo() {
        return catalogo;
    }

    public RestauranteController() {
        // Instanciando o menu default do restaurante
        Categoria comidas = new Categoria("Comidas");
        Categoria bebidas = new Categoria("Bebidas");

        comidas.addProduto(new Produto("Frango a Milanesa", 19.90));
        comidas.addProduto(new Produto("Alcatra (Churrasco)", 21.90));
        comidas.addProduto(new Produto("Salmão", 29.90));

        bebidas.addProduto(new Produto("Coca-Cola Lata 300ml", 4.90));
        bebidas.addProduto(new Produto("Agua sem Gás Garrafa 500ml", 3.90));
        bebidas.addProduto(new Produto("Vinho Tinto 1.5L", 26.90));

        catalogo.addCategoriaProduto(comidas);
        catalogo.addCategoriaProduto(bebidas);
    }

    public ItemConta generateItemConta(IProduto produto, Integer qtd){
        return new ItemConta(new Date(), produto, qtd, produto.getPreco());
    }
}
