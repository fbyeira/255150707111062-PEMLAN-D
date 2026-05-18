package bab11;

import java.util.*;
 
public class Soal2b {
    public static void main(String[] args) {
 
        int[][] dataB = {
            {170,66},{167,60},{165,59},{166,58},{168,58},
            {175,71},{172,68},{171,68},{168,65},{169,60}
        };
 
        // Ambil hanya data tinggi badan Tim B
        ArrayList<Integer> heightsB = new ArrayList<>();
        for (int[] d : dataB) heightsB.add(d[0]);
 
        Collections.sort(heightsB); // wajib sort sebelum binarySearch
        System.out.println("Tinggi badan Tim B (sorted): " + heightsB);
 
        // --- Cari tinggi 168 cm ---
        int key1 = 168;
        int freq168 = Collections.frequency(heightsB, key1);
        int idx168  = Collections.binarySearch(heightsB, key1);
 
        System.out.println("\n--- Pencarian tinggi " + key1 + " cm ---");
        System.out.println("Binary Search -> indeks pertama ditemukan : " + (idx168 >= 0 ? idx168 : "tidak ditemukan"));
        System.out.println("Frequency     -> jumlah pemain            : " + freq168 + " pemain");
 
        // --- Cari tinggi 160 cm ---
        int key2 = 160;
        int freq160 = Collections.frequency(heightsB, key2);
        int idx160  = Collections.binarySearch(heightsB, key2);
 
        System.out.println("\n--- Pencarian tinggi " + key2 + " cm ---");
        System.out.println("Binary Search -> " + (idx160 >= 0 ? "indeks ditemukan: " + idx160 : "tidak ditemukan"));
        System.out.println("Frequency     -> jumlah pemain : " + freq160 + " pemain");
    }
}
 
