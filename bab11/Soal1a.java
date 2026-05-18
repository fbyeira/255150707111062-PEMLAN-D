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
 
public class TinggiBadan {
    public static void main(String[] args) {
 
        int[][] dataA = {
            {168,50},{170,60},{165,56},{168,55},{172,60},
            {170,70},{169,66},{165,56},{171,72},{166,56}
        };
        int[][] dataB = {
            {170,66},{167,60},{165,59},{166,58},{168,58},
            {175,71},{172,68},{171,68},{168,65},{169,60}
        };
 
        ArrayList<Player> allPlayers = new ArrayList<>();
        for (int[] d : dataA) allPlayers.add(new Player("A", d[0], d[1]));
        for (int[] d : dataB) allPlayers.add(new Player("B", d[0], d[1]));
 
        // --- Ascending ---
        ArrayList<Player> ascending = new ArrayList<>(allPlayers);
        Collections.sort(ascending, (a, b) -> a.height - b.height);
 
        System.out.println("=== Tinggi Badan ASCENDING (Menaik) ===");
        for (int i = 0; i < ascending.size(); i++)
            System.out.println((i+1) + ". " + ascending.get(i));
 
        // --- Descending ---
        ArrayList<Player> descending = new ArrayList<>(allPlayers);
        Collections.sort(descending, (a, b) -> b.height - a.height);
 
        System.out.println("\n=== Tinggi Badan DESCENDING (Menurun) ===");
        for (int i = 0; i < descending.size(); i++)
            System.out.println((i+1) + ". " + descending.get(i));
    }
}
 
