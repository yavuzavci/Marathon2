package com.yavuz.kitapapp.utility;

import com.yavuz.kitapapp.controller.KiralamaController;
import com.yavuz.kitapapp.entity.Kasiyer;
import com.yavuz.kitapapp.entity.Kitap;
import com.yavuz.kitapapp.entity.Musteri;
import com.yavuz.kitapapp.service.KasiyerService;
import com.yavuz.kitapapp.service.KitapService;
import com.yavuz.kitapapp.service.MusteriService;
import com.yavuz.kitapapp.utility.menu.AnaMenu;
import com.yavuz.kitapapp.utility.menu.KasiyerMenu;
import com.yavuz.kitapapp.utility.menu.RaporlamaMenu;
import com.yavuz.log.DosyaIslemleri;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StaticValues {
    // Sabitler
    public static final DosyaIslemleri DS = new DosyaIslemleri();
    public static final KiralamaController CONTROLLER = new KiralamaController(
            new KasiyerService(), new KitapService(), new MusteriService());
    public static final List<Kasiyer> KASIYER_LISTESI = new ArrayList<>();
    public static final List<Kitap> KITAP_LISTESI = new ArrayList<>();
    public static final List<Musteri> MUSTERI_LISTESI = new ArrayList<>();
    public static final AnaMenu ANA_MENU = new AnaMenu();
    public static final KasiyerMenu KASIYER_MENU = new KasiyerMenu();
    public static final RaporlamaMenu RAPORLAMA_MENU = new RaporlamaMenu();
    // Değişkenler
    public static Scanner scanner = new Scanner(System.in);
    private static Long kasiyerId = 0L;
    private static Long kitapId = 0L;
    private static Long musteriId = 0L;
    //Methodlar
    public static long yeniKasiyerIdAl(){
        return ++kasiyerId;
    }
    public static long yeniKitapIdAl(){
        return ++kitapId;
    }
    public static long yeniMusteriIdAl(){
        return ++musteriId;
    }
    public static void init(){
        Kitap kitap = new Kitap("Nutuk",true);
        Kasiyer kasiyer = new Kasiyer("Ayşe YILMAZ");
        Musteri musteri = new Musteri("Ahmet ÇELİKTEN");
        kitap.setKiralayanKasiyer(kasiyer);
        kitap.setKiralayanMusteri(musteri);
        kitap.setKiranalabilir(false);
        kasiyer.getKiralananKitaplar().add(kitap);
        musteri.getKiralananKitaplar().add(kitap);
        KITAP_LISTESI.add(kitap);
        KASIYER_LISTESI.add(kasiyer);
        MUSTERI_LISTESI.add(musteri);

        kitap = new Kitap("Şeker Portakalı",true);
        kasiyer = new Kasiyer("Hayri CAN");
        musteri = new Musteri("Fahri ÖZTÜRK");
        kitap.setKiralayanKasiyer(kasiyer);
        kitap.setKiralayanMusteri(musteri);
        kitap.setKiranalabilir(false);
        kasiyer.getKiralananKitaplar().add(kitap);
        musteri.getKiralananKitaplar().add(kitap);
        KITAP_LISTESI.add(kitap);
        KASIYER_LISTESI.add(kasiyer);
        MUSTERI_LISTESI.add(musteri);

        kitap = new Kitap("Taht Oyunları",true);
        musteri = new Musteri("Noyan SUBAŞI");
        kitap.setKiralayanKasiyer(kasiyer);
        kitap.setKiralayanMusteri(musteri);
        kitap.setKiranalabilir(false);
        kasiyer.getKiralananKitaplar().add(kitap);
        musteri.getKiralananKitaplar().add(kitap);
        KITAP_LISTESI.add(kitap);
        KASIYER_LISTESI.add(kasiyer);
        MUSTERI_LISTESI.add(musteri);

        kitap = new Kitap("Yıldız Savaşları",true);
        kasiyer = new Kasiyer("Fatma AKTAŞ");
        musteri = new Musteri("Ece TÜRKOĞLU");
        kitap.setKiralayanKasiyer(kasiyer);
        kitap.setKiralayanMusteri(musteri);
        kitap.setKiranalabilir(false);
        kasiyer.getKiralananKitaplar().add(kitap);
        musteri.getKiralananKitaplar().add(kitap);
        KITAP_LISTESI.add(kitap);
        KASIYER_LISTESI.add(kasiyer);
        MUSTERI_LISTESI.add(musteri);

        kitap = new Kitap("Aşk-ı Memnu",true);
        musteri = new Musteri("Sevgi ERTAŞ");
        kitap.setKiralayanKasiyer(kasiyer);
        kitap.setKiralayanMusteri(musteri);
        kitap.setKiranalabilir(false);
        kasiyer.getKiralananKitaplar().add(kitap);
        musteri.getKiralananKitaplar().add(kitap);
        KITAP_LISTESI.add(kitap);
        KASIYER_LISTESI.add(kasiyer);
        MUSTERI_LISTESI.add(musteri);

        kitap = new Kitap("Tutunamayanlar",true);
        KITAP_LISTESI.add(kitap);
        kitap = new Kitap("Çalıkuşu",true);
        KITAP_LISTESI.add(kitap);
        kitap = new Kitap("Kürk Mantolu Madonna",true);
        KITAP_LISTESI.add(kitap);
        kitap = new Kitap("Yüzüklerin Efendisi",true);
        KITAP_LISTESI.add(kitap);
        kitap = new Kitap("Silmarillion",true);
        KITAP_LISTESI.add(kitap);
        kitap = new Kitap("Sefiller",true);
        KITAP_LISTESI.add(kitap);
    }

    public static void run(){
        init();
        ANA_MENU.menu();
    }
}
