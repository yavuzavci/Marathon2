package com.yavuz.kitapapp.controller;

import com.yavuz.kitapapp.service.KasiyerService;
import com.yavuz.kitapapp.service.KitapService;
import com.yavuz.kitapapp.service.MusteriService;

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
}
