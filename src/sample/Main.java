package sample;

import generatePassword.PasswordGenerator;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

    }

    public static void main(String[] args) {

        PasswordGenerator passwordGenerator = new PasswordGenerator();
        passwordGenerator.orderOfMethods();
    }
}


