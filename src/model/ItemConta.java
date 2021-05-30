package model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ItemConta implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 8216462861809296502L;
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

    public String listarItem() {
        return getProduto().getNome() + ' ' + getPreco() + ' ' + getQtd() + ' ' + getData();
    }
}
