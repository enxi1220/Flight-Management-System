/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightreservationsystem;

import flightreservationsystem.BusinessLogic.CustomerBusinessLogic;
import flightreservationsystem.BusinessLogic.FlightBusinessLogic;
import flightreservationsystem.Helper.PrintHelper;
import flightreservationsystem.Helper.ValidationHelper;
import flightreservationsystem.Model.Flight;

import java.util.Objects;
import java.util.Scanner;

/**
 * @author
 */
public class FlightModule {

    public static void ShowMenu(Scanner scanner) {
        while (true) {
            PrintHelper.PrintTitle("Flight Module");
            System.out.println("1. Add Flight");
            System.out.println("2. View Flight");
            System.out.println("3. Delete Flight");
            System.out.println("(-1 to back to Main Menu)");
            System.out.println();
            System.out.print("Please select your choice: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    PrintHelper.ClearConsole();
                    AddFlight(scanner);
                    break;
                case "2":
                    PrintHelper.ClearConsole();
                    ViewFlight(scanner);
                    break;
                case "3":
                    PrintHelper.ClearConsole();
                    DeleteFlight(scanner);
                    break;
                case "-1":
                    PrintHelper.ClearConsole();
                    return;
                default:
                    System.out.println("\n.--------------------------------------------.");
                    System.out.println("|    No such choice. Please select again.    |");
                    System.out.println("'--------------------------------------------'\n");
            }
            PrintHelper.ClearConsole();
        }
    }

    public static void AddFlight(Scanner scanner) {
        PrintHelper.PrintTitle("Add Flight");
        String temp = "";
        do {
            System.out.print("Flight No: ");
            temp = scanner.nextLine();
        }while (!ValidationHelper.ValidAlphaNum(temp));
        String flightNo = temp;

        do {
        System.out.print("Flight Departure Location: ");
        temp = scanner.nextLine();
        }while (!ValidationHelper.ValidAlpha(temp));
        String departLoc = temp;

        do {
            System.out.print("Flight Arrival Location: ");
            temp = scanner.nextLine();
        }while (!ValidationHelper.ValidAlpha(temp));
        String arriveLoc = temp;

        System.out.println("\nFirst Class ");
        System.out.println("-----------");
        do {
            System.out.print("Seat Quantity: ");
            temp = scanner.nextLine();
        } while (!ValidationHelper.ValidDigit(temp));
        int firstClassQty = Integer.parseInt(temp);

        do {
            System.out.print("Seat Price: RM ");
            temp  = scanner.nextLine();
        }while (!ValidationHelper.ValidDouble(temp));
        double firstClassPrice = Double.parseDouble(temp);

        System.out.println("\nBusiness Class ");
        System.out.println("--------------");
        do {
            System.out.print("Seat Quantity: ");
            temp = scanner.nextLine();
        } while (!ValidationHelper.ValidDigit(temp));
        int businessClassQty = Integer.parseInt(temp);

        do {
            System.out.print("Seat Price: RM ");
            temp  = scanner.nextLine();
        }while (!ValidationHelper.ValidDouble(temp));
        double businessClassPrice = Double.parseDouble(temp);

        System.out.println("\nEconomy Class ");
        System.out.println("-------------");
        do {
            System.out.print("Seat Quantity: ");
            temp = scanner.nextLine();
        } while (!ValidationHelper.ValidDigit(temp));
        int economyClassQty = Integer.parseInt(temp);

        do {
            System.out.print("Seat Price: RM ");
            temp  = scanner.nextLine();
        }while (!ValidationHelper.ValidDouble(temp));
        double economyClassPrice = Double.parseDouble(temp);

        Flight flight = new Flight(flightNo, departLoc, arriveLoc, firstClassQty, firstClassPrice, businessClassQty, businessClassPrice, economyClassQty, economyClassPrice);
        FlightBusinessLogic.CreateFlight(flight);
    }

    public static void ViewFlight(Scanner scanner) {
        String temp = "";
        PrintHelper.PrintTitle("View Flight");
        DrawFlightTable();
        boolean unmatched = true;
        while(unmatched){
            do {
                System.out.print("Please select a flight to view detail(-1 to back to Menu): ");
                temp = scanner.nextLine();
                if (Objects.equals(temp, "-1")) {
                    return;
                }
            }while (!ValidationHelper.ValidDigit(temp));
            int choice =Integer.parseInt(temp);

            if (FlightBusinessLogic.CheckExist(choice - 1)){
                Flight selectedFlight = FlightBusinessLogic.ReadFlight(choice - 1);
                selectedFlight.DrawFlightWithDetail();
                unmatched = false;
            }else{
                PrintHelper.PrintErrorMsg("Flight");
                unmatched = true;
            }
        }
    }

    public static void DeleteFlight(Scanner scanner) {
        String temp = "";
        PrintHelper.PrintTitle("Delete Flight");
        DrawFlightTable();
        boolean unmatched = true;
        while(unmatched){
            do {
                System.out.print("Please select a flight to delete(-1 to back to Menu): ");
                temp = scanner.nextLine();
                if (Objects.equals(temp, "-1")) {
                    return;
                }
            }while (!ValidationHelper.ValidDigit(temp));
            int choice = Integer.parseInt(temp);

            if (FlightBusinessLogic.CheckExist(choice - 1)) {
                Flight selectedFlight = FlightBusinessLogic.ReadFlight(choice - 1);
                FlightBusinessLogic.DeleteFlight(selectedFlight);
                System.out.println("\n.---------------------------------------.");
                System.out.println("|      Flight delete successfully.      |");
                System.out.println("'---------------------------------------'\n");
                unmatched = false;
            } else {
                PrintHelper.PrintErrorMsg("Flight");
                unmatched = true;
            }
        }


    }

    public static void DrawFlightTable() {
        System.out.println("\n");
        PrintHelper.PrintLine();
        System.out.printf(" %5s | %15s | %30s | %30s | %25s | %25s | %25s | %25s \n", "No.", "Flight No", "Departure Location", "Arrival Location", "First Class Quantity", "Business Class Quantity", "Economy Class Quantity", "Status");
        PrintHelper.PrintLine();
        int flightCounter = 0;
        for (Flight flight : FlightBusinessLogic.ReadFlights()) {
            System.out.printf(" %5s |", ++flightCounter);
            flight.DrawFlight();
        }
        PrintHelper.PrintLine();
    }

}
