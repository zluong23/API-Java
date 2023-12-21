package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name="khachhang")
@Data @AllArgsConstructor @NoArgsConstructor
public class KhachHang {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long makhachhang;
    String tenkhachhang;

    @JsonFormat(pattern = "dd/MM/yyyy")
    Date sinhnhat;

    String sodienthoai;
    Boolean gioitinh;

    @ManyToOne @JoinColumn(name="hangkhachhang")
    HangKhachHang hangkhachhang;
}
