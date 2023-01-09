package com.yavuz.kitapapp.service;

import com.yavuz.kitapapp.entity.Kasiyer;
import com.yavuz.kitapapp.repository.KasiyerRepository;

import java.util.List;

public class KasiyerService {
    private final KasiyerRepository kasiyerRepository;

    public KasiyerService(){
        kasiyerRepository = new KasiyerRepository();
    }

    public void save(Kasiyer kasiyer){
        kasiyerRepository.save(kasiyer);
    }
    public void update(Kasiyer kasiyer){
        kasiyerRepository.update(kasiyer);
    }
    public void delete(Long id){
        kasiyerRepository.delete(id);
    }
    public List<Kasiyer> findAll(){
        return kasiyerRepository.findAll();
    }
    public Kasiyer findById(Long id){
        return kasiyerRepository.findById(id);
    }
}
