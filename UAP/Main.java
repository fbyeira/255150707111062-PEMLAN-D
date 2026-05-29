import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static GoDriveRentalSystem system = new GoDriveRentalSystem();

    public static void main(String[] args) {
        // Data awal
        system.tambahKendaraan(new Mobil("MBL01", "Toyota Avanza", 350000, 7));
        system.tambahKendaraan(new Mobil("MBL02", "Daihatsu Sigra", 300000, 7));
        system.tambahKendaraan(new Mobil("MBL03", "Honda Brio", 200000, 5));
        system.tambahKendaraan(new Motor("MTR01", "Honda Vario", 80000, "Matik"));
        system.tambahKendaraan(new Motor("MTR02", "Yamaha NMAX", 100000, "Matik"));
        system.tambahKendaraan(new Motor("MTR03", "Kawasaki KLX", 90000, "Manual"));

        boolean running = true;
        while (running) {
            tampilMenu();
            System.out.print("Pilih menu: ");
            int pilihan;
            try {
                pilihan = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] Input tidak valid, masukkan angka.");
                continue;
            }

            switch (pilihan) {
                case 1 -> tambahKendaraan();
                case 2 -> system.tampilkanDaftarKendaraan();
                case 3 -> sewaKendaraan();
                case 4 -> kembalikanKendaraan();
                case 5 -> {
                    System.out.println("Terima kasih telah menggunakan GoDrive Rental System!");
                    running = false;
                }
                default -> System.out.println("[ERROR] Pilihan tidak valid.");
            }
        }
        scanner.close();
    }

    static void tampilMenu() {
        System.out.println("\n====== MENU GO DRIVE RENTAL SYSTEM ======");
        System.out.println("1. Tambah Kendaraan");
        System.out.println("2. Tampilkan Daftar Armada");
        System.out.println("3. Sewa Kendaraan");
        System.out.println("4. Kembalikan Kendaraan");
        System.out.println("5. Keluar");
    }

    static void tambahKendaraan() {
        System.out.print("Masukkan jenis kendaraan (mobil/motor): ");
        String jenis = scanner.nextLine().trim().toLowerCase();

        System.out.print("Masukkan kode kendaraan: ");
        String kode = scanner.nextLine().trim();

        System.out.print("Masukkan nama kendaraan: ");
        String nama = scanner.nextLine().trim();

        System.out.print("Masukkan harga sewa per hari: ");
        double harga;
        try {
            harga = Double.parseDouble(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] Harga tidak valid.");
            return;
        }

        if (jenis.equals("mobil")) {
            System.out.print("Masukkan kapasitas kursi: ");
            int kursi;
            try {
                kursi = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] Jumlah kursi tidak valid.");
                return;
            }
            system.tambahKendaraan(new Mobil(kode, nama, harga, kursi));
        } else if (jenis.equals("motor")) {
            System.out.print("Masukkan jenis transmisi (Matik/Manual): ");
            String transmisi = scanner.nextLine().trim();
            system.tambahKendaraan(new Motor(kode, nama, harga, transmisi));
        } else {
            System.out.println("[ERROR] Jenis kendaraan tidak dikenali.");
        }
    }

    static void sewaKendaraan() {
        System.out.print("Masukkan kode kendaraan yang ingin disewa: ");
        String kode = scanner.nextLine().trim();

        System.out.print("Masukkan durasi sewa (dalam hari): ");
        int lama;
        try {
            lama = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] Durasi tidak valid.");
            return;
        }

        System.out.print("Apakah Anda Member VIP? (y/n): ");
        boolean isVIP = scanner.nextLine().trim().equalsIgnoreCase("y");

        try {
            system.sewaKendaraan(kode, lama, isVIP);
        } catch (KendaraanTidakTersediaException e) {
            System.out.println("Exception in thread \"main\" KendaraanTidakTersediaException: " + e.getMessage());
        }
    }

    static void kembalikanKendaraan() {
        System.out.print("Masukkan kode kendaraan yang ingin dikembalikan: ");
        String kode = scanner.nextLine().trim();
        system.kembalikanKendaraan(kode);
    }
}
