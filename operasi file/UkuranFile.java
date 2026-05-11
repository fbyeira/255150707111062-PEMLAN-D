import java.io.File;

public class UkuranFile {
    public static void main(String[] args) {

        File file = new File("test.txt");

        if (file.exists()) {

            long size = file.length();

            double kb = size / 1024.0;
            double mb = size / (1024.0 * 1024.0);

            if (mb < 1) {
                System.out.println("Ukuran file : " + kb + " KB");
            } else {
                System.out.println("Ukuran file : " + mb + " MB");
            }

        } else {
            System.out.println("File tidak ditemukan");
        }
    }
}