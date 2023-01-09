package com.yavuz.kitapapp.controller;

import com.yavuz.kitapapp.entity.Kasiyer;
import com.yavuz.kitapapp.entity.Kitap;
import com.yavuz.kitapapp.entity.Musteri;
import com.yavuz.kitapapp.service.KasiyerService;
import com.yavuz.kitapapp.service.KitapService;
import com.yavuz.kitapapp.service.MusteriService;

import java.util.List;
import java.util.stream.Collectors;

import static com.yavuz.kitapapp.utility.KiralamaUtility.*;
import static com.yavuz.kitapapp.utility.StaticValues.KITAP_LISTESI;
import static com.yavuz.kitapapp.utility.StaticValues.MUSTERI_LISTESI;

public class KiralamaController {
    private final KasiyerService kasiyerService;
    private final KitapService kitapService;
    private final MusteriService musteriService;

    public KiralamaController(){
        kasiyerService = new KasiyerService();
        kitapService = new KitapService();
        musteriService = new MusteriService();
    }

    public KiralamaController(KasiyerService kasiyerService, KitapService kitapService, MusteriService musteriService) {
        this.kasiyerService = kasiyerService;
        this.kitapService = kitapService;
        this.musteriService = musteriService;
    }

    public void kasiyerEkle(){
        String isim = kasiyerIsmiAl();
        Kasiyer kasiyer = new Kasiyer(isim);
        kasiyerService.save(kasiyer);
    }

    public void kitapEkle(){
        String isim = kitapIsmiAl();
        boolean kiralama = kiralamaBilgisiAl();
        Kitap kitap = new Kitap(isim,kiralama);
        kitapService.save(kitap);
    }

    public void musteriEkle(){
        String isim = musteriIsmiAl();
        Musteri musteri = new Musteri(isim);
        musteriService.save(musteri);
    }

    public void kiralamaYap(Kasiyer kasiyer, Kitap kitap, Musteri musteri) {
        kitap.setKiranalabilir(false);
        kasiyer.getKiralananKitaplar().add(kitap);
        musteri.getKiralananKitaplar().add(kitap);
    }

    public Kitap kitapAra(Long id) {
        return kitapService.findById(id);
    }

    public Musteri musteriAra(Long id) {
        return musteriService.findById(id);
    }

    public List<Kitap> kiralananKitapListesi() {
        return kitapService.findAll()
                .stream()
                .filter(x -> !x.isKiralanabilir())
                .collect(Collectors.toList());
    }
}
