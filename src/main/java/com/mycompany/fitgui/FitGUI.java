/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.fitgui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class FitGUI extends JFrame {

    private ArrayList<WorkOut> workouts = new ArrayList<>();
    private ArrayList<String> meals = new ArrayList<>();
    private JTextArea workoutLog, mealLog, progressText;
    private JTextField workoutInput, mealInput, durationInput;

    public FitGUI() {
        setTitle("Fitness Tracker");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(1, 3));

        // ====== WORKOUT PANEL ======
        JPanel workoutPanel = new JPanel(new BorderLayout());
        workoutPanel.setBorder(BorderFactory.createTitledBorder("Workout Tracker"));

        workoutLog = new JTextArea();
        workoutLog.setEditable(false);

        workoutInput = new JTextField();
        workoutInput.setToolTipText("Workout Name");

        durationInput = new JTextField();
        durationInput.setToolTipText("Duration (minutes)");

        JPanel workoutInputPanel = new JPanel(new GridLayout(2, 1));
        workoutInputPanel.add(workoutInput);
        workoutInputPanel.add(durationInput);

        JButton addWorkoutBtn = new JButton("Add Workout");
        addWorkoutBtn.addActionListener(e -> {
            String workout = workoutInput.getText().trim();
            String durationText = durationInput.getText().trim();
            
            if (!workout.isEmpty() && !durationText.isEmpty()) {
                try {
                    int duration = Integer.parseInt(durationText);
                    workouts.add(new WorkOut(workout, duration));
                    workoutLog.append("• " + workout + " - " + duration + " mins\n");
                    workoutInput.setText("");
                    durationInput.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Please enter a valid number for duration.");
                }
            }
            updateProgress();
        });

        workoutPanel.add(workoutInputPanel, BorderLayout.NORTH);
        workoutPanel.add(new JScrollPane(workoutLog), BorderLayout.CENTER);
        workoutPanel.add(addWorkoutBtn, BorderLayout.SOUTH);

        // ====== MEAL PANEL ======
        JPanel mealPanel = new JPanel(new BorderLayout());
        mealPanel.setBorder(BorderFactory.createTitledBorder("Meal Tracker"));

        mealLog = new JTextArea();
        mealLog.setEditable(false);
        mealInput = new JTextField();
        JButton addMealBtn = new JButton("Add Meal");

        addMealBtn.addActionListener(e -> {
            String meal = mealInput.getText().trim();
            if (!meal.isEmpty()) {
                meals.add(meal);
                mealLog.append("• " + meal + "\n");
                mealInput.setText("");
            }
            updateProgress();
        });

        mealPanel.add(new JScrollPane(mealLog), BorderLayout.CENTER);
        mealPanel.add(mealInput, BorderLayout.NORTH);
        mealPanel.add(addMealBtn, BorderLayout.SOUTH);

        // ====== PROGRESS PANEL ======
        JPanel progressPanel = new JPanel(new BorderLayout());
        progressPanel.setBorder(BorderFactory.createTitledBorder("Progress Summary"));

        progressText = new JTextArea();
        progressText.setEditable(false);
        progressPanel.add(new JScrollPane(progressText), BorderLayout.CENTER);

        add(workoutPanel);
        add(mealPanel);
        add(progressPanel);

        setVisible(true);
    }

    private void updateProgress() {
        int totalDuration = 0;
        for (WorkOut w : workouts) {
            totalDuration += w.getDuration();
        }

        progressText.setText("Total Workouts: " + workouts.size() + "\n"
                           + "Total Workout Time: " + totalDuration + " minutes\n"
                           + "Total Meals Logged: " + meals.size() + "\n\n"
                           + "Keep Going! 💪");
    }

}
