package bab11;

import java.util.*;
 
public class Soal2d {
    public static void main(String[] args) {
 
        int[][] dataA = {
            {168,50},{170,60},{165,56},{168,55},{172,60},
            {170,70},{169,66},{165,56},{171,72},{166,56}
        };
        int[][] dataB = {
            {170,66},{167,60},{165,59},{166,58},{168,58},
            {175,71},{172,68},{171,68},{168,65},{169,60}
        };
 
        ArrayList<Integer> heightsA = new ArrayList<>();
        ArrayList<Integer> weightsA = new ArrayList<>();
        ArrayList<Integer> heightsB = new ArrayList<>();
        ArrayList<Integer> weightsB = new ArrayList<>();
 
        for (int[] d : dataA) { heightsA.add(d[0]); weightsA.add(d[1]); }
        for (int[] d : dataB) { heightsB.add(d[0]); weightsB.add(d[1]); }
 
        System.out.println("Tinggi badan Tim A : " + heightsA);
        System.out.println("Tinggi badan Tim B : " + heightsB);
 
        // --- Cek kesamaan TINGGI BADAN ---
        boolean disjointHeight = Collections.disjoint(heightsA, heightsB);
        if (!disjointHeight) {
            Set<Integer> sama = new HashSet<>(heightsA);
            sama.retainAll(new HashSet<>(heightsB));
            System.out.println("\nAda pemain dengan TINGGI BADAN yang sama: " + sama + " cm");
        } else {
            System.out.println("\nTidak ada pemain dengan tinggi badan yang sama.");
        }
 
        System.out.println("\nBerat badan Tim A : " + weightsA);
        System.out.println("Berat badan Tim B : " + weightsB);
 
        // --- Cek kesamaan BERAT BADAN ---
        boolean disjointWeight = Collections.disjoint(weightsA, weightsB);
        if (!disjointWeight) {
            Set<Integer> sama = new HashSet<>(weightsA);
            sama.retainAll(new HashSet<>(weightsB));
            System.out.println("\nAda pemain dengan BERAT BADAN yang sama: " + sama + " kg");
        } else {
            System.out.println("\nTidak ada pemain dengan berat badan yang sama.");
        }
    }
}
