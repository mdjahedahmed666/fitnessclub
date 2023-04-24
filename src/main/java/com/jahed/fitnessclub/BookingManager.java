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
        if (Timetable.allTimetables.get(selectedTimetableId-1).lesson.maxCapacity !=0){
            int i = 0;
            for (; i< LessonBooking.allBooking.size(); i++){
                if (LessonBooking.allBooking.get(i).customerId==customerId){
                    break;
                }
            }
            if (LessonBooking.allBooking.size()!=0 && i< LessonBooking.allBooking.size()){
                System.out.println("Your booking is not successful");
                return "Your booking is not successful";
            }
            LessonBooking.allBooking.add(new LessonBooking(LessonBooking.allBooking.size()+1,selectedTimetableId-1,customerId,"booked"));
            Timetable.allTimetables.get(selectedTimetableId-1).lesson.maxCapacity--;
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
            int bookingId = GetBookingId();
            int selectedTimetableId = SelectedTimetableId();
            LessonBooking.allBooking.get(bookingId-1).timeTableId = selectedTimetableId;
            System.out.println("Your booking is updated successfully");
        }else{
            int bookingId = GetBookingId();
            LessonBooking.allBooking.get(bookingId-1).status = "cancled";
            Timetable.allTimetables.get(LessonBooking.allBooking.get(bookingId-1).timeTableId).lesson.maxCapacity++;
            System.out.println("Your booking is canceled successfully");
        }
    }

    public static int GetBookingId(){
        System.out.println("Enter Your Customer Id:");
        Scanner input = new Scanner(System.in);
        int customerId = input.nextInt();
        List<LessonBooking>filteredBookings = new ArrayList<LessonBooking>();
        for (LessonBooking booking: LessonBooking.allBooking){
            if (booking.customerId == customerId){
                filteredBookings.add(booking);
            }
        }
        int bookingId = ShowCustomerBookings(filteredBookings);
        return bookingId;
    }
    public static int ShowCustomerBookings(List<LessonBooking>allBooking){
        Scanner input = new Scanner(System.in);
        System.out.println("BookingId\tLesson\tDay");
        for (LessonBooking booking: allBooking){
            Timetable timeTable = Timetable.allTimetables.get(booking.timeTableId);
            System.out.println("%d \t %s \t %s".formatted(booking.bookingId,timeTable.lesson.type,timeTable.lesson.day));
        }
        System.out.println("Select Your Booking Id Number:");
        int selected = input.nextInt();
        return selected;
    }

}
