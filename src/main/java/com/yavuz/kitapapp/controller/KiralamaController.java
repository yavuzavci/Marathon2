package com.yavuz.kitapapp.controller;

import com.yavuz.kitapapp.entity.Kasiyer;
import com.yavuz.kitapapp.entity.Kitap;
import com.yavuz.kitapapp.entity.Musteri;
import com.yavuz.kitapapp.service.KasiyerService;
import com.yavuz.kitapapp.service.KitapService;
import com.yavuz.kitapapp.service.MusteriService;
import com.yavuz.log.Log;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.yavuz.kitapapp.utility.KiralamaUtility.*;
import static com.yavuz.kitapapp.utility.StaticValues.*;

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
        try{
            String isim = kasiyerIsmiAl();
            Kasiyer kasiyer = new Kasiyer(isim);
            kasiyerService.save(kasiyer);
        }
        catch (Exception exception){
            System.out.println("HATA");
            System.out.println(exception);
            DS.createLog(new Log(
                    exception.getMessage(),
                    1,
                    KiralamaController.class.getSimpleName(),
                    "kasiyerEkle",
                    System.currentTimeMillis(),
                    "kasiyer ekleme hatası"
            ));
        }
    }

    public void kitapEkle(){
        try{
            String isim = kitapIsmiAl();
            boolean kiralama = kiralamaBilgisiAl();
            Kitap kitap = new Kitap(isim,kiralama);
            kitapService.save(kitap);
        }
        catch (Exception exception){
            System.out.println("HATA");
            System.out.println(exception);
            DS.createLog(new Log(
                    exception.getMessage(),
                    2,
                    KiralamaController.class.getSimpleName(),
                    "kitapEkle",
                    System.currentTimeMillis(),
                    "kitap ekleme hatası"
            ));
        }
    }

    public void musteriEkle(){
        try{
            String isim = musteriIsmiAl();
            Musteri musteri = new Musteri(isim);
            musteriService.save(musteri);
        }
        catch (Exception exception){
            System.out.println("HATA");
            System.out.println(exception);
            DS.createLog(new Log(
                    exception.getMessage(),
                    3,
                    KiralamaController.class.getSimpleName(),
                    "musteriEkle",
                    System.currentTimeMillis(),
                    "müşteri ekleme hatası"
            ));
        }
    }

    public void kiralamaYap() {
        try{
            Kasiyer kasiyer = kasiyerBul();
            System.out.println("Lütfen kiralama yapmak istediğiniz kitabın numarasını giriniz.");
            Long kitapId = scanner.nextLong();
            Kitap kitap = kitapAra(kitapId);
            System.out.println("Lütfen kitabın kiralanacağı müşterinin numarasını giriniz.");
            Long musteriId = scanner.nextLong();
            Musteri musteri = musteriAra(musteriId);
            if(kitap.isKiralanabilir())
                kitap.setKiranalabilir(false);
            if(Objects.isNull(kitap.getKiralayanKasiyer()))
                kitap.setKiralayanKasiyer(kasiyer);
            if(Objects.isNull(kitap.getKiralayanMusteri()))
                kitap.setKiralayanMusteri(musteri);

            kasiyer.getKiralananKitaplar().add(kitap);
            musteri.getKiralananKitaplar().add(kitap);
        }
        catch (Exception exception){
            System.out.println("HATA");
            System.out.println(exception);
            DS.createLog(new Log(
                    exception.getMessage(),
                    4,
                    KiralamaController.class.getSimpleName(),
                    "kiralamaYap",
                    System.currentTimeMillis(),
                    "kiralama hatası"
            ));
        }
    }

    public void kitapIadesiYap() {
        try{
            Kasiyer kasiyer = kasiyerBul();
            System.out.println("Lütfen iade yapmak istediğiniz kitabın numarasını giriniz.");
            Long kitapId = scanner.nextLong();
            Kitap kitap = kitapAra(kitapId);
            if(!kitap.isKiralanabilir())
                kitap.setKiranalabilir(true);

            kitap.setKiralayanKasiyer(kasiyer);
            kitap.setKiralayanMusteri(null);
            kitapService.update(kitap);
        }
        catch (Exception exception){
            System.out.println("HATA");
            System.out.println(exception);
            DS.createLog(new Log(
                    exception.getMessage(),
                    5,
                    KiralamaController.class.getSimpleName(),
                    "kitapEkle",
                    System.currentTimeMillis(),
                    "kitap iade hatası"
            ));
        }
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
