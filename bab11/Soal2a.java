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
 
public class Soal2a {
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
 
        System.out.println("=== ArrayList Tim A ===");
        for (int i = 0; i < timA.size(); i++)
            System.out.println((i+1) + ". " + timA.get(i));
 
        System.out.println("\n=== ArrayList Tim B ===");
        for (int i = 0; i < timB.size(); i++)
            System.out.println((i+1) + ". " + timB.get(i));
    }
}
 
