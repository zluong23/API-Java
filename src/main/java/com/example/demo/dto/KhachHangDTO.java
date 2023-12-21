package com.example.demo.dto;

import com.example.demo.entity.HangKhachHang;
import com.example.demo.entity.KhachHang;
import lombok.Data;

@Data
public class KhachHangDTO {
    Long makhachhang;
    String tenkhachhang;
    String sodienthoai;
    Integer mahang;
    String tenhang;
    Integer diemtoithieu;

    public  KhachHangDTO(KhachHang kh){
        makhachhang = kh.getMakhachhang();
        tenkhachhang = kh.getTenkhachhang();
        sodienthoai = kh.getSodienthoai();
        HangKhachHang hang = kh.getHangkhachhang();
        if(hang != null){
            mahang = hang.getMahang();
            tenhang = hang.getTenhang();
            diemtoithieu = hang.getDiemtoithieu();
        }
    }

}
