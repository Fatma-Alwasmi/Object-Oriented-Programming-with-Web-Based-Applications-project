/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loanaccounthierarchy;

/**
 *
 * @author fatmaal-wasmi
 */
public class PrimaryMortgage extends LoanAccount {
    
    private double PMIMonthAmount;
    private Address Address;
    
    public PrimaryMortgage(double principle, double annualInterestRate, int months, double PMIMonthAmount, Address Address) {
        super(principle, annualInterestRate, months);
        this.PMIMonthAmount = PMIMonthAmount;
        this.Address = Address;
    }
        
    @Override
    public String toString(){
        return "\nPrimary Mortgage Loan with:\n" + super.toString() + "PMI Monthly Amount: $" + PMIMonthAmount + "\nProperty Address: \n" + Address + "\n";
    }    
    
}
