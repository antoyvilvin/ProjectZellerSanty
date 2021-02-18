/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.k
 */
package prgitsanty;

/**
 *18/02/2021
 * @author antonyvilvin
 */
public class PrGitSanty {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int day = 4, month = 1, year = 2001;
        String stDat = birthDay_ZellerMonlau(day, month, year);
        System.out.println("Internacionall program's day: " + stDat + " sep2021");
    }

    private static String birthDay_ZellerMonlau(int day, int month, int year) {
String[] ArrayWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int a, y, m, d;
        a = (14 - month) / 12;
        y = year - a;
        m = month + 12 * a - 2;
        d = (day + y + y / 4 - y / 100 + y / 400 + (31 * m) / 12  )%7;
        return ArrayWeek[d];    }
    
}
