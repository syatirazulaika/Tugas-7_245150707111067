package PraktikumTujuh;

public class Main {
    public static void main(String[] args) {
        Kue[] kueArray = new Kue[20];

        for (int i = 0; i < kueArray.length; i++) {
            if (i % 2 == 0) {
                kueArray[i] = new KuePesanan("Kue Lapis " + i, 5000 + i * 100, 1.5 + i * 0.2);
            } else {
                kueArray[i] = new KueJadi("Kue Brownies " + i, 4000 + i * 150, 2 + i * 0.5);
            }
        }

        double totalHarga = 0;
        double totalHargaPesanan = 0;
        double totalBeratPesanan = 0;
        double totalHargaJadi = 0;
        double totalJumlahJadi = 0;
        Kue kueTermahal = kueArray[0];

        System.out.println("=".repeat(100));
        System.out.printf("| %-3s | %-30s | %-15s | %-18s | %-15s |\n", 
                          "No", "Nama Kue", "Jenis", "Harga Akhir", "Detail");
        System.out.println("=".repeat(100));

        for (int i = 0; i < kueArray.length; i++) {
            Kue kue = kueArray[i];
            double hargaAkhir = kue.hitungHarga();
            totalHarga += hargaAkhir;

            String jenis = "";
            String detail = "";

            if (kue instanceof KuePesanan) {
                KuePesanan kp = (KuePesanan) kue;
                jenis = "Kue Pesanan";
                detail = String.format("%.2f kg", kp.getBerat());
                totalHargaPesanan += hargaAkhir;
                totalBeratPesanan += kp.getBerat();
            } else if (kue instanceof KueJadi) {
                KueJadi kj = (KueJadi) kue;
                jenis = "Kue Jadi";
                detail = String.format("%.2f buah", kj.getJumlah());
                totalHargaJadi += hargaAkhir;
                totalJumlahJadi += kj.getJumlah();
            }

            if (hargaAkhir > kueTermahal.hitungHarga()) {
                kueTermahal = kue;
            }

            System.out.printf("| %-3d | %-30s | %-15s | Rp%,16.2f | %-15s |\n", 
                              i + 1, kue.getNama(), jenis, hargaAkhir, detail);
        }

        System.out.println("=".repeat(100));

        System.out.println("\n*~* Rangkuman Statistik:");
        System.out.printf(">> Total Harga Semua Kue           : Rp%,.2f\n", totalHarga);
        System.out.printf(">> Total Harga Kue Pesanan         : Rp%,.2f\n", totalHargaPesanan);
        System.out.printf(">> Total Berat Kue Pesanan         : %.2f kg\n", totalBeratPesanan);
        System.out.printf(">> Total Harga Kue Jadi            : Rp%,.2f\n", totalHargaJadi);
        System.out.printf(">> Total Jumlah Kue Jadi           : %.2f buah\n", totalJumlahJadi);

        System.out.println("\n*~* Kue dengan Harga Tertinggi:");
        System.out.printf(">> Nama Kue   : %s\n", kueTermahal.getNama());
        System.out.printf(">> Harga Akhir: Rp%,.2f\n", kueTermahal.hitungHarga());
        System.out.printf(">> Jenis Kue  : %s\n", (kueTermahal instanceof KuePesanan ? "Kue Pesanan" : "Kue Jadi"));
    }
}
