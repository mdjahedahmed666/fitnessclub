package com.jahed.fitnessclub;

import java.util.ArrayList;
import java.util.List;

public class LessonBooking {
    public int bookingId,timeTableId,customerId;
    public String status;
    public static List<LessonBooking> allBooking = new ArrayList<LessonBooking>();

    public LessonBooking(int bookingId, int timeTableId, int customerId, String status){
        this.bookingId = bookingId;
        this.timeTableId = timeTableId;
        this.customerId = customerId;
        this.status = status;
    }
}
