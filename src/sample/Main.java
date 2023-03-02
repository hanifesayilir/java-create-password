package sample;

import generatePassword.GeneratePasswordDto;
import generatePassword.PasswordGenerator;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

    }
    private static Originator originator;

    private static Memento memento;

    public static void main(String[] args) {
       /* originator = new Originator("state-0");
        memento = originator.getMemento();
        */

        PasswordGenerator passwordGenerator = new PasswordGenerator();
        GeneratePasswordDto generatePasswordDto = new GeneratePasswordDto();
        String l = passwordGenerator.Generate(generatePasswordDto);
        System.out.println("L"+l);


    }

   /* static class OriginatorTrigger extends Thread {
        public void run() {
            for( int i = 1; )

        }

    }*/

}


