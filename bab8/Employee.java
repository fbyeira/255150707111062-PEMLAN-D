package bab8;

public class Employee implements Payable {

    int registrationNumber;
    String name;
    int salaryPerMonth;
    Invoice[] invoices;

    // konstruktor
    public Employee(int registrationNumber, String name,
                    int salaryPerMonth, Invoice[] invoices) {

        this.registrationNumber = registrationNumber;
        this.name = name;
        this.salaryPerMonth = salaryPerMonth;
        this.invoices = invoices;
    }

    // menghitung total hutang belanja
    @Override
    public int getPayableAmount() {

        int totalBelanja = 0;

        for (Invoice invoice : invoices) {
            totalBelanja += invoice.getPayableAmount();
        }

        return salaryPerMonth - totalBelanja;
    }

    // tampil data employee
    public void tampilEmployee() {

        System.out.println("===== DATA KARYAWAN =====");
        System.out.println("Nomor Registrasi : " + registrationNumber);
        System.out.println("Nama             : " + name);
        System.out.println("Gaji per Bulan   : " + salaryPerMonth);

        System.out.println("\n===== DETAIL BELANJA =====");

        for (Invoice invoice : invoices) {
            invoice.tampilInvoice();
        }

        int totalBelanja = 0;

        for (Invoice invoice : invoices) {
            totalBelanja += invoice.getPayableAmount();
        }

        System.out.println("Total Belanja : " + totalBelanja);
        System.out.println("Gaji Setelah Dipotong : " + getPayableAmount());

    }

}