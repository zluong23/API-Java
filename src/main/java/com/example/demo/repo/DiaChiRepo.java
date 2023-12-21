package com.example.demo.repo;

import com.example.demo.entity.DiaChi;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DiaChiRepo extends JpaRepository<DiaChi, UUID> {
}
