package com.jahed.fitnessclub;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lesson {
    int maxCapacity;
    public String type,day;
    public double price;

    public Lesson(String type, String day, double price){
        this.type=type;
        this.day=day;
        this.price=price;
        this.maxCapacity =5;
    }

    public static void LessonReport(){
        List<String>lessonList=new ArrayList<String>();
        lessonList.add("Spin");
        lessonList.add("Yoga");
        lessonList.add("Zumba");
        lessonList.add("Bodysculpt");

        Scanner input = new Scanner(System.in);
        System.out.println("Enter month number 1 or 2");
        int month=input.nextInt();
        System.out.println("Lesson\t day \tCustomer\tAvgRating");
        int totalCustomer=0;
        List<Timetable>saturdayTimeTable=new ArrayList<Timetable>();
        List<Timetable>sundayTimeTable=new ArrayList<Timetable>();
        for (String type: lessonList){
            for (Timetable timeTable: Timetable.allTimetables){
                if(timeTable.month==month && timeTable.lesson.type.equals(type)){
                    totalCustomer=5-timeTable.lesson.maxCapacity +totalCustomer;
                    if (timeTable.lesson.day == "Saturday") {
                        saturdayTimeTable.add(timeTable);
                    }else {
                        sundayTimeTable.add(timeTable);
                    }
                }
            }
            for (Timetable timeTable:saturdayTimeTable){
                System.out.println("%s \t %s \t %d \t %.2f\t".formatted(timeTable.lesson.type,"Saturday",totalCustomer,GetAvgRating(timeTable.lesson.type)));
            }
            for (Timetable timeTable:sundayTimeTable) {
                System.out.println("%s \t %s \t %d \t %.2f".formatted(timeTable.lesson.type,"Sunday", totalCustomer, GetAvgRating(timeTable.lesson.type)));
            }
        }

    }
    public static double GetAvgRating(String lessonName){
        int totalRating = 0, count=0;
        for (LessonRatingReview rating: LessonRatingReview.allRating){
            if (Timetable.allTimetables.get(LessonBooking.allBooking.get(rating.bookingId-1).timeTableId).lesson.type.equals(lessonName)){
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
