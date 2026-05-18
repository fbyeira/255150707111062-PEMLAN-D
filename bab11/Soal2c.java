package bab11;

import java.util.*;
 
public class Soal2c {
    public static void main(String[] args) {
 
        int[][] dataA = {
            {168,50},{170,60},{165,56},{168,55},{172,60},
            {170,70},{169,66},{165,56},{171,72},{166,56}
        };
 
        // Ambil hanya data berat badan Tim A
        ArrayList<Integer> weightsA = new ArrayList<>();
        for (int[] d : dataA) weightsA.add(d[1]);
 
        Collections.sort(weightsA); // wajib sort sebelum binarySearch
        System.out.println("Berat badan Tim A (sorted): " + weightsA);
 
        // --- Cari berat 56 kg ---
        int key1 = 56;
        int freq56 = Collections.frequency(weightsA, key1);
        int idx56  = Collections.binarySearch(weightsA, key1);
 
        System.out.println("\n--- Pencarian berat " + key1 + " kg ---");
        System.out.println("Binary Search -> indeks pertama ditemukan : " + (idx56 >= 0 ? idx56 : "tidak ditemukan"));
        System.out.println("Frequency     -> jumlah pemain            : " + freq56 + " pemain");
 
        // --- Cari berat 53 kg ---
        int key2 = 53;
        int freq53 = Collections.frequency(weightsA, key2);
        int idx53  = Collections.binarySearch(weightsA, key2);
 
        System.out.println("\n--- Pencarian berat " + key2 + " kg ---");
        System.out.println("Binary Search -> " + (idx53 >= 0 ? "indeks ditemukan: " + idx53 : "tidak ditemukan"));
        System.out.println("Frequency     -> jumlah pemain : " + freq53 + " pemain");
    }
}
 
