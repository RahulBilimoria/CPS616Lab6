/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package cps616.lab6;

import java.util.Hashtable;
import java.util.Scanner;

/**
 *
 * @author minim_000
 */
public class Lab6_2 {

    public static Hashtable<String, Integer> states;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int games = sc.nextInt();
        states = new Hashtable<String, Integer>();
        sc.nextLine();
        String g[] = new String[games];
        for (int x = 0; x < games; x++) {
            g[x] = sc.nextLine();
        }
        for (int x = 0; x < games; x++) {
            System.out.println(topDown(g[x]));
        }
    }

    public static int topDown(String s) {
        int currentCount = 23;
        if (states.containsKey(s)) {
            return states.get(s);
        }
        for (int x = 0; x < s.length() - 2; x++) {
            String sub = s.substring(x, x + 3);
            if (sub.charAt(0) == 'o' && sub.charAt(1) == 'o' && sub.charAt(2) != 'o') {
                sub = "--o";
                currentCount = Math.min(currentCount, topDown(s.substring(0, x) + sub + s.substring(x + 3, s.length())));
            } else if (sub.charAt(1) == 'o' && sub.charAt(2) == 'o' && sub.charAt(0) != 'o') {
                sub = "o--";
                currentCount = Math.min(currentCount, topDown(s.substring(0, x) + sub + s.substring(x + 3, s.length())));
            }
        }
        int c = 0;
        for (int x = 0; x < s.length(); x++) {
            if (s.charAt(x) == 'o') {
                c++;
            }
        }
        currentCount = Math.min(currentCount, c);
        states.put(s, currentCount);
        return currentCount;
    }
}
