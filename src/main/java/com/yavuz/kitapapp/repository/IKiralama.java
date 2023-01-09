package com.yavuz.kitapapp.repository;

import com.yavuz.kitapapp.entity.Kasiyer;
import com.yavuz.kitapapp.entity.Kitap;
import com.yavuz.kitapapp.entity.Musteri;

import java.util.List;

public interface IKiralama {
    void kiralamaYap(Kasiyer kasiyer, Kitap kitap, Musteri musteri);
    Kitap kitapAra(Long id);
    Musteri musteriAra(Long id);
    List<Kitap> kiralananKitapListesi();
}
