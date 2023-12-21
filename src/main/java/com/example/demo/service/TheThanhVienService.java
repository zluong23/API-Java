package com.example.demo.service;

import com.example.demo.entity.TheThanhVien;
import com.example.demo.repo.TheThanhVienRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheThanhVienService {
    @Autowired
    TheThanhVienRepo repo;

    public List<TheThanhVien> findAll(){
        return repo.findAll();
    }

    public Page<TheThanhVien> findAll(Pageable pageable){
        return repo.findAll(pageable);
    }

    public TheThanhVien save(TheThanhVien ttv) {
        return repo.save(ttv);
    }

    public void deleteById(String id) {
        repo.deleteById(id);
    }
}
