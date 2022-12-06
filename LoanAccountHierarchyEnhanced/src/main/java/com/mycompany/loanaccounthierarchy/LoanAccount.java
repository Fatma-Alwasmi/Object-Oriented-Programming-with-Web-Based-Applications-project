/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loanaccounthierarchy;

/**
 *
 * @author fatmaal-wasmi
 */
public class LoanAccount {
    
    private double principle;
    private double annualInterestRate;
    private int months;

    //constructor
    public LoanAccount(double principle, double annualInterestRate, int months) {
        this.principle = principle;
        this.annualInterestRate = annualInterestRate;
        this.months = months;
    }
    
    public double calculateMonthlyPayment(){
        
        double monthlyInterest = (annualInterestRate/12)/100;
        double monthlyPayment = principle * ( monthlyInterest / (1 - Math.pow(1 + monthlyInterest, -months)));
        
        return monthlyPayment;
    }
    
    public double getPrinciple() {
        return principle;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public int getMonths() {
        return months;
    }
    
    @Override 
    public String toString(){
        return "principle: $" +String.format("%.2f",principle)  + "\n" + "Annual Interest Rate: " + 
        String.format("%.2f",annualInterestRate) + "%\n" + "Term of Loan in Months: " + months + "\n" + "Monthly Payment: $" 
        + Math.round(calculateMonthlyPayment()*100)/100.0 + "\n\n"; 
        
    } 
    
}
