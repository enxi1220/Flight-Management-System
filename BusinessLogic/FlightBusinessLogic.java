/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightreservationsystem.BusinessLogic;

import flightreservationsystem.Model.*;
import flightreservationsystem.Storage.Database;

import java.util.List;

/**
 *
 * @author 
 */
public class FlightBusinessLogic {
    public static void CreateFlight(Flight flight){
        
        for (int i = 0; i <  flight.getFirstClassQty(); i++) {
            TicketFirstClass ticket = new TicketFirstClass(flight, i+1);
            ticket.AddToFlight();
        }
        
        for (int i = 0; i <  flight.getBusinessClassQty(); i++) {
            TicketBusinessClass ticket = new TicketBusinessClass(flight, i+1);
            ticket.AddToFlight();
        }
        
        for (int i = 0; i <  flight.getEconomyClassQty(); i++) {
            TicketEconomyClass ticket = new TicketEconomyClass(flight, i+1);
            ticket.AddToFlight();
        }
        
        Database.Flights
                .add(flight);
    }
    
    public static List<Flight> ReadFlights(){
        return Database.Flights;
    }
    
    public static Flight ReadFlight(int index){
        return Database.Flights
                       .get(index);
    }
    
    public static void DeleteFlight(Flight flight){
        Database.Flights
                .remove(flight);
        flight.Cancel();
    }

    public static boolean CheckExist(int index){
        List<Flight> Flights = ReadFlights();
        if(index >= Flights.size()){
            return false;
        }else{
            return true;
        }
    }

    public static boolean CheckTicketExist(int ticketNum, int flightNum){
        Flight flight = ReadFlight(flightNum);

        if(ticketNum >= flight.getTickets().size()){
            return false;
        }else{
            return true;
        }
    }
}
