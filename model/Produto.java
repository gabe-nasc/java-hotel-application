public class Produto implements IProduto {
    String nome;
    final String codBarras;
    double preco;

    public Produto(String nome, String codBarras, double preco) {
        this.nome = nome;
        this.codBarras = codBarras;
        this.preco = preco;
    }

    @Override
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String getCodBarras() {
        return codBarras;
    }

    @Override
    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String listarProduto(){
        StringBuilder Builder = new StringBuilder();
        Builder.append("CodBarras: ").append(this.getCodBarras()).append("\t")
                .append("Nome: ").append(this.getNome()).append('\t')
                .append("Valor: ").append(this.getPreco()).append("\n");

        return Builder.toString();
    }
}
