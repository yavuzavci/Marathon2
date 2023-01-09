package com.yavuz.kitapapp.utility.menu;

import com.yavuz.kitapapp.entity.Musteri;

import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static com.yavuz.kitapapp.utility.StaticValues.*;

public class RaporlamaMenu implements IMenu{
    @Override
    public void menu() {
        int secim = 0;
        do{
            raporlamaMenuBaslik();
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
            case 1:{
                System.out.println("Lütfen kitap numarasını giriniz.");
                Long kitapId = scanner.nextLong();
                System.out.println(CONTROLLER.kiralananKitapListesi()
                        .stream()
                        .filter(k -> k.getId().equals(kitapId))
                        .map(k -> k.getKiralayanMusteri())
                        .findFirst()
                        .get()
                );
                break;
            }
            case 2:{

                break;
            }
            case 3:{
                CONTROLLER.kiralananKitapListesi()
                        .stream()
                        .filter(k -> k.getKiralayanMusteri().getIsim().toLowerCase().startsWith("ahm"))
                        .map(k -> k.getKiralayanMusteri())
                        .collect(Collectors.toList())
                        .forEach(System.out::println);
                break;
            }
            case 4:{
                System.out.println("Lütfen müşteri numarasını giriniz.");
                Long musteriId = scanner.nextLong();
                CONTROLLER.kiralananKitapListesi()
                        .stream()
                        .map(k -> k.getKiralayanMusteri()).collect(Collectors.toList())
                        .forEach(m -> m.getKiralananKitaplar().forEach(System.out::println));
                break;
            }
            case 0:
                break;
            default:
                System.out.println("HATA: Geçersiz seçim yaptınız.");
                break;
        }
    }

    private void raporlamaMenuBaslik(){
        System.out.println("****************************");
        System.out.println("******* RAPORLAMALAR *******");
        System.out.println("****************************");
        System.out.println("1 -> id bilgisi verilmiş olan Kitap kim tarafından kiralanmış");
        System.out.println("2 -> adı verilen kitap daha önce kimler tarafından kiralanmış");
        System.out.println("3 -> ahm ile başlayan müşterilerin listesi");
        System.out.println("4 -> id verilen müşterinin kiraladığı kitapların listesi");
        System.out.println("0 -> Ana Menüye Dön");
    }
}
