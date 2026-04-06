package bab6;

public class Main {
    public static void main(String[] args) {

        // 1. MANUSIA
        System.out.println("=== MANUSIA ===");

        // a. Laki-laki menikah
        Manusia m1 = new Manusia("A", "111", true, true);
        System.out.println(m1);

        // b. Perempuan menikah
        Manusia m2 = new Manusia("B", "222", false, true);
        System.out.println("\n" + m2);

        // c. Belum menikah
        Manusia m3 = new Manusia("C", "333", true, false);
        System.out.println("\n" + m3);


        // 2. MAHASISWA FILKOM
        System.out.println("\n=== MAHASISWA ===");

        // a. IPK < 3
        MahasiswaFILKOM s1 = new MahasiswaFILKOM("165150200111001", 2.8,
                "D", "444", false, false);
        System.out.println(s1);

        // b. IPK 3 – 3.5
        MahasiswaFILKOM s2 = new MahasiswaFILKOM("165150300111002", 3.2,
                "E", "555", true, false);
        System.out.println("\n" + s2);

        // c. IPK 3.5 – 4
        MahasiswaFILKOM s3 = new MahasiswaFILKOM("165150400111003", 3.8,
                "F", "666", false, false);
        System.out.println("\n" + s3);


        // 3. PEKERJA
        System.out.println("\n=== PEKERJA ===");

        // a. Lama 2 tahun, anak 2
        Pekerja p1 = new Pekerja(3000, 2022, 1, 1, 2,
                "G", "777", true, true);
        System.out.println(p1);

        // b. Lama 9 tahun
        Pekerja p2 = new Pekerja(4000, 2017, 1, 1, 9,
                "H", "888", false, true);
        System.out.println("\n" + p2);

        // c. Lama 20 tahun, anak 10
        Pekerja p3 = new Pekerja(5000, 2005, 1, 1, 10,
                "I", "999", true, true);
        System.out.println("\n" + p3);


        // 4. MANAGER
        System.out.println("\n=== MANAGER ===");

        Manager mgr = new Manager("HRD", 7500, 2010, 1, 1, 3,
                "J", "1010", true, true);
        System.out.println(mgr);
    }
}