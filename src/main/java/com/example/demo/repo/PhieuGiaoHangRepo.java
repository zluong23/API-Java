package com.example.demo.repo;

import com.example.demo.entity.HoaDon;
import com.example.demo.entity.PhieuGiaoHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface PhieuGiaoHangRepo extends JpaRepository<PhieuGiaoHang, UUID> {
}
