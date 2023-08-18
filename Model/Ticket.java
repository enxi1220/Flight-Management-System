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
public abstract class Ticket {
    protected String _ticketNo;
    protected Flight _flight;
    private boolean _isSold = false;    
    private boolean _isCancelled = false;
    
    public Ticket(Flight flight, int ticketCounter) {
        _flight = flight;
        _ticketNo = flight.getFlightNo() + "_" + TicketPrefix() + String.format("%1$" + 3 + "s", ticketCounter).replace(' ', '0');
    }
    
    public abstract String TicketType();

    public abstract String TicketDescription();

    protected abstract String TicketPrefix();

    public abstract double TicketPrice();
    
    public void AddToFlight() {
        _flight.AddTicket(this);
    }

    public String getTicketNo() {
        return _ticketNo;
    }

    public Flight getFlight() {
        return _flight;
    }
    
    public boolean IsSold(){
        return _isSold;
    }

    public void AssignToCustomer(Customer customer) {
        _isSold = true;
        customer.AddTicket(this);
    }
    
    public boolean IsCancelled(){
        return _isCancelled;
    }
    
    public void Cancel(){
        _isCancelled = true;
    }

}
