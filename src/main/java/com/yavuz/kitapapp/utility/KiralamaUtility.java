package com.yavuz.kitapapp.utility;

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
}
