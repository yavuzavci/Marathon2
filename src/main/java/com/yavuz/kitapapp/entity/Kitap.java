package com.yavuz.kitapapp.entity;

public class Kitap extends BaseEntity {
    private String isim;
    private boolean kiralanabilir;
    private Kasiyer kiralayanKasiyer;
    private Musteri kiralayanMusteri;

    public Kitap(String isim, boolean kiralanabilir){
        super();
        this.isim = isim;
        this.kiralanabilir = kiralanabilir;
        kiralayanKasiyer = null;
        kiralayanMusteri = null;
    }

    public Kitap(String isim, boolean kiralanabilir, Kasiyer kiralayanKasiyer, Musteri kiralayanMusteri) {
        super();
        this.isim = isim;
        this.kiralanabilir = kiralanabilir;
        this.kiralayanKasiyer = kiralayanKasiyer;
        this.kiralayanMusteri = kiralayanMusteri;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public boolean isKiralanabilir() {
        return kiralanabilir;
    }

    public void setKiranalabilir(boolean kiralanabilir) {
        this.kiralanabilir = kiralanabilir;
    }

    public Kasiyer getKiralayanKasiyer() {
        return kiralayanKasiyer;
    }

    public void setKiralayanKasiyer(Kasiyer kiralayanKasiyer) {
        this.kiralayanKasiyer = kiralayanKasiyer;
    }

    public Musteri getKiralayanMusteri() {
        return kiralayanMusteri;
    }

    public void setKiralayanMusteri(Musteri kiralayanMusteri) {
        this.kiralayanMusteri = kiralayanMusteri;
    }

    @Override
    public String toString() {
        return "Kitap{" +
                "id='" + getId() + '\'' +
                ", isim='" + isim + '\'' +
                ", kiralanabilir=" + kiralanabilir +
                ", kiralayanKasiyer=" + kiralayanKasiyer +
                ", kiralayanMusteri=" + kiralayanMusteri +
                '}';
    }
}
