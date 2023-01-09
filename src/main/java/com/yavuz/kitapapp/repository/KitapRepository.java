package com.yavuz.kitapapp.repository;

import com.yavuz.kitapapp.entity.Kitap;

import java.util.List;

import static com.yavuz.kitapapp.utility.StaticValues.*;

public class KitapRepository implements ICrud<Kitap> {
    @Override
    public void save(Kitap kitap) {
        KITAP_LISTESI.add(kitap);
        kitap.getKiralayanKasiyer().getKiralananKitaplar().add(kitap);
        kitap.getKiralayanMusteri().getKiralananKitaplar().add(kitap);
    }

    @Override
    public void update(Kitap kitap) {
        for (int i = 0; i < KITAP_LISTESI.size(); i++) {
            if(KITAP_LISTESI.get(i).getId().equals(kitap.getId())){
                KITAP_LISTESI.set(i,kitap);
                KITAP_LISTESI.get(i).getKiralayanKasiyer()
                        .getKiralananKitaplar()
                        .set(kitap.getKiralayanKasiyer().getKiralananKitaplar().indexOf(kitap),kitap);
                KITAP_LISTESI.get(i).getKiralayanMusteri()
                        .getKiralananKitaplar()
                        .set(kitap.getKiralayanMusteri().getKiralananKitaplar().indexOf(kitap),kitap);
                break;
            }
        }
    }

    @Override
    public void delete(Long id) {
        for (int i = 0; i < KITAP_LISTESI.size(); i++) {
            if(KITAP_LISTESI.get(i).getId().equals(id)){
                KITAP_LISTESI.get(i).getKiralayanKasiyer()
                        .getKiralananKitaplar().remove(KITAP_LISTESI.get(i));
                KITAP_LISTESI.get(i).getKiralayanMusteri()
                        .getKiralananKitaplar().remove(KITAP_LISTESI.get(i));
                KITAP_LISTESI.remove(i);
                break;
            }
        }
    }

    @Override
    public List<Kitap> findAll() {
        return KITAP_LISTESI;
    }

    @Override
    public Kitap findById(Long id) {
        for (int i = 0; i < KITAP_LISTESI.size(); i++) {
            if(KITAP_LISTESI.get(i).getId().equals(id)){
                return KITAP_LISTESI.get(i);
            }
        }
        return null;
    }
}
