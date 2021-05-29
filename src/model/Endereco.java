package model;

import java.io.Serializable;

public class Endereco implements Serializable {
    private String bairro;
    private String logradouro;
    private Cidade cidade;

    public Endereco(String bairro, String cidade, String logradouro, String uf) {
        this.setBairro(bairro);
        this.setCidade(new Cidade(cidade, uf));
        this.setLogradouro(logradouro);
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

}
