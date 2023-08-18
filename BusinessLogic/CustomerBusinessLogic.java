/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightreservationsystem.BusinessLogic;

import flightreservationsystem.Model.Customer;
import flightreservationsystem.Storage.Database;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

/**
 *
 * @author 
 */
public class CustomerBusinessLogic {
    public static void CreateCustomer(Customer customer){
        Database.Customers.add(customer);
    }
    
    public static List<Customer> ReadCustomer(){
        return Database.Customers;
    }
    
    public static Customer ReadCustomer(int index){
            return Database.Customers.get(index);
    }
    
    public static Customer DeleteCustomer(int index){
        return Database.Customers.remove(index);
    }

    public static boolean CheckExist(int index){
        List<Customer> Customers = ReadCustomer();

        if(index >= Customers.size()){
            return false;
        }else{
            return true;
        }
    }
}
