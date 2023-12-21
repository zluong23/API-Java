package com.example.demo.controller;

import com.example.demo.dto.PhieuGiaoHangDTO;
import com.example.demo.entity.PhieuGiaoHang;
import com.example.demo.service.PhieuGiaoHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequestMapping("/phieu-giao-hang")
@RestController
public class PhieuGiaoHangController {

    @Autowired
    PhieuGiaoHangService service;

    List<PhieuGiaoHangDTO> serializeList(List<PhieuGiaoHang> lst){
        List items = new ArrayList();
        for(PhieuGiaoHang pgh : lst) items.add(new PhieuGiaoHangDTO(pgh));
        return items;
    }

    @GetMapping("/get-all")
    public List<PhieuGiaoHangDTO> getAll(){
        return serializeList(service.findAll());
    }

    @GetMapping("/get-page")
    public List<PhieuGiaoHangDTO> getPage(@RequestParam(defaultValue = "0") int p) {
        Pageable pageable = PageRequest.of(p, 5);
        Page<PhieuGiaoHang> page = service.findAll(pageable);
        return serializeList(page.toList());
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody PhieuGiaoHang pgh) {
        String error = "";
        // TODO : Validate data --> error
        if(!error.isEmpty()){
            return ResponseEntity.badRequest().body(error);
        }

        service.save(pgh);
        return ResponseEntity.ok(new PhieuGiaoHangDTO(pgh));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable UUID id, @RequestBody PhieuGiaoHang pgh) {
        String error = "";
        // TODO : Validate data --> error
        if(!error.isEmpty()){
            return ResponseEntity.badRequest().body(error);
        }
        pgh.setMaphieugiao(id);
        service.save(pgh);
        return ResponseEntity.ok(new PhieuGiaoHangDTO(pgh));
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable UUID id) {
        service.deleteById(id);
    }
}
