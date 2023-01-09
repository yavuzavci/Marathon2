package com.yavuz.kitapapp.repository;

import com.yavuz.kitapapp.entity.Kasiyer;

import java.util.List;

import static com.yavuz.kitapapp.utility.StaticValues.*;

public class KasiyerRepository implements ICrud<Kasiyer>{
    @Override
    public void save(Kasiyer kasiyer) {
        KASIYER_LISTESI.add(kasiyer);
    }

    @Override
    public void update(Kasiyer kasiyer) {
        for (int i = 0; i < KASIYER_LISTESI.size(); i++) {
            if(KASIYER_LISTESI.get(i).getId().equals(kasiyer.getId())){
                Kasiyer eskiKasiyer = KASIYER_LISTESI.get(i);
                KASIYER_LISTESI.set(i,kasiyer);
                KITAP_LISTESI.stream()
                        .filter(k -> k.getKiralayanKasiyer().equals(eskiKasiyer))
                        .forEach(k -> k.setKiralayanKasiyer(kasiyer));
                break;
            }
        }
    }

    @Override
    public void delete(Long id) {
        for (int i = 0; i < KASIYER_LISTESI.size(); i++) {
            if(KASIYER_LISTESI.get(i).getId().equals(id)){
                Kasiyer silinenKasiyer = KASIYER_LISTESI.get(i);
                KASIYER_LISTESI.remove(i);
                KITAP_LISTESI.stream()
                        .filter(k -> k.getKiralayanKasiyer().equals(silinenKasiyer))
                        .forEach(k -> k.setKiralayanKasiyer(null));
                break;
            }
        }
    }

    @Override
    public List<Kasiyer> findAll() {
        return KASIYER_LISTESI;
    }

    @Override
    public Kasiyer findById(Long id) {
        for (Kasiyer kasiyer : KASIYER_LISTESI) {
            if (kasiyer.getId().equals(id))
                return kasiyer;
        }
        return null;
    }
}
