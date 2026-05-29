import java.util.ArrayList;

public class GoDriveRentalSystem {
    private ArrayList<Kendaraan> daftarKendaraan;

    public GoDriveRentalSystem() {
        this.daftarKendaraan = new ArrayList<>();
    }

    public void tambahKendaraan(Kendaraan k) {
        daftarKendaraan.add(k);
        System.out.println("[INFO] Kendaraan berhasil ditambahkan: " + k.getNamaKendaraan() + " (" + k.getKodeKendaraan() + ")");
    }

    public void tampilkanDaftarKendaraan() {
        if (daftarKendaraan.isEmpty()) {
            System.out.println("Belum ada kendaraan dalam armada.");
            return;
        }
        System.out.println("\n=== DAFTAR ARMADA GODRIVE ===");
        for (int i = 0; i < daftarKendaraan.size(); i++) {
            System.out.print((i + 1) + ". ");
            daftarKendaraan.get(i).tampilInfo();
        }
    }

    public void sewaKendaraan(String kode, int lamaSewa, boolean isVIP) throws KendaraanTidakTersediaException {
        Kendaraan target = null;
        for (Kendaraan k : daftarKendaraan) {
            if (k.getKodeKendaraan().equalsIgnoreCase(kode)) {
                target = k;
                break;
            }
        }

        if (target == null || !target.isTersedia()) {
            String alasan = (target == null) ? "Kendaraan tidak ditemukan!" : "Kendaraan sedang disewa atau tidak ditemukan!";
            throw new KendaraanTidakTersediaException("Kendaraan dengan kode " + kode + " gagal disewa. Alasan: " + alasan);
        }

        // Biaya dasar = lamaSewa x hargaSewaPerHari (tanpa extra)
        double biayaDasar = target.hitungBiayaDasar(lamaSewa);

        // Biaya extra (kursi >5 atau asuransi matik)
        double biayaExtra = 0;
        if (target instanceof Mobil && ((Mobil) target).getJumlahKursi() > 5) {
            biayaExtra += 50000;
        }
        if (target instanceof Motor && ((Motor) target).getJenisTransmisi().equalsIgnoreCase("Matik")) {
            biayaExtra += 10000 * lamaSewa;
        }

        double biayaAkhir = biayaDasar + biayaExtra;

        double diskonVIP = 0;
        double diskonLama = 0;

        if (isVIP) {
            diskonVIP = biayaDasar * 0.10;
            biayaAkhir -= diskonVIP;
        }

        if (lamaSewa > 7) {
            diskonLama = biayaDasar * 0.05;
            biayaAkhir -= diskonLama;
        }

        target.setTersedia(false);

        System.out.println("\n=== TRANSAKSI SEWA GODRIVE ===");
        System.out.println("Kendaraan Berhasil Disewa!");
        System.out.printf("Unit         : %s (%s)%n", target.getNamaKendaraan(), target.getKodeKendaraan());
        System.out.printf("Lama Sewa    : %d hari%n", lamaSewa);
        System.out.printf("Biaya Dasar Harian : Rp %,.0f%n", biayaDasar);

        if (target instanceof Mobil && ((Mobil) target).getJumlahKursi() > 5) {
            System.out.printf("Tambahan Kursi (>5): Rp 50,000%n");
        }
        if (target instanceof Motor && ((Motor) target).getJenisTransmisi().equalsIgnoreCase("Matik")) {
            System.out.printf("Biaya Asuransi Matik : Rp %,.0f%n", 10000.0 * lamaSewa);
        }
        if (isVIP) {
            System.out.printf("Diskon Member VIP (10%%): -Rp %,.0f%n", diskonVIP);
        }
        if (lamaSewa > 7) {
            System.out.printf("Diskon Sewa >7 hari (5%%): -Rp %,.0f%n", diskonLama);
        }
        System.out.println("----------------------------------------");
        System.out.printf("TOTAL BIAYA AKHIR: Rp %,.0f%n", biayaAkhir);
    }

    public void kembalikanKendaraan(String kode) {
        for (Kendaraan k : daftarKendaraan) {
            if (k.getKodeKendaraan().equalsIgnoreCase(kode)) {
                if (k.isTersedia()) {
                    System.out.println("[INFO] Kendaraan " + k.getNamaKendaraan() + " (" + kode + ") sudah tersedia, tidak perlu dikembalikan.");
                } else {
                    k.setTersedia(true);
                    System.out.println("[INFO] Kendaraan " + k.getNamaKendaraan() + " (" + kode + ") berhasil dikembalikan. Status: Tersedia.");
                }
                return;
            }
        }
        System.out.println("[ERROR] Kendaraan dengan kode " + kode + " tidak ditemukan.");
    }
}
