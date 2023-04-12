package com.jahed.fitnessclub;

import java.util.ArrayList;
import java.util.List;

public class Booking {
    public int bookingId,timeTableId,customerId;
    public String status;
    public static List<Booking> allBooking = new ArrayList<Booking>();

    public Booking(int bookingId, int timeTableId, int customerId, String status){
        this.bookingId = bookingId;
        this.timeTableId = timeTableId;
        this.customerId = customerId;
        this.status = status;
    }
}
