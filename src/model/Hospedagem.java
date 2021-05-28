package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Hospedagem implements Serializable {
    private Integer diasDeEstadia, valorDiaria;
    private Date checkIn, checkOut;
    private Conta contaRestaurante;
    private String formaPagamento;
    private IQuarto quarto;

    private ArrayList<IHospede> listaHospedes;

    public Hospedagem() {
        this.contaRestaurante = new Conta();
        this.listaHospedes = new ArrayList<>();
        this.checkIn = new Date();

    }

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
        listaHospedes.removeIf(obj -> Objects.equals(obj.getCpf(), cpf));
    }

    public ArrayList<IHospede> getListaHospedes() {
        return listaHospedes;
    }

    public double getValorTotal(){
        return contaRestaurante.getTotalConta() + diasDeEstadia*valorDiaria;
    }

    public String listarHospedes(){
        StringBuilder Builder = new StringBuilder();
        Builder.append("Nome ").append("(CPF | Email)\n");
        for(IHospede h : listaHospedes){
            Builder.append(h.getNome()).append(" (")
                    .append(h.getCpf()).append(" | ")
                    .append(h.getEmail()).append(")\n");
        }
        return Builder.toString();
    };



    public void addToConta(ItemConta item){
        this.contaRestaurante.addItem(item);
    }

    public void getRelatorioConta(){
        System.out.println(this.contaRestaurante.listarConta());
    }
}
