package com.jahed.fitnessclub;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lesson {
    int capacity;
    public String name,day;
    public double price;

    public Lesson(String name, String day, double price){
        this.name=name;
        this.day=day;
        this.price=price;
        this.capacity=5;
    }
    public static void ReviewRating(){
        Scanner input = new Scanner(System.in);
        int bookingId = BookingManager.GetBookingId();
        LessonRating lessonRating = new LessonRating();
        System.out.println("Enter your review");
        lessonRating.review = input.nextLine();
        System.out.println("Rate the lesson from 1 to 5");
        lessonRating.rating = input.nextInt();
        lessonRating.reviewId=LessonRating.allRating.size()+1;
        lessonRating.allRating.add(lessonRating);
    }
    public static void LessonReport(){
        List<String>lessonList=new ArrayList<String>();
        lessonList.add("Spin");
        lessonList.add("Yoga");
        lessonList.add("Bodysculpt");
        lessonList.add("Aquacise");
        lessonList.add("Zumba");

        Scanner input = new Scanner(System.in);
        System.out.println("Enter month number 1 or 2");
        int month=input.nextInt();
        System.out.println("Lesson name\t day \t total customer \t avg rating");
        int totalCustomer=0;
        List<Timetable>saturdayTimeTable=new ArrayList<Timetable>();
        List<Timetable>sundayTimeTable=new ArrayList<Timetable>();
        for (String name:lessonList){
            for (Timetable timeTable: Timetable.allTimetable){
                if(timeTable.month==month&&timeTable.lesson.name.equals(name)){
                    totalCustomer=5-timeTable.lesson.capacity+totalCustomer;
                    if (timeTable.lesson.day == "Saturday") {
                        saturdayTimeTable.add(timeTable);
                    }else {
                        sundayTimeTable.add(timeTable);
                    }
                }
            }
            for (Timetable timetable:saturdayTimeTable){
                System.out.println("%s \t %s \t %d \t %.2f".formatted(timeTable.lesson.name,"Saturday",totalCustomer,GetAvgRating(timeTable.lesson.name)));
            }
            for (Timetable timetable:saturdayTimeTable) {
                System.out.println("%s \t %s \t %d \t %.2f".formatted(timeTable.lesson.name, "Sunday", totalCustomer, GetAvgRating(timeTable.lesson.name)));
            }
        }

    }
    public static double GetAvgRating(String lessonName){
        int totalRating = 0, count=0;
        for (LessonRating rating: LessonRating.allRating){
            if (Timetable.allTimetable.get(Booking.allBooking.get(rating.bookingId-1).timeTableId).lesson.name.equals(lessonName)){
                count++;
                totalRating= totalRating+rating.rating;
            }
        }
        if (count==0){
            return 0;
        }
        return totalRating/count;
    }
}
