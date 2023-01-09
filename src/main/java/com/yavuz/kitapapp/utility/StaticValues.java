package com.yavuz.kitapapp.utility;

import com.yavuz.kitapapp.entity.Kasiyer;
import com.yavuz.kitapapp.entity.Kitap;
import com.yavuz.kitapapp.entity.Musteri;
import com.yavuz.log.DosyaIslemleri;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StaticValues {
    // Sabitler
    public static final DosyaIslemleri DS = new DosyaIslemleri();
    public static final List<Kasiyer> KASIYER_LISTESI = new ArrayList<>();
    public static final List<Kitap> KITAP_LISTESI = new ArrayList<>();
    public static final List<Musteri> MUSTERI_LISTESI = new ArrayList<>();
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
}
