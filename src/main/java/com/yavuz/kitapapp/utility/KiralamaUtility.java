package com.yavuz.kitapapp.utility;

import com.yavuz.kitapapp.entity.Kasiyer;

import static com.yavuz.kitapapp.utility.StaticValues.*;

public class KiralamaUtility {
    public static String kasiyerIsmiAl(){
        System.out.println("Kasiyerin ismini giriniz.");
        String isim = scanner.nextLine();
        return isim;
    }

    public static String kitapIsmiAl(){
        System.out.println("Kitabın ismini giriniz.");
        String isim = scanner.nextLine();
        return isim;
    }

    public static String musteriIsmiAl(){
        System.out.println("Müşterinin ismini giriniz.");
        String isim = scanner.nextLine();
        return isim;
    }

    public static boolean kiralamaBilgisiAl(){
        System.out.println("Kitabı kiralamak için 'evet' yazınız.");
        String kiralama = scanner.nextLine();
        return kiralama.equalsIgnoreCase("evet");
    }

    public static Kasiyer kasiyerBul(){
        System.out.println("Lütfen kasiyer numaranızı giriniz.");
        Long id = scanner.nextLong();
        scanner.nextLine();
        for(Kasiyer kasiyer : KASIYER_LISTESI) {
            if(kasiyer.getId().equals(id))
                return kasiyer;
        }
        return null;
    }
}
