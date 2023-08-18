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
import java.util.Scanner;

/**
 *
 * @author 
 */
public class FlightReservationSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        ShowMenu(scanner);
    }

    public static void ShowMenu(Scanner scanner) {
        while (true) {
            PrintHelper.PrintTitle("Main Menu");
            System.out.println("1. Customer Module");
            System.out.println("2. Flight Module");
            System.out.println("3. Reservation Module");
            System.out.println("4. Report Module");
            System.out.println("(-1 to Exit)");
            System.out.println();
            System.out.print("Please select your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    PrintHelper.ClearConsole();
                    CustomerModule.ShowMenu(scanner);
                    break;
                case "2":
                    PrintHelper.ClearConsole();
                    FlightModule.ShowMenu(scanner);
                    break;
                case "3":
                    PrintHelper.ClearConsole();
                    ReservationModule.ShowMenu(scanner);
                    break;
                case "4":
                    PrintHelper.ClearConsole();
                    ReportModule.ShowMenu(scanner);
                    break;
                case "-1":
                    PrintHelper.ClearConsole();
                    PrintHelper.PrintTitle("Exit ^ w ^");
                    return;
                default:
                    System.out.println("\n.--------------------------------------------.");
                    System.out.println("|    No such choice. Please select again.    |");
                    System.out.println("'--------------------------------------------'\n");
            }
            PrintHelper.ClearConsole();
        }
    }
}
