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
public class TicketBusinessClass extends Ticket {

    public TicketBusinessClass(flightreservationsystem.Model.Flight flight, int ticketCounter) {
        super(flight, ticketCounter);
    }

    @Override
    public String TicketType() {
        return "Business Class";
    }

    @Override
    protected String TicketPrefix() {
        return "BC";
    }

    @Override
    public String TicketDescription() {
        return "Business class ticket";
    }

    @Override
    public double TicketPrice() {
        return _flight.getBusinessClassPrice();
    }
}
