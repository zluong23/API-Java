package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity @Table(name="hoadon")
@Data @AllArgsConstructor @NoArgsConstructor
public class HoaDon {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long mahoadon;

    String nguoilap;

    @JsonFormat(pattern = "dd/MM/yyyy")
    Date ngaylap;
}
