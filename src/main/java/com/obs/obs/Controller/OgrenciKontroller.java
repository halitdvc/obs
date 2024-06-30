package com.obs.obs.Controller;

import com.obs.obs.DTO.OgrenciDTO;
import com.obs.obs.Service.OgrenciServisi;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class OgrenciKontroller {
    private OgrenciServisi ogrenciServisi;
    @Autowired
    public OgrenciKontroller(OgrenciServisi ogrenciServisi){
        this.ogrenciServisi=ogrenciServisi;
    }

    @GetMapping("/ogrenciler/{id}/sil")
    public String silOgrenci(@PathVariable("id") Long num){
        ogrenciServisi.sil(num);
        return "redirect:/obsGetirHepsi";
    }
    @GetMapping("/ogrenciler/{id}/goruntule")
    public String ogrenciGoruntule(@PathVariable("id") Long num, Model model){
        OgrenciDTO ogrenci = ogrenciServisi.getOgrenciId(num);
        model.addAttribute("ogrenci",ogrenci);
        return "goruntuleOgrSayfasi";
    }


    @GetMapping("/yeniogr")
    public String yeniOgrenci (Model model){
        OgrenciDTO ogrenciDTO=new OgrenciDTO();
        model.addAttribute("ogrenci", ogrenciDTO);
        return "yeniOgrSayfasi";
    }
    @GetMapping("/obsGetirHepsi")
    public String getirButunOgrenciler(Model model){
        List<OgrenciDTO> ogrencilerGetir=ogrenciServisi.getButunOgr();
        model.addAttribute("ogrenciler",ogrencilerGetir);
        return "getirOBSOgrHepsi";
    }

    @PostMapping("/ogrenciler")
    public String ogrenciyiKaydet(@Valid @ModelAttribute("ogrenci") OgrenciDTO ogrenciDTO, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("ogrenci",ogrenciDTO);
            return "/yeniOgrSayfasi";
        }
        ogrenciServisi.yeniOgrKaydet(ogrenciDTO);
        return "redirect:/obsGetirHepsi";
    }
    @PostMapping("/ogrenciler/{id}")
    public String ogrenciyiGuncellemeyiTamamla(@PathVariable("id") Long num, @ModelAttribute("ogrenci") OgrenciDTO ogrenciDTO, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("ogrenci",ogrenciDTO);
            return "/guncelleOgrSayfasi";
        }
        ogrenciDTO.setNum(num);
        ogrenciServisi.guncelleTamamla(ogrenciDTO);
        return "redirect:/obsGetirHepsi";
    }
    @GetMapping("/ogrenciler/{id}/guncelle")
    public String ogrenciGuncelle(@PathVariable("id") Long num, Model model){
        OgrenciDTO ogrenci = ogrenciServisi.getOgrenciId(num);
        model.addAttribute("ogrenci", ogrenci);
        return "guncelleOgrSayfasi";
    }


    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
