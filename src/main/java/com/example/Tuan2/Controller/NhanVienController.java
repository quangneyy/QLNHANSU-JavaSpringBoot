package com.example.Tuan2.Controller;

import com.example.Tuan2.entity.NhanVien;
import com.example.Tuan2.services.NhanVienService;
import com.example.Tuan2.services.PhongBanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/nhanviens")
public class NhanVienController {
    @Autowired
    private NhanVienService nhanVienService;
    @Autowired
    private PhongBanService phongBanService;
    @GetMapping
    public String showAllNhanVien(Model model){
        List<NhanVien> nhanViens = nhanVienService.getAllNhanViens();
        model.addAttribute("nhanviens", nhanViens);
        return "nhanvien/list";
    }
    @GetMapping("/add")
    public String addNhanVienForm(Model model){
        model.addAttribute("nhanvien",new NhanVien());
        model.addAttribute("PHONGBANs", phongBanService.getAllPhongBan());
        return "nhanvien/add";
    }
    @PostMapping("/add")
    public String addNhanVien(@Valid @ModelAttribute("nhanvien") NhanVien NHANVIEN, BindingResult result, Model model){
        // check lỗi
        if(result.hasErrors()){
            model.addAttribute("phongbans", phongBanService.getAllPhongBan());
            return "nhanvien/add";
        }
        nhanVienService.addNhanVien(NHANVIEN);
        return "redirect:/nhanviens";
    }
    @GetMapping("/delete/{ma_nv}")
    public String deleteNhanvien(@PathVariable("ma_nv") String ma_nv){
        nhanVienService.deleteNhanvien(ma_nv);
        return "redirect:/nhanviens";
    }
    @GetMapping("edit/{ma_nv}")
    public String editNhanVienForm(@PathVariable("ma_nv")String ma_nv, Model model){
        NhanVien editnhanvien = nhanVienService.getNhanVienId(ma_nv);
        if (editnhanvien != null ){
            model.addAttribute("nhanvien",editnhanvien);
            model.addAttribute("PHONGBANs", phongBanService.getAllPhongBan());
            return "nhanvien/edit";
        }else {
            return "redirect:/nhanviens";
        }
    }

    @PostMapping("edit/{ma_nv}")
    public String editNhanVien(@PathVariable("ma_nv")String ma_nv, @ModelAttribute("nhanvien") @Valid NhanVien editNHANVIEN, BindingResult result, Model model){
        if (result.hasErrors()){
            model.addAttribute("PHONGBANs", phongBanService.getAllPhongBan());
            return "nhanvien/edit";
        }else {
            NhanVien existingNHANVIEN = nhanVienService.getNhanVienId(ma_nv);
            if ( existingNHANVIEN != null){
                existingNHANVIEN.setLuong(editNHANVIEN.getLuong());
                existingNHANVIEN.setNoi_sinh(editNHANVIEN.getNoi_sinh());
                existingNHANVIEN.setPhai(editNHANVIEN.getPhai());
                existingNHANVIEN.setTen_nv(editNHANVIEN.getTen_nv());
                existingNHANVIEN.setPHONGBAN((editNHANVIEN.getPHONGBAN()));
                nhanVienService.updateNhanvien(existingNHANVIEN);
            }
            return "redirect:/nhanviens";
        }
    }

}
