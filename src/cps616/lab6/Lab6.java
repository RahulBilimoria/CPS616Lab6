/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package cps616.lab6;

import java.util.Scanner;

/**
 *
 * @author minim_000
 */
public class Lab6 {

    public static int moves[];
    public static int states;
    public static int count;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        states = (int)Math.pow(2,12);
        moves = new int[states];
        int games = sc.nextInt();
        sc.nextLine();
        String g[] = new String[games];
        for (int x = 0; x < games; x++) {
            g[x] = sc.nextLine();
        }
        for (int x = 0; x < games; x++) {
            count = 12;
            System.out.println(bruteForce(g[x]));
        }
    }

    public static int bruteForce(String s) {
        for (int x = 0; x < s.length()-2; x++){
            String sub = s.substring(x,x+3);
            if (sub.equals("oo-")){
                sub = "--o";
                bruteForce(s.substring(0,x) + sub + s.substring(x+3, s.length()));
            }
            else if (sub.equals("-oo")){
                sub = "o--";
                bruteForce(s.substring(0,x) + sub + s.substring(x+3, s.length()));
            }
        }
        int c = 0;
        for (int x = 0; x < s.length(); x++){
            if (s.charAt(x) == 'o'){
                c++;
            }
        }
        count = Math.min(count, c);
        return count;
    }
}