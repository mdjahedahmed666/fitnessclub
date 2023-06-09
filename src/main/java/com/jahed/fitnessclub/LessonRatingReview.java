package com.jahed.fitnessclub;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LessonRatingReview {
    public int bookingId,reviewId,rating;
    public String review;
    public static List<LessonRatingReview> allRating = new ArrayList<LessonRatingReview>();

    public static void ReviewRating(){
        Scanner input = new Scanner(System.in);
        int bookingId = BookingManager.GetBookingId();
        LessonRatingReview lessonRating = new LessonRatingReview();
        System.out.println("Enter Your Review:");
        lessonRating.review = input.nextLine();
        System.out.println("Rate the Lesson from 1 to 5(1: Very dissatisfied, 2: Dissatisfied, 3: Ok, 4: Satisfied, 5: Very Satisfied):");
        lessonRating.rating = input.nextInt();
        System.out.println("You have completed your review and rating about the lesson.");
        lessonRating.bookingId=bookingId;
        lessonRating.reviewId= LessonRatingReview.allRating.size()+1;
        lessonRating.allRating.add(lessonRating);
    }
    public static void testLessonRatingReview(int bookingId, int reviewId, int rating, String review){
        LessonRatingReview lessonRating = new LessonRatingReview();
        lessonRating.rating = rating;
        lessonRating.bookingId = bookingId;
        lessonRating.reviewId = reviewId;
        lessonRating.review = review;
        LessonRatingReview.allRating.add(lessonRating);
    }
}
