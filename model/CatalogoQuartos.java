import java.util.ArrayList;

public class CatalogoQuartos {
    ArrayList<Quarto> listaQuartos;

    public CatalogoQuartos() {
        this.listaQuartos = new ArrayList<Quarto>();
    }

    public void addQuarto(int numero, int categoria, double valor){
        listaQuartos.add(new Quarto(numero, categoria, valor));
    }

     public void removeQuarto(int numero){
        listaQuartos.removeIf(obj -> obj.numero == numero);
     }
}