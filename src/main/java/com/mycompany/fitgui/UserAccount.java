/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitgui;

/**
 *
 * @author JAY
 */
import java.util.HashMap;

public class UserAccount {

    private static HashMap<String, String> accounts = new HashMap<>();

    public static boolean register(String username, String password) {
        if (accounts.containsKey(username)) {
            return false;
        }
        accounts.put(username, password);
        return true;
    }

    public static boolean login(String username, String password) {
        return accounts.containsKey(username) &&
               accounts.get(username).equals(password);
    }
}
    