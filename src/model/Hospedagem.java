import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Hospedagem {
    Date checkIn, checkOut;
    Conta contaRestaurante = new Conta();
    String formaPagamento;
    ArrayList<Hospede> listaHospedes = new ArrayList<>();
    ArrayList<Quarto> quartosReservados = new ArrayList<>();

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public void addHospede(Hospede h){
        listaHospedes.add(h);
    }

    public void removeHospede(String cpf){
        listaHospedes.removeIf(obj -> Objects.equals(obj.cpf, cpf));
    }

    public CatalogoQuartos reservaQuarto(int categoria, CatalogoQuartos ctg){
        for (Quarto q : ctg.listaQuartos){
            if(q.categoria == categoria && q.disponivel){
                q.setDisponivel(false);
                quartosReservados.add(q);

                return ctg;
            };
        };

        return ctg;
    };

    public double getValorTotal(){
        double total = contaRestaurante.getTotalConta();

        for(Quarto q : quartosReservados){
            total += q.getValor();
        };
        return total;
    }

    public CatalogoQuartos limpaQuartos(int numero, CatalogoQuartos ctg){
        for (Quarto q : ctg.listaQuartos) {
            if (quartosReservados.contains(q)){
               q.setDisponivel(true);
            }
        };

        return ctg;
    }
    public String listarHospedes(){
        StringBuilder Builder = new StringBuilder();
        Builder.append("Nome ").append("(CPF | Email)\n");
        for(Hospede h : listaHospedes){
            Builder.append(h.getNome()).append(" (")
                    .append(h.getCpf()).append(" | ")
                    .append(h.getEmail()).append(")\n");
        }
        return Builder.toString();
    };

    public String listarQuartos(){
        StringBuilder Builder = new StringBuilder();
        Builder.append("Numero ").append("(Categoria | Valor)\n");
        for(Quarto q : quartosReservados){
            Builder.append(q.getNumero()).append(" (")
                    .append(q.getCategoria()).append(" | R$")
                    .append(q.getValor()).append(")\n");
        }
        return Builder.toString();
    }

    public String gerarRecibo(String pgt){
        StringBuilder Builder = new StringBuilder();
        Builder.append("\t-- RECIBO DA HOSPEDAGEM --\n")
                .append(listarHospedes()).append("------------\n")
                .append(listarQuartos()).append("------------\n")
                .append(contaRestaurante.listarConta()).append("------------\n")
                .append("VALOR TOTAL DA HOSPEDAGEM: ").append(getValorTotal());


        return Builder.toString();
    }
}
