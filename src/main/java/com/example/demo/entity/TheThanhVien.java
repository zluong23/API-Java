package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Table(name="thethanhvien")
@Data @AllArgsConstructor @NoArgsConstructor
public class TheThanhVien {
    @Id String mathe;
    String mauthe;
    String loaithe;

    //@JsonIgnore
    @OneToOne @JoinColumn(name="nguoisohuu")
    KhachHang nguoisohuu;
}
