package com.obs.obs.DTO;

import jakarta.validation.constraints.NotEmpty;

public class OgrenciDTO {
    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public int getYas() {
        return yas;
    }

    public void setYas(int yas) {
        this.yas = yas;
    }

    private Long num;
    @NotEmpty(message = "Ogrenci Adini yaziniz")
    private String ad;
    @NotEmpty(message ="Ogrenci S" +
            "" +
            "oyadini yaziniz")
    private String soyad;
    private int yas;
    public OgrenciDTO(){
    }
    public OgrenciDTO(Long num, String ad, String soyad, int yas){
        this.num=num;
        this.ad=ad;
        this.soyad=soyad;
        this.yas=yas;
    }
}
