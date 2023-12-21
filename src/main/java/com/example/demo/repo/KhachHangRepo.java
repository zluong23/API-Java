package com.example.demo.repo;

import com.example.demo.entity.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KhachHangRepo extends JpaRepository<KhachHang, Long> {
}
