package com.obs.obs.Service;

import com.obs.obs.DTO.OgrenciDTO;
import com.obs.obs.Entity.Ogrenci;
import com.obs.obs.Eslesme.Esleme;
import com.obs.obs.Repository.OgrenciRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OgrenciServisUyg implements OgrenciServisi{
    private OgrenciRepo ogrenciRepo;
    @Autowired
    public OgrenciServisUyg(OgrenciRepo ogrenciRepo){
        this.ogrenciRepo=ogrenciRepo;
    }

    @Override
    public List<OgrenciDTO> getButunOgr() {
        List<Ogrenci> ogrenciListesi=ogrenciRepo.findAll();
        List<OgrenciDTO> ogrenciDTOListesi=ogrenciListesi.stream().map(ogrenci -> Esleme.ogrenciDTOEsle(ogrenci)).collect(Collectors.toList());
        return ogrenciDTOListesi;
    }
    public void yeniOgrKaydet(OgrenciDTO ogrenciDTO){
        Ogrenci ogrenci = Esleme.ogrenciEsle(ogrenciDTO);
        ogrenciRepo.save(ogrenci);
    }
    public void sil(Long num){
        ogrenciRepo.deleteById(num);
    }

    @Override
    public OgrenciDTO getOgrenciId(Long id) {
        Ogrenci ogrenci = ogrenciRepo.findById(id).get();
        OgrenciDTO ogrenciDTO=Esleme.ogrenciDTOEsle(ogrenci);
        return ogrenciDTO;
    }

    @Override
    public void guncelleTamamla(OgrenciDTO ogrenciDTO) {
        ogrenciRepo.save(Esleme.ogrenciEsle(ogrenciDTO));
    }
}
