package controller;

import java.io.Serializable;
import java.util.Date;

import model.CatalogoProdutos;
import model.CategoriaProduto;
import model.IProduto;
import model.ItemConta;
import model.Produto;

public class RestauranteController implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -4844632478226241139L;
	private CatalogoProdutos catalogo = new CatalogoProdutos();

    public RestauranteController() {
        // Instanciando o menu default do restaurante
    	System.out.println("Instanciando restaurante");
        CategoriaProduto comidas = new CategoriaProduto("Comidas");
        CategoriaProduto bebidas = new CategoriaProduto("Bebidas");

        comidas.addProduto(new Produto("Frango a Milanesa", 19.00));
        comidas.addProduto(new Produto("Alcatra", 21.00));
        comidas.addProduto(new Produto("Peixe", 29.00));

        bebidas.addProduto(new Produto("Coca-Cola Lata", 4.00));
        bebidas.addProduto(new Produto("Agua sem Gas", 3.00));
        bebidas.addProduto(new Produto("Vinho Tinto", 26.00));

        catalogo.addCategoriaProduto(comidas);
        catalogo.addCategoriaProduto(bebidas);
        System.out.println("Depois de adicionar pro catalogo");
    }

    public CatalogoProdutos getCatalogo() {
        return catalogo;
    }

    public ItemConta generateItemConta(IProduto produto, Integer qtd){
        return new ItemConta(new Date(), produto, qtd, produto.getPreco());
    }
}
