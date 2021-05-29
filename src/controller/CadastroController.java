package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import model.*;

public class CadastroController implements Serializable {
	private List<Hospedagem> listaHospedagem = new ArrayList<>();

	//private Hospedagem temp = new Hospedagem();
	// public Integer novosHospedes;

	public void addHospedeToHospedagem(Hospede hospede, Integer numeroHospedagem){
		Hospedagem tmp = listaHospedagem.stream().filter(obj -> obj.getNumero().equals(numeroHospedagem)).findFirst().orElse(null);

		tmp.addHospede(hospede);
	}
	public void createHospede(String nome, String email, String cpf, String telefone, String endereco, String bairro, String cidade, String uf, Integer numeroEndereco, Integer numeroHospedagem) {
		Hospede hospede = new Hospede(cpf, nome, telefone, email, new Endereco(bairro, cidade, endereco, uf, numeroEndereco));
		addHospedeToHospedagem(hospede, numeroHospedagem);
	}
	
	public List<IHospede> getHospedes() {
		List<IHospede> tmp = new ArrayList<>();
		System.out.println("Inside getHospedes");
		for (Hospedagem h: this.listaHospedagem) {
			System.out.println(h.getCheckOut());
			if (h.getCheckOut() == null) {
				tmp.addAll(h.getListaHospedes());
			}
		}

		return tmp;
	}

	public Integer createHospedagem(IQuarto quarto, Integer numeroDeDias, Double valorDiaria){
		Hospedagem tmp = new Hospedagem(quarto, numeroDeDias, valorDiaria);

		this.listaHospedagem.add(tmp);

		return tmp.getNumero();
	}


    public Hospedagem getHospedagem(IHospede hospede) {
		for (Hospedagem hp: listaHospedagem) {
			if (hp.getListaHospedes().contains(hospede)){
				return hp;
			};
		}

		return null;
    };

	public void gerarRelatorioConta(Hospedagem hospedagem){
		hospedagem.getRelatorioConta();
	}

	public Hospedagem getHospedagem(IQuarto tmp) {
		return this.listaHospedagem.stream().filter(obj -> obj.getNumeroQuarto().equals(tmp.getNumero()) && obj.getCheckOut() == null).findFirst().orElse(null);
	}

    public void deleteHospede(IHospede tmp) {
		Hospedagem h = listaHospedagem.stream().filter(obj->obj.getListaHospedes().contains(tmp)).findFirst().orElse(null);
		if (h != null) {
			h.removeHospede(tmp.getCpf());
		}
    }

	public Hospedagem getHospedagem(Integer numeroHospedagem) {
		return listaHospedagem.stream().filter(obj->obj.getNumero().equals(numeroHospedagem)).findFirst().orElse(null);
	}

	public void deleteHospedagem(Integer numeroHospedagem) {
		listaHospedagem.stream().filter(obj -> obj.getNumero().equals(numeroHospedagem)).findFirst().orElse(null).liberaQuarto();
		listaHospedagem.removeIf(obj -> obj.getNumero().equals(numeroHospedagem));
	}
}
