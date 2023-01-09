package com.yavuz.kitapapp.utility.menu;

import static com.yavuz.kitapapp.utility.StaticValues.*;

public class AnaMenu implements IMenu{
    @Override
    public void menu() {
        int secim = 0;
        do{
            anaMenuBaslik();
            System.out.print("Lütfen seçiminizi yapınız...: ");
            secim = scanner.nextInt();
            scanner.nextLine();
            islemSec(secim);
        } while (secim != 0);
        scanner.close();
        System.out.println("Uygulama sonlandırıldı.");
        System.exit(0);
    }

    @Override
    public void islemSec(int secim) {
        switch (secim){
            case 1:
                KASIYER_MENU.menu();
                break;
            case 2:
                RAPORLAMA_MENU.menu();
                break;
            case 0:
                break;
            default:
                System.out.println("HATA: Geçersiz seçim yaptınız.");
                break;
        }
    }

    private void anaMenuBaslik(){
        System.out.println("*****************************************************");
        System.out.println("************** KİTAP KİRALAMA SİSTEMİ ***************");
        System.out.println("*****************************************************");
        System.out.println("1 -> Kasiyer İşlemleri");
        System.out.println("2 -> Raporlamalar");
        System.out.println("0 -> Uygulamayı Kapat");
    }
}
