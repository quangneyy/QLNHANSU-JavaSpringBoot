package com.example.Tuan2.services;

import com.example.Tuan2.entity.NhanVien;
import com.example.Tuan2.repository.INhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NhanVienService {
    @Autowired
    private INhanVienRepository nhanVienRepository;
    public List<NhanVien> getAllNhanViens(){
        return nhanVienRepository.findAll();
    }
    public NhanVien getNhanVienId(String id){
        return nhanVienRepository.findById(id).orElse(null);
    }
    public void addNhanVien(NhanVien NHANVIEN){
        nhanVienRepository.save(NHANVIEN);
    }
    public void deleteNhanvien(String id){
        nhanVienRepository.deleteById(id);
    }
    public void updateNhanvien(NhanVien NHANVIEN){
        nhanVienRepository.save(NHANVIEN);
    }

}
