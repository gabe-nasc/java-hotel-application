package model;

import java.util.Date;

public class Teste {
    public static void main(String[] args){
        /* Produto
        Produto p1 = new Produto("AAA", 2.98);
        Produto p2 = new Produto("BBB", 3.98);
        Produto p3 = new Produto("CCC", 4.98);
        Produto p4 = new Produto("DDD", 5.98);
        Produto p5 = new Produto("FFF", 6.98);

        // Categoria
        Categoria c1 = new Categoria("impar");
        Categoria c2 = new Categoria("par");

        c1.addProduto(p1);
        c1.addProduto(p3);
        c1.addProduto(p5);

        c2.addProduto(p2);
        c2.addProduto(p4);

        // Catalogo
        CatalogoProdutos clg = new CatalogoProdutos();
        clg.addCategoriaProduto(c1);
        clg.addCategoriaProduto(c2);

        System.out.println(clg.listarCatalogo());
        System.out.println("\n\n\n");

        // Pedido
        ItemConta pd1 = new ItemConta(new Date());
        ItemConta pd2 = new ItemConta(new Date());

        pd1.addProduto(p1);
        pd1.addProduto(p1);
        pd1.addProduto(p2);
        pd1.addProduto(p3);

        pd2.addProduto(p2);
        pd2.addProduto(p3);
        pd2.addProduto(p3);
        pd2.addProduto(p3);

        pd2.removeProduto("BBB");

        // Hospede
        Hospede h1 = new Hospede("1111", "Waldir", "1234", "waldir@gmail.com", new Endereco("A", "B", "C", "D"));
        Hospede h2 = new Hospede("2222", "Waldirene", "5678", "waldirene@gmail.com", new Endereco("A", "B", "C", "D"));
        Hospede h3 = new Hospede("3333", "Waldimar", "91011", "waldimar@gmail.com", new Endereco("A", "B", "C", "D"));

        // Quartos
        CatalogoQuartos ctg = new CatalogoQuartos();
        ctg.addQuarto(103, 1, 20.0);
        ctg.addQuarto(304, 2, 200.0);
        ctg.addQuarto(305, 2, 200.0);
        ctg.addQuarto(901, 3, 2000.0);

        // Hospedagem
        Hospedagem hospedagem = new Hospedagem();
        hospedagem.setCheckIn(new Date());

        hospedagem.addHospede(h1);
        hospedagem.addHospede(h2);
        hospedagem.addHospede(h3);

        ctg = hospedagem.reservaQuarto(2, ctg);
        ctg = hospedagem.reservaQuarto(2, ctg);
        ctg = hospedagem.reservaQuarto(3, ctg);

        hospedagem.contaRestaurante.addPedido(pd1);
        hospedagem.contaRestaurante.addPedido(pd2);

        hospedagem.setCheckOut(new Date());
        System.out.println(hospedagem.gerarRecibo("Dinheiro"));
        */

    }
}
