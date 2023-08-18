/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightreservationsystem.Storage;

import flightreservationsystem.Model.Customer;
import flightreservationsystem.Model.Flight;
import flightreservationsystem.Model.Payment;
import flightreservationsystem.Model.Reservation;
import flightreservationsystem.Model.Transaction;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 
 */
public class Database {
    public static List<Customer> Customers = new ArrayList<Customer>();
    public static List<Payment> Payments = new ArrayList<Payment>();
    public static List<Flight> Flights = new ArrayList<Flight>();
    public static List<Transaction> Transactions = new ArrayList<Transaction>();
    public static List<Reservation> Reservations = new ArrayList<Reservation>();
}
