package com.example.demo.service;

import com.example.demo.entity.PhieuGiaoHang;
import com.example.demo.repo.PhieuGiaoHangRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PhieuGiaoHangService {
    @Autowired
    PhieuGiaoHangRepo repo;

    public List<PhieuGiaoHang> findAll(){
        return repo.findAll();
    }

    public Page<PhieuGiaoHang> findAll(Pageable pageable){
        return repo.findAll(pageable);
    }

    public PhieuGiaoHang save(PhieuGiaoHang pgh) {
        return repo.save(pgh);
    }

    public void deleteById(UUID id) {
        repo.deleteById(id);
    }
}
