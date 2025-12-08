/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitgui;

/**
 *
 * @author JAY
 */
public class FitGUIMain {
    public static void main(String[] args){ 
       FitGUI app = new FitGUI();
       app.setVisible(false);
       
       UserAccount.register("test", "1234"); 
       new LoginPage(); 
    }
}