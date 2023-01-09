package com.yavuz.kitapapp.repository;

import com.yavuz.kitapapp.entity.Musteri;

import java.util.List;

import static com.yavuz.kitapapp.utility.StaticValues.*;

public class MusteriRepository implements ICrud<Musteri> {
    @Override
    public void save(Musteri musteri) {
        MUSTERI_LISTESI.add(musteri);
    }

    @Override
    public void update(Musteri musteri) {
        for (int i = 0; i < MUSTERI_LISTESI.size(); i++) {
            if(MUSTERI_LISTESI.get(i).equals(musteri)){
                Musteri eskiMusteri = MUSTERI_LISTESI.get(i);
                MUSTERI_LISTESI.set(i,musteri);
                KITAP_LISTESI.stream()
                        .filter(k -> k.getKiralayanMusteri().equals(eskiMusteri))
                        .forEach(k-> k.setKiralayanMusteri(musteri));
                break;
            }
        }
    }

    @Override
    public void delete(Long id) {
        for (int i = 0; i < MUSTERI_LISTESI.size(); i++) {
            if(MUSTERI_LISTESI.get(i).getId().equals(id)){
                Musteri silinenMusteri = MUSTERI_LISTESI.get(i);
                MUSTERI_LISTESI.remove(i);
                KITAP_LISTESI.stream()
                        .filter(k -> k.getKiralayanMusteri().equals(silinenMusteri))
                        .forEach(k-> k.setKiralayanMusteri(null));
                break;
            }
        }
    }

    @Override
    public List<Musteri> findAll() {
        return MUSTERI_LISTESI;
    }

    @Override
    public Musteri findById(Long id) {
        for(Musteri musteri : MUSTERI_LISTESI){
            if(musteri.getId().equals(id))
                return musteri;
        }
        return null;
    }
}
