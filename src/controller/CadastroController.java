package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import model.Endereco;
import model.Hospedagem;
import model.Hospede;
import model.IHospede;

public class CadastroController implements Serializable {
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
	
	public List<IHospede> getHospedes() {
		List<IHospede> tmp = new ArrayList<>();
		for (Hospedagem h: this.hospedagem) {
			tmp.addAll(h.getListaHospedes());
		}

		return tmp;
	}

	public void createHospedagem(){
		this.hospedagem.add(temp);
		this.temp = new Hospedagem();
	}


    public Hospedagem getHospedagem(IHospede hospede) {
		for (Hospedagem hp: hospedagem) {
			if (hp.getListaHospedes().contains(hospede)){
				return hp;
			};
		}

		return null;
    };

	public void gerarRelatorioConta(Hospedagem hospedagem){
		hospedagem.getRelatorioConta();
	}
}
