/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication2;
import java.util.HashMap;
/**
 *
 * @author limbo
 */
public class BankAccount {
    private int accountNumber;
    private int pin;
    private double balance;
    public HashMap<Integer, Integer> map = new HashMap<>();

    public BankAccount() {
    }
    

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public BankAccount(int accountNumber, int pin, double balance) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = balance;
        map.put(accountNumber, pin);
    }
    
    //Takes old balance - amount which becomes new balance.
    public void withdraw(double amount){
        System.out.println("Balance:"+getBalance());
        if (amount > balance){
        }
        else{
        balance -= amount;            
        }
    }
    
}
