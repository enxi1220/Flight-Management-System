/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightreservationsystem.Model;

import flightreservationsystem.Helper.PrintHelper;

import java.util.ArrayList;
import java.util.List;
import static java.util.stream.Collectors.toList;

/**
 *
 * @author 
 */
public class Flight {

    private String _flightNo;
    private String _departLocation;
    private String _arriveLocation;
    private List<Ticket> _tickets = new ArrayList<Ticket>();
    private int _firstClassQty;
    private int _businessClassQty;
    private int _economyClassQty;
    private double _firstClassPrice;
    private double _businessClassPrice;
    private double _economyClassPrice;
    private boolean _isCancelled;

    public Flight(String flightNo, String departLoc, String arriveLoc, int firstClassQty, double firstClassPrice, int businessClassQty, double businessClassPrice, int economyClassQty, double economyClassPrice) {
        _flightNo = flightNo;
        _departLocation = departLoc;
        _arriveLocation = arriveLoc;
        _firstClassQty = firstClassQty;
        _businessClassQty = businessClassQty;
        _economyClassQty = economyClassQty;
        _firstClassPrice = firstClassPrice;
        _businessClassPrice = businessClassPrice;
        _economyClassPrice = economyClassPrice;
    }
//getter

    public String getDepartLocation() {
        return _departLocation;
    }

    public String getArriveLocation() {
        return _arriveLocation;
    }

    public int getFirstClassQty() {
        return _firstClassQty;
    }

    public int getBusinessClassQty() {
        return _businessClassQty;
    }

    public int getEconomyClassQty() {
        return _economyClassQty;
    }

    public String getFlightNo() {
        return _flightNo;
    }

    public double getFirstClassPrice() {
        return _firstClassPrice;
    }

    public double getBusinessClassPrice() {
        return _businessClassPrice;
    }

    public double getEconomyClassPrice() {
        return _economyClassPrice;
    }

    public List<Ticket> getTickets() {
        return _tickets;
    }

    public List<Ticket> getBusinessClassTickets() {
        return _tickets.stream()
                .filter(x -> x.TicketType() == "Business Class")
                .collect(toList());
    }
    
    public List<Ticket> getFirstClassTickets() {
        return _tickets.stream()
                .filter(x -> x.TicketType() == "First Class")
                .collect(toList());
    }
    
    public List<Ticket> getEconomyClassTickets() {
        return _tickets.stream()
                .filter(x -> x.TicketType() == "Economy Class")
                .collect(toList());
    }

    public void AddTicket(Ticket ticket) {
        _tickets.add(ticket);
    }

    public void Cancel() {
        _isCancelled = true;
        _tickets.stream()
                .forEach(x -> x.Cancel());
    }

    public boolean IsCancelled() {
        return _isCancelled;
    }

    public void DrawFlight() {
        System.out.printf(" %15s | %30s | %30s | %25d | %25d | %25d | %25s \n"
                , _flightNo
                , _departLocation
                , _arriveLocation
                , _firstClassQty
                , _businessClassQty
                , _economyClassQty
                , _isCancelled ? "Cancelled" : "Available");
    }

    public void DrawFlightWithDetail() {
        PrintHelper.PrintShortLine();
        System.out.println("Flight No. : " + _flightNo);
        PrintHelper.PrintShortLine();
        
        int counter = 0;
        for (Ticket ticket : _tickets) {
            System.out.printf("No: %-3d %3s Ticket No. : %-15s Price : RM %-15.2f Ticket Class: %-18s Status: %-15s \n"
                , ++counter
                , ""
                , ticket.getTicketNo()
                , ticket.TicketPrice()
                , ticket.TicketType()
                , (ticket.IsSold() ? "Sold" : "Available")
            );
        }
        PrintHelper.PrintShortLine();
    }

    public void DrawBCFlightTicket(){
        PrintHelper.PrintShortLine();
        System.out.println("Flight No. : " + _flightNo);
        PrintHelper.PrintShortLine();

        int counter = 0;
        for (Ticket ticket : getBusinessClassTickets()) {
            System.out.printf("No: %-3d %3s Ticket No. : %-15s Price : RM %-15.2f Status: %-15s \n"
                    , ++counter
                    , ""
                    , ticket.getTicketNo()
                    , ticket.TicketPrice()
                    , (ticket.IsSold() ? "Sold" : "Available")
            );}
        PrintHelper.PrintShortLine();
    }

    public void DrawFCFlightTicket(){
        PrintHelper.PrintShortLine();
        System.out.println("Flight No. : " + _flightNo);
        PrintHelper.PrintShortLine();

        int counter = 0;
        for (Ticket ticket : getFirstClassTickets()) {
            System.out.printf("No: %-3d %3s Ticket No. : %-15s Price : RM %-15.2f Status: %-15s \n"
                    , ++counter
                    , ""
                    , ticket.getTicketNo()
                    , ticket.TicketPrice()
                    , (ticket.IsSold() ? "Sold" : "Available")
            );}
        PrintHelper.PrintShortLine();
    }

    public void DrawECFlightTicket(){
        PrintHelper.PrintShortLine();
        System.out.println("Flight No. : " + _flightNo);
        PrintHelper.PrintShortLine();

        int counter = 0;
        for (Ticket ticket : getEconomyClassTickets()) {
            System.out.printf("No: %-3d %3s Ticket No. : %-15s Price : RM %-15.2f Status: %-15s \n"
                    , ++counter
                    , ""
                    , ticket.getTicketNo()
                    , ticket.TicketPrice()
                    , (ticket.IsSold() ? "Sold" : "Available")
            );}
        PrintHelper.PrintShortLine();
    }
}
