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
public class TicketFirstClass extends Ticket{
    public TicketFirstClass(flightreservationsystem.Model.Flight flight, int ticketCounter) {
        super(flight, ticketCounter);
    }

    @Override
    public String TicketType() {
        return "First Class";
    }

    @Override
    protected String TicketPrefix() {
        return "FC";
    }

    @Override
    public String TicketDescription() {
        return "First class ticket";
    }

    @Override
    public double TicketPrice() {
        return _flight.getFirstClassPrice();
    }
}
