import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BacaFile {
    public static void main(String[] args) {

        File file = new File("data.txt");

        try {

            Scanner baca = new Scanner(file);

            while (baca.hasNextLine()) {
                System.out.println(baca.nextLine());
            }

            baca.close();

        } catch (FileNotFoundException e) {

            System.out.println("File tidak ditemukan");
        }
    }
}