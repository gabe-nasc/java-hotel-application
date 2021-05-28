package controller;

import view.MainView;

import java.awt.*;
import java.io.Serializable;

import static controller.Serializer.load;

public class MainController implements Serializable {
    public CadastroController cadastro = new CadastroController();
    public RestauranteController restaurante = new RestauranteController();
    public QuartoController quarto = new QuartoController();

    public static void main(String[] args) {
        Serializer serializer = new Serializer();
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

}
