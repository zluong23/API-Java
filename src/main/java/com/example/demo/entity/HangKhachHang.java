package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="hangkhachhang")
@Data @AllArgsConstructor @NoArgsConstructor
public class HangKhachHang {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id Integer mahang;

    String tenhang;
    Integer diemtoithieu;
}
