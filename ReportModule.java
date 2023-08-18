/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightreservationsystem;

import flightreservationsystem.BusinessLogic.FlightBusinessLogic;
import flightreservationsystem.Helper.PrintHelper;
import flightreservationsystem.Helper.ValidationHelper;
import flightreservationsystem.Model.Flight;

import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author 
 */
public class ReportModule {

    public static void ShowMenu(Scanner scanner) {
        while (true) {
            PrintHelper.PrintTitle("Report Module");
            System.out.println("1. Flight Tickets Report");
            System.out.println("2. Reservation Detail Report");
            System.out.println("3. Business Class Tickets Status Report");
            System.out.println("4. First Class Tickets Status Report");
            System.out.println("5. Economy Class Tickets Status Report");
            System.out.println("(-1 to back to Main Menu)");
            System.out.println();
            System.out.print("Please select your choice: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    PrintHelper.ClearConsole();
                    FlightTicketReport(scanner);
                    break;
                case "2":
                    PrintHelper.ClearConsole();
                    ReservationDetailReport(scanner);
                    break;
                case "3":
                    PrintHelper.ClearConsole();
                    BusinessClassTicketStatus(scanner);
                    break;
                case "4":
                    PrintHelper.ClearConsole();
                    FirstClassTicketStatus(scanner);
                    break;
                case "5":
                    PrintHelper.ClearConsole();
                    EconomyClassTicketStatus(scanner);
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

    private static void ReservationDetailReport(Scanner scanner) {
        PrintHelper.PrintTitle("Reservation Detail Report");
        ReservationModule.DrawReservationTable();
    }

    private static void FlightTicketReport(Scanner scanner) {
        String temp = "";
        FlightModule.DrawFlightTable();
        boolean unmatched = true;
        int choice = 0;
        while(unmatched){
            do {
                System.out.print("Please select a flight to view (-1 to back to Menu): ");
                temp = scanner.nextLine();
                if (Objects.equals(temp, "-1")) {
                    return;
                }
            }while (!ValidationHelper.ValidDigit(temp));
            choice =Integer.parseInt(temp);

            if (FlightBusinessLogic.CheckExist(choice - 1)) {
                Flight selectedFlight = FlightBusinessLogic.ReadFlight(choice - 1);
                PrintHelper.PrintTitle("Flight Ticket Status Report");
                selectedFlight.DrawFlightWithDetail();
                unmatched = false;
            } else {
                PrintHelper.PrintErrorMsg("Flight");
                unmatched = true;
            }
        }
    }

    private static void BusinessClassTicketStatus(Scanner scanner) {
        String temp = "";
        FlightModule.DrawFlightTable();
        boolean unmatched = true;
        while(unmatched){
            do {
                System.out.print("Please select a flight to view (-1 to back to Menu): ");
                temp = scanner.nextLine();
                if (Objects.equals(temp, "-1")) {
                    return;
                }
            }while (!ValidationHelper.ValidDigit(temp));
            int choice =Integer.parseInt(temp);

            if (FlightBusinessLogic.CheckExist(choice - 1)) {
                Flight selectedFlight = FlightBusinessLogic.ReadFlight(choice - 1);
                PrintHelper.PrintTitle("Business Class Tickets Status");
                selectedFlight.DrawBCFlightTicket();
                unmatched = false;
            } else {
                PrintHelper.PrintErrorMsg("Flight");
                unmatched = true;
            }
        }
    }

    private static void FirstClassTicketStatus(Scanner scanner) {
        String temp = "";
        FlightModule.DrawFlightTable();
        boolean unmatched = true;
        while(unmatched){
            do {
                System.out.print("Please select a flight to view (-1 to back to Menu): ");
                temp = scanner.nextLine();
                if (Objects.equals(temp, "-1")) {
                    return;
                }
            }while (!ValidationHelper.ValidDigit(temp));
            int choice =Integer.parseInt(temp);

            if (FlightBusinessLogic.CheckExist(choice - 1)) {
                Flight selectedFlight = FlightBusinessLogic.ReadFlight(choice - 1);
                PrintHelper.PrintTitle("First Class Tickets Status");
                selectedFlight.DrawFCFlightTicket();
                unmatched = false;
            } else {
                PrintHelper.PrintErrorMsg("Flight");
                unmatched = true;
            }
        }
    }

    private static void EconomyClassTicketStatus(Scanner scanner) {
        String temp = "";
        FlightModule.DrawFlightTable();
        boolean unmatched = true;
        while(unmatched){
            do {
                System.out.print("Please select a flight to view (-1 to back to Menu): ");
                temp = scanner.nextLine();
                if (Objects.equals(temp, "-1")) {
                    return;
                }
            }while (!ValidationHelper.ValidDigit(temp));
            int choice =Integer.parseInt(temp);

            if (FlightBusinessLogic.CheckExist(choice - 1)) {
                Flight selectedFlight = FlightBusinessLogic.ReadFlight(choice - 1);
                PrintHelper.PrintTitle("Economy Class Tickets Status");
                selectedFlight.DrawECFlightTicket();
                unmatched = false;
            } else {
                PrintHelper.PrintErrorMsg("Flight");
            }
        }

    }
}
