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
public class TicketEconomyClass extends Ticket {

    public TicketEconomyClass(flightreservationsystem.Model.Flight flight, int ticketCounter) {
        super(flight, ticketCounter);
    }
    
    @Override
    public String TicketType() {
        return "Economy Class";
    }

    @Override
    protected String TicketPrefix() {
        return "EC";
    }

    @Override
    public String TicketDescription() {
        return "Economy class ticket";
    }

    @Override
    public double TicketPrice() {
        return _flight.getEconomyClassPrice();
    }

}
