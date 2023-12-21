package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

// PhieuGiaoHang
@Entity
@Table(name="phieugiaohang")
@Data @AllArgsConstructor @NoArgsConstructor
public class PhieuGiaoHang {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    UUID maphieugiao;

    String nguoinhan;
    String sdtnhan;

    String nguoigiao;
    Double phigiaohang;

    @OneToOne @JoinColumn(name = "hoadongiao")
    HoaDon hoadongiao;

    @ManyToOne @JoinColumn(name="diachigiao")
    DiaChi diachigiao;

    public String toString(){
        return maphieugiao.toString();
    }
}
