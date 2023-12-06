/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication2;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;

/**
 *
 * @author limbo
 */
public class JavaApplication2 extends Application{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        launch(args);
        
    }

    @Override
    public void start(Stage stage)  {
        ATM atm = new ATM();
        BankAccount account1 = new BankAccount(1234,1234,2000);
        atm.setAccount(account1);
        atm.start(stage);
    }
    
}
