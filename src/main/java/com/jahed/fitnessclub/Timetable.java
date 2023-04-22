package com.jahed.fitnessclub;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Timetable {
    public int timetableId,month;
    public Lesson lesson;
    public static List <Timetable>allTimetables=new ArrayList<Timetable>();
    public Timetable(int id,Lesson lesson,int month){
        this.timetableId=id;
        this.lesson=lesson;
        this.month=month;
    }
    public static void CreateTimeTable(){
        allTimetables.add(new Timetable(1,new Lesson("Spin","Saturday",300),1));
        allTimetables.add(new Timetable(2,new Lesson("Yoga","Saturday",200),1));
        allTimetables.add(new Timetable(3,new Lesson("Spin","Sunday",300),1));
        allTimetables.add(new Timetable(4,new Lesson("Zumba","Sunday",250),1));
        allTimetables.add(new Timetable(5,new Lesson("Bodysculpt","Saturday",350),1));
        allTimetables.add(new Timetable(6,new Lesson("Yoga","Saturday",200),1));
        allTimetables.add(new Timetable(7,new Lesson("Aquacise","Sunday",400),1));
        allTimetables.add(new Timetable(8,new Lesson("Bodysculpt","Sunday",350),1));
        allTimetables.add(new Timetable(9,new Lesson("Spin","Saturday",300),1));
        allTimetables.add(new Timetable(10,new Lesson("Aquacise","Saturday",400),1));
        allTimetables.add(new Timetable(11,new Lesson("Bodysculp","Sunday",350),1));
        allTimetables.add(new Timetable(12,new Lesson("Zumba","Sunday",250),1));
        allTimetables.add(new Timetable(13,new Lesson("Spin","Saturday",300),1));
        allTimetables.add(new Timetable(14,new Lesson("Bodysculpt","Saturday",350),1));
        allTimetables.add(new Timetable(15,new Lesson("Aquacise","Sunday",400),1));
        allTimetables.add(new Timetable(16,new Lesson("Zumba","Sunday",250),1));

        allTimetables.add(new Timetable(17,new Lesson("Spin","Saturday",300),2));
        allTimetables.add(new Timetable(18,new Lesson("Yoga","Saturday",200),2));
        allTimetables.add(new Timetable(19,new Lesson("Spin","Sunday",300),2));
        allTimetables.add(new Timetable(20,new Lesson("Zumba","Sunday",250),2));
        allTimetables.add(new Timetable(21,new Lesson("Bodysculpt","Saturday",350),2));
        allTimetables.add(new Timetable(22,new Lesson("Yoga","Saturday",200),2));
        allTimetables.add(new Timetable(23,new Lesson("Aquacise","Sunday",400),2));
        allTimetables.add(new Timetable(24,new Lesson("Bodysculpt","Sunday",350),2));
        allTimetables.add(new Timetable(25,new Lesson("Spin","Saturday",300),2));
        allTimetables.add(new Timetable(26,new Lesson("Aquacise","Saturday",400),2));
        allTimetables.add(new Timetable(27,new Lesson("Bodysculp","Sunday",350),2));
        allTimetables.add(new Timetable(28,new Lesson("Zumba","Sunday",250),2));
        allTimetables.add(new Timetable(29,new Lesson("Spin","Saturday",300),2));
        allTimetables.add(new Timetable(30,new Lesson("Bodysculpt","Saturday",350),2));
        allTimetables.add(new Timetable(31,new Lesson("Aquacise","Sunday",400),2));
        allTimetables.add(new Timetable(32,new Lesson("Zumba","Sunday",250),2));

    }
    public static int TimetableByDay(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the day you want to see(Saturday or Sunday):");
        String day = input.nextLine().toString();
        List<Timetable>filteredTimetable=new ArrayList<Timetable>();
        for (Timetable timetable:allTimetables){
            if (timetable.lesson.day.toLowerCase().equals(day)){
                filteredTimetable.add(timetable);
            }
        }
        return DisplayTimetable(filteredTimetable);
    }
    public static int TimetableByFitness(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the fitness type (Yoga,Spin,Zumba,Bodysculpt) you want to see");
        String type = input.nextLine().toString();
        List<Timetable>filteredTimetable=new ArrayList<Timetable>();
        for (Timetable timetable:allTimetables){
            if (timetable.lesson.type.toLowerCase().equals(type)){
                filteredTimetable.add(timetable);
            }
        }
        return DisplayTimetable(filteredTimetable);
    }
    public static int DisplayTimetable(List<Timetable>filteredTimetable){
        Scanner input = new Scanner(System.in);
        System.out.println("Id \t Lesson \t Day \t Price");
        int i = 0;
        for (Timetable timetable:filteredTimetable){
            System.out.println("%d \t %s \t%s \t%.2f".formatted(timetable.timetableId,timetable.lesson.type,timetable.lesson.day,timetable.lesson.price));
            i++;
        }
        System.out.println("Select Your Timetable According to the Id:");
        int select=input.nextInt();
        return select;
    }
}
