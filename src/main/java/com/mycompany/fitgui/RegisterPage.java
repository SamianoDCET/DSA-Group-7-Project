/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitgui;

/**
 *
 * @author JAY
 */
import javax.swing.*;
import java.awt.*;

public class RegisterPage extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;

    public RegisterPage() {
        setTitle("Register");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2));

        add(new JLabel("Choose Username:"));
        usernameField = new JTextField();
        add(usernameField);

        add(new JLabel("Choose Password:"));
        passwordField = new JPasswordField();
        add(passwordField);

        JButton createBtn = new JButton("Create Account");

        createBtn.addActionListener(e -> {
            String username = usernameField.getText().trim();
            String password = new String(passwordField.getPassword());

            if (UserAccount.register(username, password)) {
                JOptionPane.showMessageDialog(this, "Account created!");
                new LoginPage();
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Username already exists.");
            }
        });

        add(createBtn);

        setVisible(true);
    }
}