package model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Hospedagem implements Serializable {
    private static Integer contador = 0;

    private final Integer numero;
    private Integer diasDeEstadia;
    private Double valorDiaria;
    private Date checkIn, checkOut;
    private Conta contaRestaurante;
    private Pagamento pagamento;
    private IQuarto quarto;

    private ArrayList<IHospede> listaHospedes;

    public Hospedagem(IQuarto quarto, Integer diasDeEstadia, Double valorDiaria) {
        this.checkIn = new Date();
        this.checkOut = null;
        this.contaRestaurante = new Conta();
        this.listaHospedes = new ArrayList<>();

        this.quarto = quarto;
        this.valorDiaria = valorDiaria;
        this.diasDeEstadia = diasDeEstadia;

        this.numero = contador;
        contador += 1;
    }

    public String getCheckIn() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return formatter.format(this.checkIn);
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        if (this.checkOut == null) {
            return null;
        }
        return formatter.format(this.checkOut);
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public void addHospede(Hospede h){
        System.out.println("Hospede: " + h);
        listaHospedes.add(h);
    }

    public void removeHospede(String cpf){
        listaHospedes.removeIf(obj -> Objects.equals(obj.getCpf(), cpf));
    }

    public ArrayList<IHospede> getListaHospedes() {
        return listaHospedes;
    }

    public double getValorTotal(){
        return contaRestaurante.getTotalConta() + diasDeEstadia*valorDiaria;
    }

    public Integer getDiasDeEstadia() {
        return diasDeEstadia;
    }

    public Double getValorDiaria() {
        return valorDiaria;
    }

    public List<ItemConta> getListaConta(){
        return contaRestaurante.getListaConta();
    }

    public String getResumoHospedagem(){
        StringBuilder Builder = new StringBuilder();
        Builder.append("Quarto: ").append(this.getNumeroQuarto()).append("\n");
        Builder.append("Data Check-In: ").append(this.getCheckIn()).append("\n");
        Builder.append("Valor da Diaria: ").append(this.getValorDiaria()).append("\n");
        Builder.append("Dias Hospedados: ").append(this.getDiasDeEstadia()).append("\n");
        Builder.append("-----------------------------------\n");
        for(IHospede h : listaHospedes){
            Builder.append("Nome: ").append(h.getNome()).append("\n")
                    .append("CPF: ").append(h.getCpf()).append("\n")
                    .append("Email: ").append(h.getEmail()).append("\n")
                    .append("-----------------------------------\n");
        }
        return Builder.toString();
    };



    public void addToConta(ItemConta item){
        this.contaRestaurante.addItem(item);
    }

    public void getRelatorioConta(){
        System.out.println(this.contaRestaurante.listarConta());
    }

    public Integer getNumeroQuarto() {
        return this.quarto.getNumero();
    }

    public Integer getNumero() {
        return this.numero;
    }

    public void removeItemConta(ItemConta wrong){
        contaRestaurante.removeItem(wrong);
    }

    public void liberaQuarto() {
        quarto.liberar();
    }

    public void setPagamento(Double valor, ETipoPagamento tipo) {
        this.pagamento = new Pagamento(new Date(), valor, tipo);
    }

}
