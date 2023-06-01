package com.example.Tuan2.services;

import com.example.Tuan2.entity.PhongBan;
import com.example.Tuan2.repository.IPhongBanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhongBanService {
    @Autowired
    private IPhongBanRepository phongbanRepository;
    public List<PhongBan> getAllPhongBan(){ return phongbanRepository.findAll();}
    public PhongBan getPhongBanById(String id){return phongbanRepository.findById(id).orElse(null);}
    public PhongBan savePhongban(PhongBan PHONGBAN) { return phongbanRepository.save(PHONGBAN);}
    public void deletePhongban(String id){ phongbanRepository.deleteById(id);}
}