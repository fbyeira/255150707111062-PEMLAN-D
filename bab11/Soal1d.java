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
 
public class Soal1d {
    public static void main(String[] args) {
 
        int[][] dataB = {
            {170,66},{167,60},{165,59},{166,58},{168,58},
            {175,71},{172,68},{171,68},{168,65},{169,60}
        };
 
        ArrayList<Player> timB = new ArrayList<>();
        for (int[] d : dataB) timB.add(new Player("B", d[0], d[1]));
 
        // Buat Tim C dengan ukuran sama, lalu copy dari Tim B
        Player[] arrayC = new Player[timB.size()];
        ArrayList<Player> timC = new ArrayList<>(Arrays.asList(arrayC));
        Collections.copy(timC, timB);
 
        // Ganti label team menjadi C
        for (Player p : timC) p.team = "C";
 
        System.out.println("=== Tim B (sumber) ===");
        for (int i = 0; i < timB.size(); i++)
            System.out.println((i+1) + ". " + timB.get(i));
 
        System.out.println("\n=== Tim C (hasil copy dari Tim B) ===");
        for (int i = 0; i < timC.size(); i++)
            System.out.println((i+1) + ". " + timC.get(i));
    }
}
 
