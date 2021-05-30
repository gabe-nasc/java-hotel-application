package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Conta implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -1002896276333727635L;
	private ArrayList<ItemConta> listaItemContas = new ArrayList<>();

    public void addItem(ItemConta itemConta){
        listaItemContas.add(itemConta);
    }

    public void removeItem(ItemConta itemConta){
        listaItemContas.remove(itemConta);
    }

    public double getTotalConta(){
        double total = 0;
        for (ItemConta p : listaItemContas) {
            total += p.getPreco()*p.getQtd();
        }

        return total;
    }

    public String listarConta(){
        StringBuilder Builder = new StringBuilder();

        for (ItemConta p : listaItemContas) {
            Builder.append(p.listarItem()).append("\n------------\n");
        }

        Builder.append("TOTAL CONTA DO RESTAURANTE: ")
                .append(getTotalConta()).append("\n");

        return Builder.toString();
    }

    public List<ItemConta> getListaConta() {
        return this.listaItemContas;
    }
}
