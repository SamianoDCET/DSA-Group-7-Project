/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitgui;

/**
 *
 * @author JAY
 */
public class Progress {

    private WorkoutLog workoutLog;
    private MealTracker mealTracker;

    public Progress(WorkoutLog workoutLog, MealTracker mealTracker) {
        this.workoutLog = workoutLog;
        this.mealTracker = mealTracker;
    }

    public String generateSummary() {
        return "Total Workouts: " + workoutLog.count() + "\n"
             + "Total Workout Time: " + workoutLog.totalDuration() + " minutes\n"
             + "Total Meals Logged: " + mealTracker.count() + "\n\n"
             + "Keep Going! 💪";
    }
}