package com.yavuz.kitapapp.entity;

import java.util.ArrayList;
import java.util.List;

public class Kasiyer extends BaseEntity {
    private String isim;
    private List<Kitap> kiralananKitaplar;

    public Kasiyer(String isim) {
        super();
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
        return "Kasiyer{" +
                "id='" + getId() + '\'' +
                ", isim='" + isim + '\'' +
                '}';
    }
}
