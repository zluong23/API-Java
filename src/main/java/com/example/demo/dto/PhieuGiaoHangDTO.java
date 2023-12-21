package com.example.demo.dto;

import com.example.demo.entity.DiaChi;
import com.example.demo.entity.HoaDon;
import com.example.demo.entity.PhieuGiaoHang;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class PhieuGiaoHangDTO {
    UUID maphieu;
    String nguoinhan;
    String nguoigiao;
    Double phigiaohang;

    @JsonFormat(pattern = "dd/MM/yyyy")
    Date ngaylap;
    String nguoilap;

    String tendiachi;
    String tinhthanhpho;

    public PhieuGiaoHangDTO(PhieuGiaoHang pgh) {
        maphieu = pgh.getMaphieugiao();
        nguoinhan = pgh.getNguoinhan();
        nguoigiao = pgh.getNguoigiao();
        phigiaohang = pgh.getPhigiaohang();
        HoaDon hd = pgh.getHoadongiao();
        if(hd != null){
            ngaylap = hd.getNgaylap();
            nguoilap = hd.getNguoilap();
        }

        DiaChi dc = pgh.getDiachigiao();

        if(dc != null) {
            tendiachi = dc.getTendiachi();
            tinhthanhpho = dc.getTinhthanhpho();
        }
    }
}
