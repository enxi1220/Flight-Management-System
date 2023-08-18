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
public class Transaction {
    private Customer _customer;
    private Ticket _ticket;
    private Payment _payment;
    private Reservation _reservation;
    
    public Transaction(Customer customer, Ticket ticket, Payment payment, Reservation reservation){
        _customer = customer;
        _ticket = ticket;
        _payment = payment;
        _reservation = reservation;
    }
//    getter
    public Customer getCustomer(){
        return _customer;
    }
    
    public Ticket getTicket(){
        return _ticket;
    }
    
    public Payment getPayment(){
        return _payment;
    }
    
    public Reservation getReservation(){
        return _reservation;
    }
}
