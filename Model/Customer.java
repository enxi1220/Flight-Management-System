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
public class Customer {
    private String _customerName;
    private String _customerPassportNo;
    private String _customerPhone;
//    no-arg constructor
    public Customer(){}
//every setter
    public Customer(String customerName, String customerPassportNo, String customerPhone) {
        _customerName = customerName;
        _customerPassportNo = customerPassportNo;
        _customerPhone = customerPhone;
    }

    private List<Ticket> _tickets = new ArrayList<Ticket>();

    public void AddTicket(Ticket ticket) {
        _tickets.add(ticket);
    }

    public List<Ticket> Tickets() {
        return _tickets;
    }

    public void setCustomerName(String customerName) {
        _customerName = customerName;
    }

    public void setCustomerPassportNo(String customerPassportNum) {
        _customerPassportNo = customerPassportNum;
    }

    public void setCustomerPhone(String customerPhone){
        _customerPhone = customerPhone;
    }

    public String getCustomerName() {
        return _customerName;
    }
    public String getCustomerPassportNo() {
        return _customerPassportNo;
    }

    public String getCustomerPhone() {
        return _customerPhone;
    }

    public void DrawCustomer() {
        System.out.printf(" %30s | %30s | %30s \n", _customerName, _customerPassportNo, _customerPhone);
    }

    public void DrawCustomerWithDetail() {
        System.out.println("\nCustomer Details");
        System.out.println("----------------");
        System.out.println("Name: " + _customerName);
        System.out.println("Passport Number: " + _customerPassportNo);
        System.out.println("Contact No.: " + _customerPhone);
        System.out.println();
        PrintHelper.PrintLine();
        System.out.println("Customer Tickets: ");
        for (Ticket ticket : _tickets) {
            System.out.println("Flight No: " + ticket.getFlight().getFlightNo() + "   Ticket Type: " + ticket.TicketType() + "   Ticket No.: " + ticket.getTicketNo() + "   Ticket Status: " + (ticket.IsCancelled() ? "Cancelled" : "Available"));
        }
        PrintHelper.PrintLine();
    }
}
