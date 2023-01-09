package com.yavuz.kitapapp.utility.menu;

import static com.yavuz.kitapapp.utility.StaticValues.*;

public class KasiyerMenu implements IMenu{
    @Override
    public void menu() {
        int secim = 0;
        do{
            kasiyerMenuBaslik();
            System.out.print("Lütfen seçiminizi yapınız...: ");
            secim = scanner.nextInt();
            scanner.nextLine();
            islemSec(secim);
        } while (secim != 0);
        ANA_MENU.menu();
    }

    @Override
    public void islemSec(int secim) {
        switch (secim){
            case 1:
                CONTROLLER.kasiyerEkle();
                break;
            case 2:
                CONTROLLER.kitapEkle();
                break;
            case 3:
                CONTROLLER.musteriEkle();
                break;
            case 4:
                CONTROLLER.kiralamaYap();
                break;
            case 5:
                CONTROLLER.kitapIadesiYap();
                break;
            case 0:
                break;
            default:
                System.out.println("HATA: Geçersiz seçim yaptınız.");
                break;
        }
    }

    private void kasiyerMenuBaslik(){
        System.out.println("*********************************");
        System.out.println("******* KASİYER İŞLEMLERİ *******");
        System.out.println("*********************************");
        System.out.println("1 -> Kasiyer Ekle");
        System.out.println("2 -> Kitap Ekle");
        System.out.println("3 -> Müşteri Ekle");
        System.out.println("4 -> Kitap Kirala");
        System.out.println("5 -> Kitap İadesi Al");
        System.out.println("0 -> Ana Menüye Dön");
    }
}
