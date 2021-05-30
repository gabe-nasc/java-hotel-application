package controller;

import java.awt.EventQueue;
import java.io.Serializable;

import view.MainView;

public class MainController implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 3058378445360671412L;
	private CadastroController cadastro = new CadastroController();
    private RestauranteController restaurante = new RestauranteController();
    private QuartoController quarto = new QuartoController();

    public static void main(String[] args) {
        MainController mainController = Serializer.load();
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainView frame = new MainView(mainController);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public CadastroController getCadastro() {
        return cadastro;
    }

    public void setCadastro(CadastroController cadastro) {
        this.cadastro = cadastro;
    }

    public RestauranteController getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(RestauranteController restaurante) {
        this.restaurante = restaurante;
    }

    public QuartoController getQuarto() {
        return quarto;
    }

    public void setQuarto(QuartoController quarto) {
        this.quarto = quarto;
    }
}
