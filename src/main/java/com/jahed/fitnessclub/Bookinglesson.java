package com.jahed.fitnessclub;

import java.util.ArrayList;
import java.util.List;

public class Bookinglesson {
    public int bookingId,timeTableId,customerId;
    public String status;
    public static List<Bookinglesson> allBooking = new ArrayList<Bookinglesson>();

    public Bookinglesson(int bookingId, int timeTableId, int customerId, String status){
        this.bookingId = bookingId;
        this.timeTableId = timeTableId;
        this.customerId = customerId;
        this.status = status;
    }
}
