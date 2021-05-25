package controller;

import java.util.ArrayList;
import java.util.List;

import model.Endereco;
import model.Hospedagem;
import model.Hospede;

public class CadastroController {
	List<Hospedagem> hospedagem = new ArrayList<>();

	private Hospedagem temp = new Hospedagem();
	public Integer novosHospedes;

	public Integer getNovosHospedes() {
		return novosHospedes;
	}

	public void setNovosHospedes(Integer novosHospedes) {
		this.novosHospedes = novosHospedes;
	}

	public void createHospede(String nome, String email, String cpf, String telefone, String endereco, String bairro, String cidade, String uf) {
		Hospede hospede = new Hospede(cpf, nome, telefone, email, new Endereco(bairro, cidade, endereco, uf));
		this.temp.addHospede(hospede);
	}
	
	public List<Hospede> getHospedes() {
		List<Hospede> tmp = new ArrayList<>();
		for (Hospedagem h: hospedagem) {
			tmp.addAll(h.getListaHospedes());
		}

		return tmp;
	}

	public void createHospedagem(){
		hospedagem.add(temp);

		this.temp = new Hospedagem();
	}

}
