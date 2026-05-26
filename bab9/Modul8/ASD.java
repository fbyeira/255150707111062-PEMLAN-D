package bab9.Modul8;

public class ASD extends MataKuliah {

    public ASD(double tugas, double kuis, double uts, double uas) {
        super(tugas, kuis, uts, uas);
    }

    @Override
    public double hitungNilaiAkhir() {
        return (0.25 * tugas) + (0.15 * kuis) + (0.3 * uts) + (0.3 * uas);
    }
}
