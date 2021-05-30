package model;

import java.io.Serializable;

public class Hospede implements IHospede, Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -2925666865267255151L;
	final private String cpf;
    private String nome;
    private String telefone;
    private String email;
    private Endereco endereco;

    public Hospede(String cpf, String nome, String telefone, String email, Endereco endereco) {
        this.cpf = cpf;
        this.setNome(nome);
        this.setTelefone(telefone);
        this.setEmail(email);
        this.setEndereco(endereco);
    }

    @Override
    public String getCpf() {
        return cpf;
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

}
