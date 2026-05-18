package bab8;

public class Invoice implements Payable {

    String productName;
    int quantity;
    int pricePerItem;

    // konstruktor
    public Invoice(String productName, int quantity, int pricePerItem) {
        this.productName = productName;
        this.quantity = quantity;
        this.pricePerItem = pricePerItem;
    }

    // menghitung total harga barang
    @Override
    public int getPayableAmount() {
        return quantity * pricePerItem;
    }

    // tampil invoice
    public void tampilInvoice() {
        System.out.println("Nama Barang   : " + productName);
        System.out.println("Jumlah Barang : " + quantity);
        System.out.println("Harga/item    : " + pricePerItem);
        System.out.println("Total         : " + getPayableAmount());
        System.out.println();
    }

}