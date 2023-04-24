package com.jahed.fitnessclub;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Customer {
    public int customerId;
    public String customerName;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Customer(int customerId,String customerName){
        this.customerId = customerId;
        this.customerName = customerName;
    }
    public static List<Customer> customerList =new ArrayList<Customer>();
    public static void PreLoadedCustomer(){
        customerList.add(new Customer(1,"Jahed"));
        customerList.add(new Customer(2,"Jahid"));
        customerList.add(new Customer(3,"Jaher"));
        customerList.add(new Customer(4,"Zahed"));
        customerList.add(new Customer(5,"Zahed"));
        customerList.add(new Customer(6,"Zahed"));
        customerList.add(new Customer(7,"Mujahid"));
        customerList.add(new Customer(8,"Jaber"));

    }
    public static void DisplayCustomer(){
        System.out.println("PreLoaded Customers:");
        System.out.println("\tId\tCustomerName");
        for (Customer customer:customerList){
            System.out.println("\t%d\t%s\n".formatted(customer.getCustomerId(),customer.getCustomerName()));
       }
   }
}
