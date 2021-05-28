package model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public class ItemConta implements Serializable {
    private final Date data;
    private IProduto produto;
    private Integer qtd;
    private Double preco;

    public ItemConta(Date data, IProduto produto, Integer qtd, Double preco) {
        this.data = data;
        this.produto = produto;
        this.qtd = qtd;
        this.preco = preco;
    }

    public IProduto getProduto() {
        return produto;
    }

    public void setProduto(IProduto produto) {
        this.produto = produto;
    }

    public Integer getQtd() {
        return qtd;
    }

    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }

    public Double getPreco() {
        return preco;
    }

    public String getData() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return formatter.format(this.data);
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
    // TODO: Listar items
    public String listarItem() {
        return getProduto().getNome() + ' ' + getPreco() + ' ' + getQtd() + ' ' + getData();
    }


    /*
    public void addProduto(IProduto produto){
        carrinhoProdutos.add(produto);
    }

    public void removeProduto(String nome){
        carrinhoProdutos.removeIf(obj -> Objects.equals(obj.getNome(), nome));
    }

    public double getTotalPedido(){
        double total = 0;
        for (IProduto produto : carrinhoProdutos) {
            total += produto.getPreco();
        }
        return total;
    }

    public String listarPedido(){
        StringBuilder Builder = new StringBuilder();
        Builder.append("PEDIDO (UUID): ").append(getId()).append("\n");
        for (IProduto p : carrinhoProdutos) {
            Builder.append(p.listarProduto());
        }
        Builder.append("Total: ").append(Math.round(getTotalPedido()*100)/100.0).append("\n");

        return Builder.toString();
    }

    public Date getData() {
        return data;
    }
    */
}
