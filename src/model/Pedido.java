package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public class Pedido {
    ArrayList<Produto> carrinhoProdutos;
    Date data;

    public String getId() {
        return id;
    }

    final String id = UUID.randomUUID().toString().replace("-", "");


    public Pedido(Date data) {
        this.data = data;
        this.carrinhoProdutos = new ArrayList<>();
    }

    public void addProduto(Produto produto){
        carrinhoProdutos.add(produto);
    }

    public void removeProduto(String codBarras){
        carrinhoProdutos.removeIf(obj -> Objects.equals(obj.codBarras, codBarras));
    }

    public double getTotalPedido(){
        double total = 0;
        for (Produto produto : carrinhoProdutos) {
            total += produto.getPreco();
        }
        return total;
    }

    public String listarPedido(){
        StringBuilder Builder = new StringBuilder();
        Builder.append("PEDIDO (UUID): ").append(getId()).append("\n");
        for (Produto p : carrinhoProdutos) {
            Builder.append(p.listarProduto());
        }
        Builder.append("Total: ").append(Math.round(getTotalPedido()*100)/100.0).append("\n");

        return Builder.toString();
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
