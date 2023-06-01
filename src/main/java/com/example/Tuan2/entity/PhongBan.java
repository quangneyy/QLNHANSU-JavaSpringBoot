package com.example.Tuan2.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "PhongBan")
public class PhongBan {
    @Id
    @Column(name = "ma_phong")
    @NotEmpty(message = "ma phong khong duoc trong")
    @Size(max = 2, min = 1, message = "Ma phong co 2 ky tu")
    private String ma_phong;
    @Column(name = "ten_phong")
    @NotEmpty(message = "ten phong khong duoc trong")
    @Size(max = 40, min = 1, message = "Ten phong co it hon 40 ky tu")
    private String ten_phong;
    @OneToMany(mappedBy = "PHONGBAN",cascade = CascadeType.ALL)
    private List<NhanVien> NhanViens;
}