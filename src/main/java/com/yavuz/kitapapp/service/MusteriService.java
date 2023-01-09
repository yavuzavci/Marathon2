package com.yavuz.kitapapp.service;

import com.yavuz.kitapapp.entity.Musteri;
import com.yavuz.kitapapp.repository.MusteriRepository;

import java.util.List;

public class MusteriService {
    private final MusteriRepository musteriRepository;

    public MusteriService(){
        musteriRepository = new MusteriRepository();
    }

    public void save(Musteri musteri){
        musteriRepository.save(musteri);
    }
    public void update(Musteri musteri){
        musteriRepository.update(musteri);
    }
    public void delete(Long id){
        musteriRepository.delete(id);
    }
    public List<Musteri> findAll(){
        return musteriRepository.findAll();
    }
    public Musteri findById(Long id){
        return musteriRepository.findById(id);
    }
}
