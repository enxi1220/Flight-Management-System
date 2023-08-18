/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightreservationsystem.Helper;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 
 */
public class PrintHelper {

    public static void PrintHeadings() {
        System.out.println("\n================================================================================================================================================================================================================================================\n");
    }

    public static void PrintLine() {
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    public static void PrintShortLine() {
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
    }
    
    public static void PrintTitle(String title){
        PrintHelper.PrintHeadings();
        System.out.println("   " + title);
        PrintHelper.PrintHeadings();
    }

    public static void PrintErrorMsg(String msg){
        System.out.println("\n.----------------------------------------------.");
        System.out.printf("|%20s %-25s|", msg, "not exists.");
        System.out.println("\n'----------------------------------------------'\n");
    }
    public static void ClearConsole() {
        for (int i = 0; i < 30; i++) {
            System.out.print("\n");
        }
    }
}
