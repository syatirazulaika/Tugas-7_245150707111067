package PraktikumTujuh;

public class KuePesanan extends Kue {
    private double berat;

    public KuePesanan(String nama, double harga, double berat) {
        super(nama, harga);
        this.berat = berat;
    }

    public double getBerat() {
        return berat;
    }

    @Override
    public double hitungHarga() {
        return getHarga() * berat;
    }

    public String toString() {
        return "Kue Pesanan - " + super.toString() + ", Berat: " + berat + ", Total Harga: " + hitungHarga();
    }
}

