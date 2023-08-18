/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightreservationsystem;

import flightreservationsystem.BusinessLogic.CustomerBusinessLogic;
import flightreservationsystem.BusinessLogic.FlightBusinessLogic;
import flightreservationsystem.BusinessLogic.ReservationBusinessLogic;
import flightreservationsystem.Helper.PrintHelper;
import flightreservationsystem.Helper.ValidationHelper;
import flightreservationsystem.Model.Customer;
import flightreservationsystem.Model.Flight;
import flightreservationsystem.Model.Payment;
import flightreservationsystem.Model.Reservation;
import flightreservationsystem.Model.Ticket;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author 
 */
public class ReservationModule {

    public static void ShowMenu(Scanner scanner) {
        while (true) {
            PrintHelper.PrintTitle("Reservation Module");
            System.out.println("1. Add Reservation");
            System.out.println("2. View Reservation");
            System.out.println("(-1 to back to Main Menu)");
            System.out.println();
            System.out.print("Please select your choice: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    PrintHelper.ClearConsole();
                    AddReservation(scanner);
                    break;
                case "2":
                    PrintHelper.ClearConsole();
                    ViewReservation(scanner);
                    break;
                case "-1":
                    return;
                default:
                    System.out.println("\n.--------------------------------------------.");
                    System.out.println("|    No such choice. Please select again.    |");
                    System.out.println("'--------------------------------------------'\n");
            }
            PrintHelper.ClearConsole();
        }
    }

    public static void AddReservation(Scanner scanner) {
        Customer customer = null;
        Flight flight = null;
        String temp = "";
        boolean unmatched = true;
        int flightChoice = 0;

        PrintHelper.PrintTitle("Add Reservation");
        CustomerModule.DrawCustomerTable();
        while(unmatched)
        {
            do {
                System.out.print("Please select a customer (-1 to back to Menu): ");
                temp = scanner.nextLine();
                if (Objects.equals(temp, "-1")) {
                    return;
                }
            }while (!ValidationHelper.ValidDigit(temp));
            int customerChoice = Integer.parseInt(temp);

            if (CustomerBusinessLogic.CheckExist(customerChoice - 1)) {
                customer = CustomerBusinessLogic.ReadCustomer(customerChoice-1);
                unmatched = false;
            } else {
                PrintHelper.PrintErrorMsg("Customer");
                unmatched = true;
            }
        }

        unmatched = true;
        FlightModule.DrawFlightTable();
        while (unmatched) {
            do{
                System.out.print("Please select a flight  (-1 to back to Menu): ");
                temp = scanner.nextLine();
                if (Objects.equals(temp, "-1")) {
                    return;
                }
            }while (!ValidationHelper.ValidDigit(temp));
            flightChoice = Integer.parseInt(temp);

            if (FlightBusinessLogic.CheckExist(flightChoice - 1)) {
                flight = FlightBusinessLogic.ReadFlight(flightChoice - 1);
                flight.DrawFlightWithDetail();
                unmatched = false;
            } else {
                PrintHelper.PrintErrorMsg("Flight");
                unmatched = true;
            }
        }
//        temp list
        List<Ticket> tickets = new ArrayList<Ticket>();
        int ticketChoice = 0;

        while(ticketChoice != -1) {
            System.out.print("Please select a ticket (-1 to stop select): ");
            ticketChoice = scanner.nextInt();
            scanner.nextLine();
            if (ticketChoice == -1){
                break;
            }
            if (!FlightBusinessLogic.CheckTicketExist(ticketChoice - 1, flightChoice-1)){
                PrintHelper.PrintErrorMsg("Ticket");
                continue;
            }

            unmatched = false;
            String ticketNo = flight.getTickets().get(ticketChoice - 1).getTicketNo();
            for (Ticket t : tickets) {
                if (ticketNo.equals(t.getTicketNo())) {
                    unmatched = true;
                    break;
                }
            }
            if (unmatched) {
                System.out.println("\n.--------------------------------------------------------.");
                System.out.println("|   The ticket is chosen. Please select another ticket   |");
                System.out.println("'--------------------------------------------------------'\n");
            }
            else if (flight.getTickets().get(ticketChoice - 1).IsSold()){
                System.out.println("\n.-------------------------------------------------------.");
                System.out.println("|   The ticket is sold. Please select another ticket.   |");
                System.out.println("'-------------------------------------------------------'\n");
            }
            else {
                Ticket ticket = flight.getTickets().get(ticketChoice - 1);
                tickets.add(ticket);
            }

        }

        double price = 0;
        for (Ticket ticket : tickets) {
            price += ticket.TicketPrice();
        }

        System.out.println("\nPayment");
        PrintHelper.PrintLine();
        System.out.print("Total Amount  : RM ");
        System.out.printf("%-15.2f \n", price);
        System.out.println("Total Tickets : " + tickets.size());

        //validation for only accept payment amount must > total amount
        double paidAmount = 0;
        while (paidAmount < price){
            do{
                System.out.print("Please enter payment amount: ");
                temp  = scanner.nextLine();
            }while (!ValidationHelper.ValidDouble(temp));
            paidAmount = Double.parseDouble(temp);
            if (paidAmount < price){
                System.out.println("\n.----------------------------------.");
                System.out.println("|    Please pay enough amount.     |");
                System.out.println("'----------------------------------'\n");
            }
        }

        Payment payment = new Payment(price, paidAmount);
        System.out.print("Exchange: RM ");
        System.out.printf("%-15.2f \n", payment.Change());
        System.out.println("\n.--------------------------.");
        System.out.println("|    Payment successful.   |");
        System.out.println("'--------------------------'\n");

        Reservation reservation = new Reservation(customer, payment, flight, tickets);
        ReservationBusinessLogic.Reserve(reservation);
    }

    public static void ViewReservation(Scanner scanner) {
        String temp = "";
        PrintHelper.PrintTitle("View Reservation");
        DrawReservationTable();
        boolean unmatched = true;

        while(unmatched){
            do {
                System.out.print("Please select a reservation to view (-1 to back to Menu): ");
                temp = scanner.nextLine();
                if (Objects.equals(temp, "-1")) {
                    return;
                }
            } while (!ValidationHelper.ValidDigit(temp));
            int choice = Integer.parseInt(temp);

            if (ReservationBusinessLogic.CheckExist(choice-1)){
                Reservation selectedReservation = ReservationBusinessLogic.ReadReservation(choice - 1);
                selectedReservation.DrawReservationWithDetail();
                unmatched = false;
            }else{
                PrintHelper.PrintErrorMsg("Reservation");
            }
        }
    }

    public static void DrawReservationTable() {
        System.out.println("\n");
        PrintHelper.PrintLine();
        System.out.printf(" %5s | %20s | %30s | %20s | %15s \n", "No.", "Reservation No","Customer Name", "Flight No", "Price");
        PrintHelper.PrintLine();
        int reserveCounter = 0;
        for (Reservation reservation : ReservationBusinessLogic.ReadReservations()) {
            System.out.printf(" %5s |", ++reserveCounter);
            reservation.DrawReservation();
        }
        PrintHelper.PrintLine();
    }
}
