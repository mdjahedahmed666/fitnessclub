package com.jahed.fitnessclub;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookingManager {
    public static String BookingLesson(){
        int selectedTimetableId = GetSelectedTimetableId();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Customer Id");
        int customerId = input.nextInt();
        if (Timetable.allTimetable.get(selectedTimetableId-1).lesson.capacity!=0){
            int i = 0;
            for (;i<Booking.allBooking.size();i++){
                if (Booking.allBooking.get(i).customerId==customerId){
                    break;
                }
            }
            if (Booking.allBooking.size()!=0 && i<Booking.allBooking.size()){
                System.out.println("Your booking is not successful");
                return "Your booking is not successful";
            }
            Booking.allBooking.add(new Booking(Booking.allBooking.size()+1,selectedTimetableId-1,customerId,"booked"));
            Timetable.allTimetable.get(selectedTimetableId-1).lesson.capacity--;
            System.out.println("Your fitness lesson is booked successfully");
            return "Your fitness lesson is booked successfully";
        }else {
            System.out.println("Your booking is not successful");
            return "Your booking is not successful";
        }
    }
    public static int GetSelectedTimetableId(){
        System.out.println("Check your timetable");
        System.out.println("1. According to the day");
        System.out.println("2. According to the fitness type");
        System.out.println("Select number 1 or 2");
        Scanner input = new Scanner(System.in);
        int selected = input.nextInt();
        int selectedTimetableId=0;
        if (selected == 1){
            selectedTimetableId = Timetable.TimetableByDay();
        }else {
            selectedTimetableId = Timetable.TimetableByFitness();
        }
        return selectedTimetableId;
    }
    public static void ChangeCancleBooking(){
        System.out.println("1. Change Yoour Booking");
        System.out.println("2. Cancle Your Booking");
        System.out.println("Select number 1 or 2");
        Scanner input = new Scanner(System.in);
        int selected = input.nextInt();
        if (selected == 1){
            Changebooking();
        }else{
            CancleBooking();
        }
    }
    public static void Changebooking(){
        int bookingId = GetBookingId();
        int selectedTimetableId = GetSelectedTimetableId();
        Booking.allBooking.get(bookingId-1).timeTableId = selectedTimetableId;
        System.out.println("Your booking is updated successfully");
    }
    public static void CancleBooking(){
        int bookingId = GetBookingId();
        Booking.allBooking.get(bookingId-1).status = "cancled";
        Timetable.allTimetable.get(Booking.allBooking.get(bookingId-1).timeTableId).lesson.capacity++;
        System.out.println("Your booking is canceled successfully");
    }

    public static int GetBookingId(){
        System.out.println("Enter your customer id");
        Scanner input = new Scanner(System.in);
        int customerId = input.nextInt();
        List<Booking>filteredBookings = new ArrayList<Booking>();
        for (Booking booking: Booking.allBooking){
            if (booking.customerID ==customerId){
                filteredBookings.add(booking);
            }
        }
        int bookingId = ShowCustomerBookings(filteredBookings);
        return bookingId;
    }
    public static int ShowCustomerBookings(List<Booking>allBooking){
        Scanner input = new Scanner(System.in);
        System.out.println("Booking Id \t Lesson \t Day");
        for (Booking booking: allBooking){
            Timetable timetable = Timetable.allTimetable.get(booking.timeTableId);
            System.out.println("%d \t %s \t %s".formatted(booking.bookingId,timeTable.lesson.name,timeTable.lesson.day));
        }
        System.out.println("Select your booking id");
        int selected = input.nextInt();
        return selected;
    }

}
