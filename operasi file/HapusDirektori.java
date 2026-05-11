import java.io.File;

public class HapusDirektori {
    public static void main(String[] args) {

        File direktori = new File("folderBaru");

        File[] daftarFile = direktori.listFiles();

        if (daftarFile != null) {

            for (File file : daftarFile) {
                file.delete();
            }

            direktori.delete();

            System.out.println("Direktori dan semua file berhasil dihapus");

        } else {
            System.out.println("Direktori tidak ditemukan");
        }
    }
}