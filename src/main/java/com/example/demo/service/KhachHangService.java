package com.example.demo.service;

import com.example.demo.entity.KhachHang;
import com.example.demo.repo.KhachHangRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KhachHangService {
    @Autowired
    KhachHangRepo repo;

    public List<KhachHang> findAll(){
        return repo.findAll();
    }
    public Page<KhachHang> findAll(Pageable pageable) {
        return repo.findAll(pageable);
    }
    public KhachHang save(KhachHang khachHang){
        return repo.save(khachHang);
    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }
}
