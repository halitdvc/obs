package com.obs.obs.Eslesme;

import com.obs.obs.DTO.OgrenciDTO;
import com.obs.obs.Entity.Ogrenci;

public class Esleme {
    public static OgrenciDTO ogrenciDTOEsle(Ogrenci ogrenci){
        OgrenciDTO ogrenciDTO= new OgrenciDTO(
                ogrenci.getNum(),
                ogrenci.getAd(),
                ogrenci.getSoyad(),
                ogrenci.getYas()
        );
        return ogrenciDTO;
    }
    public static Ogrenci ogrenciEsle(OgrenciDTO ogrenciDTO){
        Ogrenci ogrenci=new Ogrenci(
                ogrenciDTO.getNum(),
                ogrenciDTO.getAd(),
                ogrenciDTO.getSoyad(),
                ogrenciDTO.getYas()
        );
        return ogrenci;
    }
}
