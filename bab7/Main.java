package bab7;

public class Main {
    public static void main(String[] args) {

        Kue[] kueArray = new Kue[20];

        // Isi data (campur)
        for(int i = 0; i < 20; i++){
            if(i % 2 == 0){
                kueArray[i] = new KuePesanan("KuePesanan"+i, 10000, i+1);
            } else {
                kueArray[i] = new KueJadi("KueJadi"+i, 2000, i+2);
            }
        }

        double totalHarga = 0;
        double totalHargaPesanan = 0;
        double totalBerat = 0;
        double totalHargaJadi = 0;
        double totalJumlah = 0;

        Kue maxKue = kueArray[0];

        System.out.println("=== DAFTAR KUE ===");
        for(Kue k : kueArray){
            System.out.println(k);

            double harga = k.hitungHarga();
            totalHarga += harga;

            if(k instanceof KuePesanan){
                totalHargaPesanan += harga;
                totalBerat += ((KuePesanan)k).getBerat();
            } else if(k instanceof KueJadi){
                totalHargaJadi += harga;
                totalJumlah += ((KueJadi)k).getJumlah();
            }

            if(harga > maxKue.hitungHarga()){
                maxKue = k;
            }
        }

        System.out.println("\n=== TOTAL ===");
        System.out.println("Total semua harga: " + totalHarga);

        System.out.println("\nKuePesanan:");
        System.out.println("Total harga: " + totalHargaPesanan);
        System.out.println("Total berat: " + totalBerat);

        System.out.println("\nKueJadi:");
        System.out.println("Total harga: " + totalHargaJadi);
        System.out.println("Total jumlah: " + totalJumlah);

        System.out.println("\nKue dengan harga terbesar:");
        System.out.println(maxKue);
    }
}
