public class Endereco {
    String bairro;
    String cidade;
    String logradouro;
    String uf;

    public Endereco(String bairro, String cidade, String logradouro, String uf) {
        this.bairro = bairro;
        this.cidade = cidade;
        this.logradouro = logradouro;
        this.uf = uf;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
}
