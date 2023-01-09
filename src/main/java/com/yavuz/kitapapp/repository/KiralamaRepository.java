package com.yavuz.kitapapp.repository;

import com.yavuz.kitapapp.entity.Kasiyer;
import com.yavuz.kitapapp.entity.Kitap;
import com.yavuz.kitapapp.entity.Musteri;

import java.util.List;
import java.util.stream.Collectors;

import static com.yavuz.kitapapp.utility.StaticValues.*;

public class KiralamaRepository implements IKiralama {
    @Override
    public void kiralamaYap(Kasiyer kasiyer, Kitap kitap, Musteri musteri) {
        kitap.setKiranalabilir(false);
        kasiyer.getKiralananKitaplar().add(kitap);
        musteri.getKiralananKitaplar().add(kitap);
    }

    @Override
    public Kitap kitapAra(Long id) {
        for (Kitap kitap : KITAP_LISTESI) {
            if(kitap.getId().equals(id))
                return kitap;
        }
        return null;
    }

    @Override
    public Musteri musteriAra(Long id) {
        for (Musteri musteri : MUSTERI_LISTESI) {
            if(musteri.getId().equals(id))
                return musteri;
        }
        return null;
    }

    @Override
    public List<Kitap> kiralananKitapListesi() {
        return KITAP_LISTESI.stream()
                .filter(x -> !x.isKiralanabilir())
                .collect(Collectors.toList());
    }
}
