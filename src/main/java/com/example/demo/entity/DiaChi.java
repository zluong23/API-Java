package com.example.demo.entity;

import jakarta.annotation.security.DenyAll;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name="diachi")
@Data @AllArgsConstructor @NoArgsConstructor
public class DiaChi {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    UUID madiachi;
    String tendiachi;
    String tinhthanhpho;

    @ManyToOne @JoinColumn(name="khachhang")
    KhachHang khachhang;
}
