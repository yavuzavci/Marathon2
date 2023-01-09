package com.yavuz.kitapapp.entity;

import java.util.ArrayList;
import java.util.List;

public class Musteri extends BaseEntity {
    private String isim;
    private List<Kitap> kiralananKitaplar;

    public Musteri(String isim) {
        this.isim = isim;
        kiralananKitaplar = new ArrayList<>();
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public List<Kitap> getKiralananKitaplar() {
        return kiralananKitaplar;
    }

    public void setKiralananKitaplar(List<Kitap> kiralananKitaplar) {
        this.kiralananKitaplar = kiralananKitaplar;
    }

    @Override
    public String toString() {
        return "Musteri{" +
                "id='" + getId() + '\'' +
                ", isim='" + isim + '\'' +
                ", kiralananKitaplar=" + kiralananKitaplar +
                '}';
    }
}
