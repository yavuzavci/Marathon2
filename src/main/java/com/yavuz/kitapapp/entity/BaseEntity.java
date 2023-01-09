package com.yavuz.kitapapp.entity;

import static com.yavuz.kitapapp.utility.StaticValues.*;

public abstract class BaseEntity {
    private Long id;

    public BaseEntity(){
        id = idOlustur();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "id=" + id +
                '}';
    }

    public long idOlustur(){
        switch(this.getClass().getSimpleName()){
            case "Kasiyer":
                return yeniKasiyerIdAl();
            case "Kitap":
                return yeniKitapIdAl();
            case "Musteri":
                return yeniMusteriIdAl();
            default:
                return Long.MIN_VALUE;
        }
    }
}
