package com.jahed.fitnessclub;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MonthlyIncomeReport {
    public static void IncomeReport(){
        List<String> lessonList = new ArrayList<String>();
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
