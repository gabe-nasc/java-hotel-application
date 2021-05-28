package controller;

import java.io.*;

public class Serializer {
    private static MainController mainController;

    
    public static void save(){
        ObjectOutputStream output;

        System.out.println("save");
        try {
            output = new ObjectOutputStream(new FileOutputStream("dados.ser"));
            output.writeObject(mainController);
            output.flush();
        }catch(Exception e) {
        	System.out.println("Deu Ruim");
            System.out.println(e.getMessage());
            System.out.println(e.toString());
        }

    }

    public static MainController load(){
        System.out.println("load");

        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("dados.ser"));
            mainController = (MainController)input.readObject();
            //mainController.listObj();

            input.close();
        } catch(Exception e) {
        	System.out.println("Deu Ruim");
            mainController = new MainController();
        }

        return mainController;
    }

//    public static void save(MainController ish)throws IOException {
//        String fileName= "Test.txt";
//        FileOutputStream fos = new FileOutputStream(fileName);
//        ObjectOutputStream oos = new ObjectOutputStream(fos);
//        oos.writeObject(ish);
//        oos.close();
//    }
//
//    public static MainController load(){
//        String fileName= "Test.txt";
//        System.out.println();
//        FileInputStream fin = null;
//        try {
//            fin = new FileInputStream(fileName);
//        } catch (FileNotFoundException e) {
//            System.out.println("fdsa");
//            return new MainController();
//        }
//        ObjectInputStream ois = null;
//        try {
//            ois = new ObjectInputStream(fin);
//        } catch (IOException e) {
//            System.out.println("tre");
//            e.printStackTrace();
//        }
//        MainController mc = null;
//        try {
//            assert ois != null;
//            mc = (MainController) ois.readObject();
//        } catch (IOException | ClassNotFoundException e) {
//            System.out.println("gfdsa");
//            e.printStackTrace();
//        }
//        try {
//            ois.close();
//        } catch (IOException e) {
//            System.out.println("jhgf");
//            e.printStackTrace();
//        }
//        return mc;
//    }
}
