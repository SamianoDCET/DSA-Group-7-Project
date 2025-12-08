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

public class MealTracker {

    private ArrayList<String> meals = new ArrayList<>();

    public void addMeal(String meal) {
        meals.add(meal);
    }

    public ArrayList<String> getMeals() {
        return meals;
    }

    public int count() {
        return meals.size();
    }
}