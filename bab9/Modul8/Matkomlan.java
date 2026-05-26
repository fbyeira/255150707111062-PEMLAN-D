package bab9.Modul8;

public class Matkomlan extends MataKuliah {

    public Matkomlan(double tugas, double kuis, double uts, double uas) {
        super(tugas, kuis, uts, uas);
    }

    @Override
    public double hitungNilaiAkhir() {
        return (0.3 * tugas) + (0.2 * kuis) + (0.2 * uts) + (0.3 * uas);
    }
}