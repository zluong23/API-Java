package com.example.demo.dto;

import com.example.demo.entity.DiaChi;
import com.example.demo.entity.KhachHang;
import lombok.Data;

import java.util.UUID;

@Data
public class DiachiDTO {
    UUID madiachi;
    String tendiachi;
    String tinhthanhpho;
    String tenkhachhang;
    String sodienthoai;

    public DiachiDTO(DiaChi dc) {
        madiachi = dc.getMadiachi();
        tendiachi = dc.getTendiachi();
        tinhthanhpho = dc.getTinhthanhpho();
        KhachHang kh = dc.getKhachhang();
        if(kh != null){
            tenkhachhang = kh.getTenkhachhang();
            sodienthoai = kh.getSodienthoai();
        }
    }
}
