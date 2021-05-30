package model;

import java.io.Serializable;

public class Endereco implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -6051853297410372690L;
	private String bairro;
    private String logradouro;
    private Integer numero;
    private Cidade cidade;

    public Endereco(String bairro, String cidade, String logradouro, String uf, Integer numero) {
        this.setBairro(bairro);
        this.setCidade(new Cidade(cidade, uf));
        this.setLogradouro(logradouro);
        this.setNumero(numero);
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getUf() {
        return getCidade().getUf();
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

}
