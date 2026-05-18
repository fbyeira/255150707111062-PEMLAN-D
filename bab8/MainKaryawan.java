package bab8;

public class MainKaryawan {

    public static void main(String[] args) {

        // membuat invoice belanja
        Invoice invoice1 = new Invoice("Beras", 2, 70000);
        Invoice invoice2 = new Invoice("Minyak", 1, 25000);
        Invoice invoice3 = new Invoice("Gula", 3, 15000);

        // array invoice
        Invoice[] invoices = {invoice1, invoice2, invoice3};

        // membuat employee
        Employee emp1 = new Employee(
                2201,
                "Yeira",
                5000000,
                invoices
        );

        // tampil data
        emp1.tampilEmployee();

    }

}