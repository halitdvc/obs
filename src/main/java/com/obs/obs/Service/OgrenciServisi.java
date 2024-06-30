package com.obs.obs.Service;

import com.obs.obs.DTO.OgrenciDTO;
import com.obs.obs.Entity.Ogrenci;

import java.util.List;

public interface OgrenciServisi {
    List<OgrenciDTO> getButunOgr();
    void yeniOgrKaydet(OgrenciDTO ogrenciDTO);
    OgrenciDTO getOgrenciId(Long id);

    void guncelleTamamla(OgrenciDTO ogrenciDTO);

    void sil(Long num);
}
