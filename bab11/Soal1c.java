package bab11;

import java.util.*;
 
class Player {
    String team;
    int height;
    int weight;
 
    public Player(String team, int height, int weight) {
        this.team = team;
        this.height = height;
        this.weight = weight;
    }
 
    @Override
    public String toString() {
        return "Tim " + team + " | Tinggi: " + height + " cm | Berat: " + weight + " kg";
    }
}
 
public class MaxMinTBdanBB {
    public static void main(String[] args) {
 
        int[][] dataA = {
            {168,50},{170,60},{165,56},{168,55},{172,60},
            {170,70},{169,66},{165,56},{171,72},{166,56}
        };
        int[][] dataB = {
            {170,66},{167,60},{165,59},{166,58},{168,58},
            {175,71},{172,68},{171,68},{168,65},{169,60}
        };
 
        ArrayList<Player> timA = new ArrayList<>();
        ArrayList<Player> timB = new ArrayList<>();
        for (int[] d : dataA) timA.add(new Player("A", d[0], d[1]));
        for (int[] d : dataB) timB.add(new Player("B", d[0], d[1]));
 
        Comparator<Player> byHeight = (a, b) -> a.height - b.height;
        Comparator<Player> byWeight = (a, b) -> a.weight - b.weight;
 
        System.out.println("=== MAX & MIN - TIM A ===");
        System.out.println("Tinggi MAX : " + Collections.max(timA, byHeight));
        System.out.println("Tinggi MIN : " + Collections.min(timA, byHeight));
        System.out.println("Berat  MAX : " + Collections.max(timA, byWeight));
        System.out.println("Berat  MIN : " + Collections.min(timA, byWeight));
 
        System.out.println("\n=== MAX & MIN - TIM B ===");
        System.out.println("Tinggi MAX : " + Collections.max(timB, byHeight));
        System.out.println("Tinggi MIN : " + Collections.min(timB, byHeight));
        System.out.println("Berat  MAX : " + Collections.max(timB, byWeight));
        System.out.println("Berat  MIN : " + Collections.min(timB, byWeight));
    }
}
 