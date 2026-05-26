package bab9.Modul8;

public class Probstat extends MataKuliah {

    public Probstat(double tugas, double kuis, double uts, double uas) {
        super(tugas, kuis, uts, uas);
    }

    @Override
    public double hitungNilaiAkhir() {
        return (0.1 * tugas) + (0.2 * kuis) + (0.3 * uts) + (0.4 * uas);
    }
}