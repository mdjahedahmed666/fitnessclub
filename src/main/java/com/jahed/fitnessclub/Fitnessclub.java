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
            System.out.println("Please choose an option");
            System.out.println("1. Book a Lesson");
            System.out.println("2. Change or Cancle Booking");
            System.out.println("3. ProvideReview and Rating");
            System.out.println("4. Lesson Report");
            System.out.println("5. Income Report");
            
            System.out.println("Select According to the number:");
            Scanner input = new Scanner (System.in);
            int selected = input.nextInt();
            
            if(selected <=0 || selected > 5){
                System.exit(0);
            }else{
                PerformAction(selected);
            }

        }
    }
    public static void PerformAction(int selected){
        switch (selected){
            case 1:
                BookingManager.BookingLesson();
                break;
            case 2:
                BookingManager.ChangeCancleBooking();
                break;
            case 3:
                Lesson.ReviewRating();
                break;
            case 4:
                Lesson.LessonReport();
                break;
            case 5:
                IncomeReport();
                break;
            default:
                break;
        }
    }
    public static void IncomeReport(){
        List <String> lessonList = new ArrayList<String>();
        lessonList.add("Spin");
        lessonList.add("Yoga");
        lessonList.add("Bodysculpt");
//      lessonList.add("Aquacise");
        lessonList.add("Zumba");

        Scanner input = new Scanner(System.in);
        System.out.println("Enter month Number (1 or 2)");
        int month = input.nextInt();
        System.out.println("LessonName \t Income");
        for (String type: lessonList){
            double netIncome = 0;
            for (Timetable timetable: Timetable.allTimetables){
                if (timetable.month == month && timetable.lesson.type == type){
                    netIncome = (5-timetable.lesson.capacity)*timetable.lesson.price + netIncome;
                }
            }
            System.out.println("%s\t%.2f".formatted(type,netIncome));
        }
    }
}
