import  java.util.Random; //mengimpor kelas random untuk menghasilkan angka acak
import java.util.Scanner; //mengimpor kelas scanner unutk input pengguna

public class GuessTheNumber { //deklarasi kelas utama 
    public static void main(String[] args) { //method utama
        Scanner input = new Scanner(System.in); //membuat objek scanner
        Random random = new Random(); //membuat objek random
        int randomNumber = random.nextInt(100) + 1; //menghasilkan angka acak antara 1 dan 100
        int guess; //variabel untuk menyimpan tebakan pengguna
        int attempts = 0; //variabel untuk menghitung jumlah percobaan
        boolean hasGuessedCorrectly = false; // variabel boolean untuk menandai apakah tebakan sudah benar

        System.out.println("halo! mari bermain tebak angka."); //pesan pembuka
        System.err.println("saya sudah memilih angka antara 1 dan 100."); //intruksi
        System.out.println("bisakah kamu menebaknya?");

        while (!hasGuessedCorrectly){ //perulangan akan terus berjalan selama tebakan belum benar
            System.out.println("masukan tebakanmu"); //meminta tebakan dari pengguna
            guess = input.nextInt(); //membaca tebakan pengguna
            attempts++; //menambah jumlah percobaan
            if (guess < randomNumber){
                System.err.println("terlalu rendah! coba lagi."); // memberi petunjuk
            } else if (guess > randomNumber) { //jika tebakan terlalu besar
                System.err.println("terlalu tinggi! coba lagi.");
            } else { //jika tebakan benar
                hasGuessedCorrectly = true; //mengubah ststus menjadi benar
                System.err.println("selamat! kamu berhasil menebak angka " + randomNumber + " dalam " + attempts + " precobaan "); //pesan kemenangan
            }
            
        }
        input.close(); //menutup objek scanner
    }
}