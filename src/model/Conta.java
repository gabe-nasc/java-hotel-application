import java.util.ArrayList;
import java.util.Objects;

public class Conta {
    ArrayList<Pedido> listaPedidos = new ArrayList<>();
    public void addPedido(Pedido pedido){
        listaPedidos.add(pedido);
    }
    public void removePedido(String id){
        listaPedidos.removeIf(obj -> Objects.equals(obj.id, id));
    }
    public double getTotalConta(){
        double total = 0;
        for (Pedido p : listaPedidos) {
            total += p.getTotalPedido();
        }

        return total;
    }

    public String listarConta(){
        StringBuilder Builder = new StringBuilder();

        for (Pedido p : listaPedidos) {
            Builder.append(p.listarPedido()).append("\n------------\n");
        }

        Builder.append("TOTAL CONTA DO RESTAURANTE: ")
                .append(getTotalConta()).append("\n");

        return Builder.toString();
    }
}
