package controller;

import view.MainView;

import java.awt.*;

public class MainController {
    CadastroController cadastro = new CadastroController();
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainView frame = new MainView();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
