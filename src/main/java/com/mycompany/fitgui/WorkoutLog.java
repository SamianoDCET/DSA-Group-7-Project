/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitgui;

/**
 *
 * @author JAY
 */
import java.util.ArrayList;

public class WorkoutLog {

    private ArrayList<WorkOut> workouts = new ArrayList<>();

    public void addWorkout(String name, int duration) {
        workouts.add(new WorkOut(name, duration));
    }

    public ArrayList<WorkOut> getWorkouts() {
        return workouts;
    }

    public int totalDuration() {
        int total = 0;
        for (WorkOut w : workouts) total += w.getDuration();
        return total;
    }

    public int count() {
        return workouts.size();
    }
}