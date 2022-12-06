/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loanaccounthierarchy;

/**
 *
 * @author fatmaal-wasmi
 */
public class Address {
    
    private String Address;
    private String city;
    private String state;
    private String zipcode;
    
    public Address(String Address, String city, String state, String zipcode){
        this.Address = Address;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }

    public String getAddress() {
        return Address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipcode() {
        return zipcode;
    }
       
    @Override
    public String toString(){
        return "  " + Address + "\n  " + city + ", " + state + " " + zipcode;
        }
}
