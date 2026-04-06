package bab6;

public class Manusia {
    private String nama;
    private String nik;
    private boolean jenisKelamin;
    private boolean menikah;

    public Manusia(String nama, String nik, boolean jenisKelamin, boolean menikah){
        this.nama = nama;
        this.nik = nik;
        this.jenisKelamin = jenisKelamin;
        this.menikah = menikah;
    }

    public double getTunjangan(){
        if(menikah){
            if(jenisKelamin) return 25;
            else return 20;
        } else return 15;
    }

    public double getPendapatan(){
        return getTunjangan();
    }

    public String toString(){
        return "nama : " + nama +
               "\nnik : " + nik +
               "\njenisKelamin : " + (jenisKelamin ? "Laki-laki" : "Perempuan") +
               "\npendapatan : " + getPendapatan();
    }
}