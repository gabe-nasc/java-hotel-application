package controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serializer {
    private static MainController mainController;

    
    public static void save(){
        ObjectOutputStream output;

        try {
            output = new ObjectOutputStream(new FileOutputStream("data.ser"));
            output.writeObject(mainController);
            output.flush();
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static MainController load(){

        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("data.ser"));
            mainController = (MainController)input.readObject();

            input.close();
        } catch(Exception e) {
            e.printStackTrace();
            mainController = new MainController();
        }

        return mainController;
    }
}
