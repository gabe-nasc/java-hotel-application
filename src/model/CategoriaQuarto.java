package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CategoriaQuarto implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 6125486019347160895L;
	private String nome;
    private String descricao;
    private Double tarifaDiaria;
    private List<IQuarto> quartos;
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getTarifaDiaria() {
        return tarifaDiaria;
    }

    public void setTarifaDiaria(Double tarifaDiaria) {
        this.tarifaDiaria = tarifaDiaria;
    }

    public void addQuarto(Integer numero, Integer vagas){
        getQuartos().add(new Quarto(numero, vagas));
    }

    public void removeQuarto(Integer numero){
        getQuartos().removeIf(obj -> obj.getNumero().equals(numero));
    }

    public CategoriaQuarto(String nome, String descricao, Double tarifaDiaria) {
        this.nome = nome;
        this.descricao = descricao;
        this.tarifaDiaria = tarifaDiaria;
        
        this.quartos = new ArrayList<>();
    }

    public IQuarto alocaQuarto(Integer numeroQuarto) {
        IQuarto qt = getQuartos().stream().filter(obj -> obj.getNumero().equals(numeroQuarto)).findAny().orElse(null);
        if (qt == null) {
            return null;
        }

        qt.alocar();
        return qt;
    }

    public List<IQuarto> getQuartosOcupados() {
        return getQuartos().stream().filter(obj->!obj.isDisponivel()).collect(Collectors.toList());
    }

    public List<IQuarto> getQuartosDisponiveis() {
        return getQuartos().stream().filter(IQuarto::isDisponivel).collect(Collectors.toList());
    }

    public List<IQuarto> getQuartos() {
        return quartos;
    }
}
