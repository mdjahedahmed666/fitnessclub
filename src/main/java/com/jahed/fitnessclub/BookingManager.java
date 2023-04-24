package com.jahed.fitnessclub;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookingManager {
    public static String BookingLesson(){
        int selectedTimetableId = SelectedTimetableId();
        Scanner input = new Scanner(System.in);
        Customer.DisplayCustomer();
        System.out.println("Enter Customer Id Number:");
        int customerId = input.nextInt();
        if (Timetable.allTimetables.get(selectedTimetableId-1).lesson.capacity!=0){
            int i = 0;
            for (;i<Bookinglesson.allBooking.size();i++){
                if (Bookinglesson.allBooking.get(i).customerId==customerId){
                    break;
                }
            }
            if (Bookinglesson.allBooking.size()!=0 && i<Bookinglesson.allBooking.size()){
                System.out.println("Your booking is not successful");
                return "Your booking is not successful";
            }
            Bookinglesson.allBooking.add(new Bookinglesson(Bookinglesson.allBooking.size()+1,selectedTimetableId-1,customerId,"booked"));
            Timetable.allTimetables.get(selectedTimetableId-1).lesson.capacity--;
            System.out.println("Your fitness lesson is booked successfully");
            return "Your fitness lesson is booked successfully";
        }else {
            System.out.println("Your booking is not successful");
            return "Your booking is not successful";
        }
    }
    public static int SelectedTimetableId(){
        System.out.println("Check your timetable:");
        System.out.println("1. According to the day.");
        System.out.println("2. According to the fitness type.");
        System.out.println("Select Number 1 or 2:");
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
        System.out.println("1. Change Yoour Booking.");
        System.out.println("2. Cancle Your Booking.");
        System.out.println("Select Number 1 or 2:");
        Scanner input = new Scanner(System.in);
        int selected = input.nextInt();
        if (selected == 1){
            ChangeBooking();
        }else{
            CancleBooking();
        }
    }
    public static void ChangeBooking(){
        int bookingId = GetBookingId();
        int selectedTimetableId = SelectedTimetableId();
        Bookinglesson.allBooking.get(bookingId-1).timeTableId = selectedTimetableId;
        System.out.println("Your booking is updated successfully");
    }
    public static void CancleBooking(){
        int bookingId = GetBookingId();
        Bookinglesson.allBooking.get(bookingId-1).status = "cancled";
        Timetable.allTimetables.get(Bookinglesson.allBooking.get(bookingId-1).timeTableId).lesson.capacity++;
        System.out.println("Your booking is canceled successfully");
    }

    public static int GetBookingId(){
        System.out.println("Enter your customer id");
        Scanner input = new Scanner(System.in);
        int customerId = input.nextInt();
        List<Bookinglesson>filteredBookings = new ArrayList<Bookinglesson>();
        for (Bookinglesson booking: Bookinglesson.allBooking){
            if (booking.customerId == customerId){
                filteredBookings.add(booking);
            }
        }
        int bookingId = ShowCustomerBookings(filteredBookings);
        return bookingId;
    }
    public static int ShowCustomerBookings(List<Bookinglesson>allBooking){
        Scanner input = new Scanner(System.in);
        System.out.println("BookingId\tLesson\tDay");
        for (Bookinglesson booking: allBooking){
            Timetable timeTable = Timetable.allTimetables.get(booking.timeTableId);
            System.out.println("%d \t %s \t %s".formatted(booking.bookingId,timeTable.lesson.type,timeTable.lesson.day));
        }
        System.out.println("Select Your Booking Id Number:");
        int selected = input.nextInt();
        return selected;
    }

}
