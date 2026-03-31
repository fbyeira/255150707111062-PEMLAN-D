import java.util.Scanner;

public class Jaket {
    
    static final int HARGA_A = 100000;
    static final int HARGA_B = 125000;
    static final int HARGA_C = 175000;

    public static void main(String[] args) {
        Scanner y = new Scanner(System.in);

        System.out.println("========================================");
        System.out.println("CV. LABKOMDAS - Penjualan Jaket");
        System.out.println("========================================");
        System.out.println("Daftar Harga Normal Jaket (satuan):");
        System.out.println("Jaket A : Rp 100.000");
        System.out.println("Jaket B : Rp 125.000");
        System.out.println("Jaket C : Rp 175.000");
        System.out.println("Catatan : Diskon berlaku jika beli > 100 buah");
        System.out.println("Jaket A : Rp 95.000 / biji");
        System.out.println("Jaket B : Rp 120.000 / biji");
        System.out.println("Jaket C : Rp 160.000 / biji");
        System.out.println("========================================");


        System.out.print("Masukkan jumlah Jaket A yang dibeli : ");
        int jumlahA = y.nextInt();
        System.out.print("Masukkan jumlah Jaket B yang dibeli : ");
        int jumlahB = y.nextInt();
        System.out.print("Masukkan jumlah Jaket C yang dibeli : ");
        int jumlahC = y.nextInt();
        System.out.println("========================================");

        
        int hargaSatuanA, hargaSatuanB, hargaSatuanC;
        String statusA, statusB, statusC;

        if (jumlahA > 100) {
            hargaSatuanA = 95000;
            statusA = "[DISKON] ";
        } else {
            hargaSatuanA = HARGA_A;
            statusA = "[NORMAL] ";
        }

        if (jumlahB > 100) {
            hargaSatuanB = 120000;
            statusB = "[DISKON] ";
        } else {
            hargaSatuanB = HARGA_B;
            statusB = "[NORMAL] ";
        }

        if (jumlahC > 100) {
            hargaSatuanC = 160000;
            statusC = "[DISKON] ";
        } else {
            hargaSatuanC = HARGA_C;
            statusC = "[NORMAL] ";
        }

        long totalA = (long) jumlahA * hargaSatuanA;
        long totalB = (long) jumlahB * hargaSatuanB;
        long totalC = (long) jumlahC * hargaSatuanC;
        long grandTotal = totalA + totalB + totalC;

        // CETAK STRUK PEMBELIAN
        System.out.println("             STRUK PEMBELIAN");
        System.out.println("========================================");
        
        System.out.println("Jaket A : " + jumlahA + " buah");
        System.out.println("          " + statusA + "Harga: Rp " + formatUang(hargaSatuanA) + "/biji");
        System.out.println("          Total : Rp " + formatUang(totalA));
        
        System.out.println("Jaket B : " + jumlahB + " buah");
        System.out.println("          " + statusB + "Harga: Rp " + formatUang(hargaSatuanB) + "/biji");
        System.out.println("          Total : Rp " + formatUang(totalB));

        System.out.println("Jaket C : " + jumlahC + " buah");
        System.out.println("          " + statusC + "Harga: Rp " + formatUang(hargaSatuanC) + "/biji");
        System.out.println("          Total : Rp " + formatUang(totalC));

        System.out.println("----------------------------------------");
        System.out.println("GRAND TOTAL    : Rp " + formatUang(grandTotal));
        System.out.println("========================================");
        
        y.close();
    }

    static String formatUang(long nominal) {
        return String.format("%,d", nominal).replace(',', '.');
    }
}