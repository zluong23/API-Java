package com.example.demo.controller;

import com.example.demo.dto.DiachiDTO;
import com.example.demo.entity.DiaChi;
import com.example.demo.service.DiaChiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequestMapping("/dia-chi")
@RestController
public class DiaChiController {
    @Autowired
    DiaChiService service;

    List<DiachiDTO> serializeList(List<DiaChi> lst){
        List items = new ArrayList();
        for(DiaChi dc : lst) items.add(new DiachiDTO(dc));
        return items;
    }

    @GetMapping("/get-all")
    public List<?> getAll(){

        return serializeList(service.findAll());
    }

    @GetMapping("/get-page")
    public List<?> getPage(@RequestParam(defaultValue = "0") int p) {
        Pageable pageable = PageRequest.of(p, 5);
        Page<DiaChi> page = service.findAll(pageable);
        return serializeList(page.toList());
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DiaChi dc) {
        String error = "";
        // TODO : Validate data --> error
        if(!error.isEmpty()){
            return ResponseEntity.badRequest().body(error);
        }

        service.save(dc);
        return ResponseEntity.ok(new DiachiDTO(dc));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable UUID id, @RequestBody DiaChi dc) {
        String error = "";
        // TODO : Validate data --> error
        if(!error.isEmpty()){
            return ResponseEntity.badRequest().body(error);
        }
        dc.setMadiachi(id);
        service.save(dc);
        return ResponseEntity.ok(new DiachiDTO(dc));
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable UUID id) {
        service.deleteById(id);
    }
}
