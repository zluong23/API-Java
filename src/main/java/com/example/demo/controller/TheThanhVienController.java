package com.example.demo.controller;

import com.example.demo.dto.TheThanhVienDTO;
import com.example.demo.entity.TheThanhVien;
import com.example.demo.service.TheThanhVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequestMapping("/the-thanh-vien")
@RestController
public class TheThanhVienController {

    @Autowired
    TheThanhVienService service;

    List<TheThanhVienDTO> serializeList(List<TheThanhVien> lst){
        List items = new ArrayList();
        for(TheThanhVien ttv : lst) items.add(new TheThanhVienDTO(ttv));
        return items;
    }

    @GetMapping("/get-all")
    public List<TheThanhVienDTO> getAll(){
        return serializeList(service.findAll());
    }

    @GetMapping("/get-page")
    public List<TheThanhVienDTO> getPage(@RequestParam(defaultValue = "0") int p) {
        Pageable pageable = PageRequest.of(p, 5);
        Page<TheThanhVien> page = service.findAll(pageable);
        return serializeList(page.toList());
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody TheThanhVien ttv) {
        String error = "";
        // TODO : Validate data --> error
        if(!error.isEmpty()){
            return ResponseEntity.badRequest().body(error);
        }

        service.save(ttv);
        return ResponseEntity.ok(new TheThanhVienDTO(ttv));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody TheThanhVien ttv) {
        String error = "";
        // TODO : Validate data --> error
        if(!error.isEmpty()){
            return ResponseEntity.badRequest().body(error);
        }
        ttv.setMathe(id);
        service.save(ttv);
        return ResponseEntity.ok(new TheThanhVienDTO(ttv));
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id) {
        service.deleteById(id);
    }
}
