package com.example.Tuan2.entity;

import com.example.Tuan2.validator.annotation.ValidPhongBanId;
import com.example.Tuan2.validator.annotation.ValidUserId;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name="NhanVien")
public class NhanVien {
    @Id
    @Column(name = "ma_nv")
    @NotEmpty(message = "Ma nhan vien khong duoc rong")
    @Size(max = 3, min = 1, message = "Ten nhan vien co it hon 100 ky tu")
    private String ma_nv;
    @Column(name = "ten_nv")
    @NotEmpty(message = "Ten nhan vien khong duoc rong")
    @Size(max = 50, min = 1, message = "Ten nhan vien co it hon 100 ky tu")
    private String ten_nv;
    @Column(name = "phai")
    @Size(max = 3, min = 1, message = "Phai co it hon 200 ky tu")
    private String phai;
    @Column(name = "noi_sinh")
    @Size(max = 220, min = 1, message = "Noi sinh co it hon 220 ky tu")
    private String noi_sinh;
    @ManyToOne
    @JoinColumn(name = "ma_phong")
    @ValidPhongBanId
    private PhongBan PHONGBAN;
    @Column(name = "luong")
    private int luong;
    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    @ValidUserId
    private User user;
}
