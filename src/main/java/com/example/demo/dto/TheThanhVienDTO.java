package com.example.demo.dto;

import com.example.demo.entity.KhachHang;
import com.example.demo.entity.TheThanhVien;
import lombok.Data;

@Data
public class TheThanhVienDTO {
    String mathe;
    String mauthe;
    String loaithe;
    String tenkhachhang;
    String sodienthoai;

    public TheThanhVienDTO(TheThanhVien ttv){
        mathe = ttv.getMathe();
        mauthe = ttv.getMauthe();
        loaithe = ttv.getLoaithe();
        KhachHang kh = ttv.getNguoisohuu();
        if(kh != null){
            tenkhachhang = kh.getTenkhachhang();
            sodienthoai = kh.getSodienthoai();
        }
    }
}
