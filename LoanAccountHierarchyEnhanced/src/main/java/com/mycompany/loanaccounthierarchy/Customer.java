/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loanaccounthierarchy;
import java.util.ArrayList;

/**
 *
 * @author fatmaal-wasmi
 */
public class Customer {
    private String firstName;
    private String lastName;
    private String SSN;
    private ArrayList<LoanAccount> LoanAccount= new ArrayList<LoanAccount>();
    
   
    public Customer(String firstName, String lastName, String SSN) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.SSN = SSN;
    }
    

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSSN() {
        return SSN;
    }
    
    public void addLoanAccount(LoanAccount account)
    {
        LoanAccount.add(account);
    }
    
   
    public String printMonthlyReport(){
      
    String name_snn = "Account Report for Customer: " + firstName + " " + lastName + " with SSN " + SSN + "\n\n";
        for (LoanAccount account : LoanAccount) {
            name_snn += account.toString();
        }
        return name_snn;

       
    }
}
        
