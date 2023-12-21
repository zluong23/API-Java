package com.example.demo.service;

import com.example.demo.entity.DiaChi;
import com.example.demo.repo.DiaChiRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DiaChiService {
    @Autowired
    DiaChiRepo repo;

    public List<DiaChi> findAll(){
        return repo.findAll();
    }
    public Page<DiaChi> findAll(Pageable pageable) {
        return repo.findAll(pageable);
    }
    public DiaChi save(DiaChi diachi){
        return repo.save(diachi);
    }

    public void deleteById(UUID id) {
        repo.deleteById(id);
    }
}
