/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightreservationsystem.Model;

/**
 *
 * @author 
 */
public class Payment {
    private double _price;
    private double _paid;
    
    public Payment(double price, double paid){
        _price = price;
        _paid = paid;
    }
    
    public double getPrice(){
        return _price;
    }
    
    public double getPaid(){
        return _paid;
    }
    
    public double Change(){
        return _paid - _price;
    }
}
