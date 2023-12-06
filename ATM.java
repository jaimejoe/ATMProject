/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author limbo
 */
public class ATM extends Application {
    private BankAccount account;
    
    @Override
    public void start(Stage stage)  {
        //First slide, must input account number and pin
        GridPane inputPin = new GridPane();
        inputPin.setAlignment(Pos.CENTER);
        Scene start = new Scene(inputPin,300,300);
        
        //Withdrawal Scene
        GridPane with = new GridPane();
        Scene wth = new Scene(with,300,300);
        with.setAlignment(Pos.CENTER);
        
        //Choose between Withdrawal and Balance amount
        GridPane select = new GridPane();
        select.setAlignment(Pos.CENTER);
        Scene selection = new Scene(select,300,300);
        
        //Balance scene
        GridPane viewBal = new GridPane();        
        viewBal.setAlignment(Pos.CENTER);
        Scene view = new Scene(viewBal,300,300);
        
        
        //Adding text,buttons and fields to first scene(input one)        
        Label enterNum = new Label("Enter Account Number:");
        TextField number = new TextField();
        Label label = new Label("Enter Pin:");
        Label message = new Label();
        Button button = new Button("Enter");
        PasswordField pass = new PasswordField();
        
        inputPin.add(enterNum, 0, 0);
        inputPin.add(number,1,0);
        inputPin.add(label,0,1);
        inputPin.add(pass,1,1);
        inputPin.add(message, 0, 3);
        inputPin.add(button, 3, 3);
        
        //Adding buttons to the selection menu
        Button selectWith = new Button("Withdraw");
        Button selectView = new Button("View Balance");
        select.add(selectWith, 0, 0);
        select.add(selectView,1,0);
        
        //Input amount to withdraw, displays new balance
        TextField wthEnter = new TextField();
        Label wthAmount = new Label("Balance: "+ account.getBalance());
        with.add(wthEnter, 0, 1);
        with.add(wthAmount, 0, 0);
        
        //displays balance 
        Label viewAmount = new Label("Balance: "+ account.getBalance());
        viewBal.add(viewAmount, 0, 0);
        
        stage.setScene(start);
        
        //When Withdrawal option picked, goes to the scene
        selectWith.setOnAction((ActionEvent r) -> {
                stage.setScene(wth);
                });
        
        //When Balance option picked, goes to the scene
        selectView.setOnAction((ActionEvent t) -> {
                stage.setScene(view);
                });
        
        //When account number and pin entered, press the button to confirm.
        //It will look over the hashmap in the BankAccount class
        button.setOnAction((ActionEvent e) -> {
            int numberEntered = Integer.parseInt(number.getText());
            int pinEntered = Integer.parseInt(pass.getText());
            if (account.map.containsKey(numberEntered)) {
                int pinPassword = account.map.get(pinEntered);                
                if (pinEntered == pinPassword) {          
                stage.setScene(selection);
                
            pass.clear();
        }
    }
        });
        //Withdrawing
        wthEnter.setOnAction((ActionEvent ) -> {
        //Cannot go over the balance amount
        Label zero = new Label("Cannot Withdraw Anymore");          
        account.withdraw(Double.parseDouble(wthEnter.getText()));
        
        int count = 0;
        count++;
        
        wthAmount.setText("Balance: " + account.getBalance());
        
        if (account.getBalance() == 0){
            with.add(zero, 1, 0);           
        }
        //everytime a withdrawal is made, a prompt to leave or continue appears
        if (count == 1){
            GridPane leave = new GridPane();
            leave.setAlignment(Pos.CENTER);
            Scene stop = new Scene(leave,300,300);
            stage.setScene(stop);
            Button yes = new Button ("Yes");
            Button no = new Button("No");
            Label wantToLeave = new Label ("Do you want to leave?");
            leave.add(yes, 1,0);
            leave.add(no, 1, 1);
            leave.add(wantToLeave, 0, 0);
            yes.setOnAction((ActionEvent y) -> {
                stage.setScene(start);
            });
            no.setOnAction((ActionEvent n) -> {
                stage.setScene(selection);
            });
        }
        });
            
        
        stage.show();
        
    }
   //choose account since I could not figure out how to do hash in the main.
    public void setAccount(BankAccount account){
        this.account = account;
    }
}
