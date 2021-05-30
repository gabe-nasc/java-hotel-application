package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import model.CatalogoQuartos;
import model.CategoriaQuarto;
import model.IQuarto;

public class QuartoController implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 5370090482517271623L;
	private CatalogoQuartos catalogo;

    public QuartoController(){
        this.catalogo = new CatalogoQuartos();

        // Instanciando as categorias e quartos default do hotel
        catalogo.addCategoria("Standard", "Quartos ideiais para uma breve estadia.", 20D);
        catalogo.addCategoria("Plus", "Quartos para quem quer um pouco mais de conforto em sua estadia", 30D);
        catalogo.addCategoria("Deluxe", "Quartos para quem quer todo luxo e conforto.", 50D);

        catalogo.addQuarto(101, 2, "Standard");
        catalogo.addQuarto(102, 3, "Standard");
        catalogo.addQuarto(103, 4, "Standard");

        catalogo.addQuarto(201, 2, "Plus");
        catalogo.addQuarto(202, 3, "Plus");
        catalogo.addQuarto(203, 4, "Plus");

        catalogo.addQuarto(301, 3, "Deluxe");
        catalogo.addQuarto(302, 4, "Deluxe");
        catalogo.addQuarto(303, 5, "Deluxe");
    }

    public List<IQuarto> getQuartosDisponiveis(String nome){
        CategoriaQuarto ctg = this.catalogo.getCategoria(nome);

        return ctg.getQuartosDisponiveis();
    }

    public List<IQuarto> getQuartosOcupados(){
        List<IQuarto> all = new ArrayList<>();
        for (CategoriaQuarto ctg: this.catalogo.getCategorias()) {
            all.addAll(ctg.getQuartosOcupados());
        }

        return all;
    }

    public List<CategoriaQuarto> getCategorias() {
        return catalogo.getCategorias();
    }

    public List<String> getNomeCategorias() {
        List<String> tmp = new ArrayList<>();
        for (CategoriaQuarto ctg: catalogo.getCategorias()) {
            tmp.add(ctg.getNome());
        }

        return tmp;
    }

    public IQuarto alocaQuarto(Integer numero, String categoria){
        return catalogo.alocaQuarto(numero, categoria);
    }

    public Double getValorCategoria(String categoria){
        return catalogo.getCategoria(categoria).getTarifaDiaria();

    }

}
