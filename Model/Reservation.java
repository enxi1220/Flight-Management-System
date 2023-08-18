/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightreservationsystem.Model;

import flightreservationsystem.Helper.PrintHelper;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 
 */
public class Reservation {
    private Payment _payment;
    private List<Ticket> _tickets = new ArrayList<Ticket>();
    private Flight _flight;    
    private Customer _customer;
    private String _reservationNo;
    
    private static int _reservationNoCounter = 0;

    public Reservation(Customer customer, Payment payment, Flight flight, List<Ticket> tickets){
        _payment = payment;
        _flight = flight;
        _tickets = tickets;
        _customer = customer;
    }

    public static String NextReservationNo(){
        return "RESV"+ String.format("%1$" + 5 + "s", ++_reservationNoCounter).replace(' ', '0');
    }

    public String getReservationNo(){
        return _reservationNo;
    }
    
    public void setReservationNo(String reservationNo){
        _reservationNo = reservationNo;
    }
    
    public Payment getPayment(){
        return _payment;
    }
    
    public List<Ticket> getTickets(){
        return _tickets;
    }
    
    public Flight getFlight(){
        return _flight;
    }
    
    public Customer getCustomer(){
        return _customer;
    }
    
    public void DrawReservation() {
        System.out.printf(" %20s | %30s | %20s | %15.2f \n", _reservationNo, _customer.getCustomerName(), _flight.getFlightNo(), _payment.getPrice());
    }
    
    public void DrawReservationWithDetail() {
        System.out.println("\nReservation No. : " + _reservationNo);
        System.out.println("\nCustomer Details");
        System.out.println("----------------");
        System.out.println("Name           : " + _customer.getCustomerName());
        System.out.println("Passport No.   : " + _customer.getCustomerPassportNo());
        System.out.println("Phone          : " + _customer.getCustomerPhone());
        System.out.println("\nFlight Details");
        System.out.println("----------------");
        System.out.println("Flight No.  : " + _flight.getFlightNo());
        System.out.print("Price  : RM " );
        System.out.printf("%-15.2f \n", _payment.getPrice());
        System.out.print("Paid   : RM ");
        System.out.printf("%-15.2f \n", _payment.getPaid());
        System.out.print("Change : RM ");
        System.out.printf("%-15.2f \n\n", _payment.Change());
        
        PrintHelper.PrintLine();
        System.out.println("Reserved Tickets: ");
        for (Ticket ticket : _tickets) {
            System.out.println(" Ticket Type: " + ticket.TicketType() + "   Ticket No.: " + ticket.getTicketNo() + "   Ticket Status: " + (ticket.IsCancelled()? "Cancelled": "Available"));
        }
        PrintHelper.PrintLine();
    }

}
