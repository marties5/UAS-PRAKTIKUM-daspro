// ==================================================== //
// NAMA : Zhidan marties alfareza
// Kelas : SIB-1E
// Nomor Absen : 21
// ==================================================== //

import java.util.Scanner;

public class UAS1E21 {
    static Scanner input21 = new Scanner(System.in);

    static int duaNimAkhir21 = 62;
    static int levelPermainan21 = 2;
    static int penguranganSkorJikaGenap = 15;
    static int penguranganSkorJikaDiatas50 = 21;

    static int jumlahTim21 = (duaNimAkhir21 % 3) + 4;
    // static int jumlahTim21 = 3; for testing code 
    static String[] namaTim = new String[0];
    static int[][] skorTim = new int[jumlahTim21][levelPermainan21];
    static int[] totalSkor = new int[jumlahTim21];

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n============ MENU UTAMA ===========");
            System.out.println("1. Input Data Tim dan Skor");
            System.out.println("2. Tampilkan Tabel Skor");
            System.out.println("3. Tentukan Juara Turnamen");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");
            int pilihan = input21.nextInt();

            switch (pilihan) {
                case 1:
                    inputData21();
                    break;
                case 2:
                    tampilkanTabelSkor21();
                    break;
                case 3:
                    tentukanJuara21();
                    break;
                case 4:
                    System.out.println(
                            "Terimakasih kepada Zhidan Marties Alfareza SIB-1E telah membuat struktuk system ini.");
                    return;
                default:
                    System.out.println(pilihan + " Tidak ada pada menu,Silahkan coba lagi bang !");
            }
        }
    }

    public static void inputData21() {
        System.out.println("\n------------------------------------------------");
        System.out.println("===         Input Data Tim dan  Skor         ===");
        System.out.println("------------------------------------------------");
        namaTim = new String[jumlahTim21];
        for (int i = 0; i < namaTim.length; i++) {
            System.out.print("Masukkan nama tim ke-" + (i + 1) + ": ");
            namaTim[i] = input21.next();
            for (int j = 0; j < levelPermainan21; j++) {
                while (true) {
                    System.out.print("Masukkan skor tim " + namaTim[i] + " untuk Level " + (j + 1) + ": ");
                    int skor = input21.nextInt();

                    if (skor < 0) {
                        System.out.println("Skor tidak boleh negatif. Silakan masukkan ulang.");
                    } else {
                        if (j == 0 && skor < 35) {
                            skor = 0;
                        }
                        skorTim[i][j] = skor;
                        break;
                    }
                }
            }

            totalSkor[i] = skorTim[i][0] + skorTim[i][1];
            if (totalSkor[i] % 2 == 0) {
                totalSkor[i] -= penguranganSkorJikaGenap;
            }

            if (skorTim[i][0] > 50 && skorTim[i][1] > 50) {
                totalSkor[i] += penguranganSkorJikaDiatas50;
            }
        }
    }

    public static void tampilkanTabelSkor21() {
        if (namaTim.length != 0) {
            System.out.println("\n------------------------------------------------");
            System.out.println("===                Tabel Skor                ===");
            System.out.println("------------------------------------------------");
            System.out.printf("%-15s %-10s %-10s %-10s\n", "Nama Tim", "Level 1", "Level 2", "Total Skor");
            for (int i = 0; i < namaTim.length; i++) {
                System.out.printf("%-15s %-10d %-10d %-10d\n", namaTim[i], skorTim[i][0], skorTim[i][1], totalSkor[i]);
            }
        } else {
            NotFoundData();
        }
    }

    public static void tentukanJuara21() {
        System.out.println("\n=== Penentuan Juara ===");
        int indexJuara = 0;
        boolean seri = false;

        for (int i = 1; i < namaTim.length; i++) {
            if (totalSkor[i] > totalSkor[indexJuara]) {
                indexJuara = i;
                seri = false;
            } else if (totalSkor[i] == totalSkor[indexJuara]) {
                if (skorTim[i][1] > skorTim[indexJuara][1]) {
                    indexJuara = i;
                    seri = false;
                } else if (skorTim[i][1] == skorTim[indexJuara][1]) {
                    seri = true;
                }
            }
        }

        if (namaTim.length != 0) {
            if (seri) {
                System.out.println("Turnamen berakhir seri. Tim terbaik adalah Zhidan Marties Alfareza.");
            } else {
                System.out.println("Selamat kepada Tim " + namaTim[indexJuara]
                        + " yang telah memenangkan kompetisi dengan skor!"
                        + (skorTim[indexJuara][1] + skorTim[indexJuara][0]));
            }
        } else {
            NotFoundData();
        }

    }

    public static void NotFoundData() {
        System.out.println("\n------------------------------------------------");
        System.out.println("================ BELUM ADA DATA ================");
        System.out.println("------------------------------------------------");
    }
}