package com.yavuz.kitapapp.entity;

public class Kitap extends BaseEntity {
    private String isim;
    private boolean kiralalabilir;

    public Kitap(String isim, boolean kiralalabilir){
        this.isim = isim;
        this.kiralalabilir = kiralalabilir;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public boolean isKiralalabilir() {
        return kiralalabilir;
    }

    public void setKiralalabilir(boolean kiralalabilir) {
        this.kiralalabilir = kiralalabilir;
    }

    @Override
    public String toString() {
        return "Kitap{" +
                "id='" + getId() + '\'' +
                ", isim='" + isim + '\'' +
                ", kiralalabilir=" + kiralalabilir +
                '}';
    }
}
