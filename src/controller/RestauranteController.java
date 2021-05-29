package controller;

import model.*;

import java.io.Serializable;
import java.util.Date;

public class RestauranteController implements Serializable {
    private CatalogoProdutos catalogo = new CatalogoProdutos();

    public RestauranteController() {
        // Instanciando o menu default do restaurante
        Categoria comidas = new Categoria("Comidas");
        Categoria bebidas = new Categoria("Bebidas");

        comidas.addProduto(new Produto("Frango a Milanesa", 19.00));
        comidas.addProduto(new Produto("Alcatra (Churrasco)", 21.00));
        comidas.addProduto(new Produto("Peixe", 29.00));

        bebidas.addProduto(new Produto("Coca-Cola Lata", 4.00));
        bebidas.addProduto(new Produto("Agua sem Gas Garrafa", 3.00));
        bebidas.addProduto(new Produto("Vinho Tinto", 26.00));

        catalogo.addCategoriaProduto(comidas);
        catalogo.addCategoriaProduto(bebidas);
    }

    public CatalogoProdutos getCatalogo() {
        return catalogo;
    }

    public ItemConta generateItemConta(IProduto produto, Integer qtd){
        return new ItemConta(new Date(), produto, qtd, produto.getPreco());
    }
}
