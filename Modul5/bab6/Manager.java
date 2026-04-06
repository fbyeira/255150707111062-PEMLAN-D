package bab6;

public class Manager extends Pekerja {
    private String departemen;

    public Manager(String departemen, double gaji, int tahun, int bulan, int hari,
                   int jumlahAnak, String nama, String nik, boolean jk, boolean menikah){
        super(gaji, tahun, bulan, hari, jumlahAnak, nama, nik, jk, menikah);
        this.departemen = departemen;
    }

    public double getPendapatan(){
        return super.getPendapatan() + (0.1 * super.getPendapatan());
    }

    public String toString(){
        return super.toString() +
               "\ndepartemen : " + departemen;
    }
}