/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package flightreservationsystem;

import flightreservationsystem.BusinessLogic.CustomerBusinessLogic;
import flightreservationsystem.Helper.PrintHelper;
import flightreservationsystem.Helper.ValidationHelper;
import flightreservationsystem.Model.Customer;

import java.util.Objects;
import java.util.Scanner;

/**
 * @author
 */

//variable at here just a temporary, not yet create an object yet

public class CustomerModule {

    public static void ShowMenu(Scanner scanner) {
        while (true) {

            PrintHelper.PrintTitle("Customer Module");
            System.out.println("1. Add Customer");
            System.out.println("2. View Customer");
            System.out.println("3. Update Customer");
            System.out.println("4. Delete Customer");
            System.out.println("(-1 to back to Main Menu)");
            System.out.println();
            System.out.print("Please select your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    PrintHelper.ClearConsole();
                    AddCustomer(scanner);
                    break;
                case "2":
                    PrintHelper.ClearConsole();
                    ViewCustomer(scanner);
                    break;
                case "3":
                    PrintHelper.ClearConsole();
                    UpdateCustomer(scanner);
                    break;
                case "4":
                    PrintHelper.ClearConsole();
                    DeleteCustomer(scanner);
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

    private static void DeleteCustomer(Scanner scanner) {
        String temp = "";
        PrintHelper.PrintTitle("Delete Customer");
        DrawCustomerTable();
        boolean unmatched = true;
        while(unmatched){
            do {
                System.out.print("Please select a customer to delete (-1 to back to Menu): ");
                temp = scanner.nextLine();
                if (Objects.equals(temp, "-1")) {
                    return;
                }
            }while (!ValidationHelper.ValidDigit(temp));
            int choice =Integer.parseInt(temp);

            if (CustomerBusinessLogic.CheckExist(choice - 1)) {
                CustomerBusinessLogic.DeleteCustomer(choice - 1);
                System.out.println("\nCustomer delete successfully.\n\n\n");
                unmatched = false;
            } else {
                PrintHelper.PrintErrorMsg("Customer");
                unmatched = true;
            }
        }
    }

    private static void UpdateCustomer(Scanner scanner) {
        String temp = "";
        PrintHelper.PrintTitle("Update Customer");
        DrawCustomerTable();
        int choice = 0;
        boolean unmatched = true;
        while(unmatched){
            do {
                System.out.print("Please select a customer to update (-1 to back to Menu): ");
                temp = scanner.nextLine();
                if (Objects.equals(temp, "-1")) {
                    return;
                }
            } while (!ValidationHelper.ValidDigit(temp));
            choice = Integer.parseInt(temp);

            if (!CustomerBusinessLogic.CheckExist(choice - 1)) {
                PrintHelper.PrintErrorMsg("Customer");
                unmatched = true;
            }
            else{
                unmatched = false;
            }
        }

        PrintHelper.PrintTitle("Update Customer");

        do {
            System.out.print("Customer Name: ");
            temp = scanner.nextLine();
        }while (!ValidationHelper.ValidName(temp)) ;
        String name = temp;

        do {
            System.out.print("Customer Passport Number: ");
            temp = scanner.nextLine();
        } while (!ValidationHelper.ValidAlphaNum(temp));
        String passportNo = temp;

        do {
            System.out.print("Customer Phone: ");
            temp = scanner.nextLine();
        } while (!ValidationHelper.ValidDigit(temp));
        String phone = temp;

        Customer selectedCustomer = CustomerBusinessLogic.ReadCustomer(choice - 1);

        selectedCustomer.setCustomerName(name);
        selectedCustomer.setCustomerPassportNo(passportNo);
        selectedCustomer.setCustomerPhone(phone);
        System.out.println(".-----------------------------------------.");
        System.out.println("|      Customer update successfully.      |");
        System.out.println("'-----------------------------------------'");
    }

    private static void ViewCustomer(Scanner scanner) {
        String temp = "";
        PrintHelper.PrintTitle("View Customer");
        DrawCustomerTable();
        boolean unmatched = true;
        while(unmatched){
            do {
                System.out.print("Please select a customer to view details (-1 to back to Menu): ");
                temp = scanner.nextLine();
                if (Objects.equals(temp, "-1")) {
                    return;
                }
            }while (!ValidationHelper.ValidDigit(temp));
            int choice =Integer.parseInt(temp);

            if (CustomerBusinessLogic.CheckExist(choice - 1)) {
                CustomerBusinessLogic.ReadCustomer(choice - 1).DrawCustomerWithDetail();
                unmatched = false;
            } else {
                PrintHelper.PrintErrorMsg("Customer");
                unmatched = true;
            }
        }

    }

    private static void AddCustomer(Scanner scanner) {
        String temp = "";
        PrintHelper.PrintTitle("Add Customer");

        do {
            System.out.print("Customer Name: ");
            temp = scanner.nextLine();
        }while (!ValidationHelper.ValidName(temp)) ;
        String name = temp;

        do {
            System.out.print("Customer Passport Number: ");
            temp = scanner.nextLine();
        } while (!ValidationHelper.ValidAlphaNum(temp));
        String passportNo = temp;

        do {
            System.out.print("Customer Phone: ");
            temp = scanner.nextLine();
        } while (!ValidationHelper.ValidDigit(temp));
        String phone = temp;

        Customer customer = new Customer(name, passportNo, phone);
        CustomerBusinessLogic.CreateCustomer(customer);
    }

    public static void DrawCustomerTable () {
        PrintHelper.PrintLine();
        System.out.printf(" %5s | %30s | %30s | %30s \n", "No.", "Customer Name", "Customer Passport Number", "Customer Phone");
        PrintHelper.PrintLine();
        int custCounter = 0;
        for (Customer customer : CustomerBusinessLogic.ReadCustomer()) {
            System.out.printf(" %5s |", ++custCounter);
            customer.DrawCustomer();
        }
        PrintHelper.PrintLine();
    }
}
