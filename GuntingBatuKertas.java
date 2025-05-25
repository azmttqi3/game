import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GuntingBatuKertas {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
    

        int pemainScore = 0;
        int komputerScore = 0;
        int roundCount = 1;
        final int WINNING_SCORE = 3;

        System.out.println("--- Welcome To Game BATU, GUNTING, KERTAS! ---");
        System.out.print("Masukan namamu: ");
        String pemainNama = input.nextLine();

        System.out.println("Halo, " + pemainNama + "! Mari Bermain!");
        System.out.println("Siapa yang mencapai " + WINNING_SCORE + " kemenangan pertama, dia pemenangnya!");

        //perulangan utama game: akan terus berjalan selama belum ada yang mencapai WINNING_SCORE
        while (pemainScore < WINNING_SCORE && komputerScore < WINNING_SCORE){
            System.out.println("\n--- Ronde ke-" + roundCount + " ---");
            System.out.println("Skor saat ini: " + pemainNama + " [" + pemainScore + "] - komputer [" + komputerScore + "]");
            System.out.println("\nPilih salah satu:");
            System.out.println("1. Batu 🪨");
            System.out.println("2. Kertas 📄");
            System.out.println("3. Gunting ✂️");
            System.out.print("Masukan pilihanmu (1/2/3): ");

            int pemainMemilih;

            try {
                pemainMemilih = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Input tidak valid. Harap masukan angka 1, 2, atau 3.");
                input.nextLine();
                continue;
            }

            //validasi input pemain
            if (pemainMemilih < 1 || pemainMemilih > 3){
                System.out.println("pilihan tidak valid! silahkan pilih 1, 2, atau 3.");
                input.nextLine();
                continue;
            }

            int komputerMemilih = random.nextInt(3) + 1;

            //menampilkan pilihan pemain dan komputer dengan emoji
            String pemainChoiceStr = convertChoiceToString(pemainMemilih);
            String komputerChoiceStr = convertChoiceToString(komputerMemilih);
            System.out.println(pemainNama + " memilih: " + pemainChoiceStr);
            System.out.println("komputer memilih: " + komputerChoiceStr);

            //menentukan hasil ronde dan update skor
            String result = determineRoundWinner(pemainMemilih, komputerMemilih);
            System.out.println("Hasil Ronde: " + result);

            System.out.println("Riwayat: Ronde " + roundCount + ": " + pemainNama + "[" + convertChoiceToString(pemainMemilih) + "] vs " + "komputer [" + convertChoiceToString(komputerMemilih) + "]" + result);
           
        
            if (result.equals("Kamu Menang!")) {
                pemainScore++;
            } else if (result.equals("Komputer Menang!")) { 
                komputerScore++;
            }
            roundCount++;
    }    
    
    System.out.println("\n--- Permainan Selesai ---");
    System.out.println("Skor akhir: " + pemainNama + " [" + pemainScore + "] - komputer [" + komputerScore + "]");

    if (pemainScore == WINNING_SCORE){
        System.out.println("Selamat, " + pemainNama + "! kamu adalah PEMENANG PERMAINAN!");
    } else {
        System.out.println("Maaf, komputer adalah PEMENANG PERMAINAN. JANGAN PATAH SEMANGAT!!");
    }

    System.out.println("\nTerima kasih sudah bermain, " + pemainNama + "!");
    input.close();

    }

 public static String convertChoiceToString(int choice) {
        switch (choice) {
            case 1: return "Batu";
            case 2: return "Kertas";
            case 3: return "Gunting";
            default: return "Tidak dikenal";
        }
 }

     public static String convertChoiceEmojiToString(int choice) {
        switch (choice) {
            case 1: return "Batu 🪨";
            case 2: return "Kertas 📄";
            case 3: return "Gunting ✂️";
            default: return "Tidak dikenal"; // Seharusnya tidak tercapai
        }
    }

     public static String determineRoundWinner(int player, int computer) {
        if (player == computer) {
            return "Seri!";
        } else if (
            (player == 1 && computer == 3) || // Batu mengalahkan Gunting
            (player == 2 && computer == 1) || // Kertas mengalahkan Batu
            (player == 3 && computer == 2)    // Gunting mengalahkan Kertas
        ) {
            return "Kamu Menang!";
        } else {
            return "Komputer Menang!";
        }
    }
}