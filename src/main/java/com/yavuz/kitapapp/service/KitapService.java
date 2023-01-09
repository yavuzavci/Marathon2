package com.yavuz.kitapapp.service;

import com.yavuz.kitapapp.entity.Kitap;
import com.yavuz.kitapapp.repository.KitapRepository;

import java.util.List;

public class KitapService {
    private final KitapRepository kitapRepository;

    public KitapService() {
        kitapRepository = new KitapRepository();
    }

    public void save(Kitap kitap){
        kitapRepository.save(kitap);
    }
    public void update(Kitap kitap){
        kitapRepository.update(kitap);
    }
    public void delete(Long id){
        kitapRepository.delete(id);
    }
    public List<Kitap> findAll(){
        return kitapRepository.findAll();
    }
    public Kitap findById(Long id){
        return kitapRepository.findById(id);
    }
}
