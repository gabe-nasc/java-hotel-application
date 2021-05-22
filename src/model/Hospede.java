public class Hospede implements IHospede{
    String cpf, nome, telefone, email;
    Endereco endereco;

    public Hospede(String cpf, String nome, String telefone, String email, Endereco endereco) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }

    @Override
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String listaInfoHospede(){
        StringBuilder Builder = new StringBuilder();
        Builder.append("Nome:   ").append(getNome()).append("\n")
                .append("CPF:    ").append(getCpf()).append("\n")
                .append("Email:  ").append(getEmail()).append("\n");
        return Builder.toString();
    };
}
