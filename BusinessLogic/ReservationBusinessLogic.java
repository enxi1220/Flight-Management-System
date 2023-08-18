/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightreservationsystem.BusinessLogic;

import flightreservationsystem.Model.Reservation;
import flightreservationsystem.Model.Ticket;
import flightreservationsystem.Model.Transaction;
import flightreservationsystem.Storage.Database;
import java.util.List;

/**
 *
 * @author 
 */
public class ReservationBusinessLogic {
    public static void Reserve(Reservation reservation){
        for(Ticket ticket :reservation.getTickets()){
            ticket.AssignToCustomer(reservation.getCustomer());
            Transaction transaction = new Transaction(reservation.getCustomer(), ticket, reservation.getPayment(), reservation);
            Database.Transactions.add(transaction);
        }
        reservation.setReservationNo(Reservation.NextReservationNo());
        Database.Reservations.add(reservation);
        Database.Payments.add(reservation.getPayment());
    }
    
    public static List<Reservation> ReadReservations(){
        return Database.Reservations;
    }
    
    public static Reservation ReadReservation(int index){
        return Database.Reservations.get(index);
    }

    public static boolean CheckExist(int index){
        List<Reservation> Reservations = ReadReservations();

        if(index >= Reservations.size()){
            return false;
        }else{
            return true;
        }
    }
}
