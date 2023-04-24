/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.jahed.fitnessclub;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author mdjahedmiah
 */
public class Fitnessclub {

    public static void main(String[] args) {
        Timetable.CreateTimeTable();
        Customer.PreLoadedCustomer();
        while(true){
            System.out.println("****Welcome to WFC****");
            System.out.println("Please Choose an option");
            System.out.println("1. Book a Lesson");
            System.out.println("2. Change or Cancle Booking");
            System.out.println("3. Provide Review and Rating");
            System.out.println("4. Lesson Report");
            System.out.println("5. Income Report");
            
            System.out.println("Select According to the number:");
            Scanner input = new Scanner (System.in);
            int selected = input.nextInt();

        switch (selected){
            case 1:
                BookingManager.BookingLesson();
                break;
            case 2:
                BookingManager.ChangeCancleBooking();
                break;
            case 3:
                LessonRatingReview.ReviewRating();
                break;
            case 4:
                Lesson.LessonReport();
                break;
            case 5:
                MonthlyIncomeReport.IncomeReport();
                break;
            default:
                System.out.println("You have entered wrong number. Please enter number between 1 to 5");
                break;
        }

        }

    }

}
