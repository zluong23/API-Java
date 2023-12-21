package com.example.demo.controller;

import com.example.demo.dto.KhachHangDTO;
import com.example.demo.entity.KhachHang;
import com.example.demo.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/khach-hang")
public class KhachHangController {
    @Autowired
    KhachHangService service;

    List<KhachHangDTO> serializeList(List<KhachHang> lst){
        List items = new ArrayList();
        for(KhachHang khachHang : lst) items.add(new KhachHangDTO(khachHang));
        return items;
    }

    @GetMapping("/get-all")
    public List<?> getAll(){
        return serializeList(service.findAll());
    }

    @GetMapping("/get-page")
    public List<KhachHangDTO> getPage(@RequestParam(defaultValue="0") int p){
        Pageable pageable = PageRequest.of(p, 5);
        return serializeList(service.findAll(pageable).toList());
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody KhachHang khachHang) {

        String error = "";

        if(ObjectUtils.isEmpty(khachHang.getTenkhachhang())){
            error = "Tên khách hàng là bắt buộc";
        }else if(ObjectUtils.isEmpty(khachHang.getSodienthoai())){
            error = "SĐT hàng là bắt buộc";
        }else if(khachHang.getHangkhachhang() == null ||
                ObjectUtils.isEmpty(khachHang.getHangkhachhang().getMahang())){
            error = "Mã hạng là bắt buộc";
        }

        if(!error.isEmpty()){
            return ResponseEntity.badRequest().body(error);
        }

        service.save(khachHang);
        return ResponseEntity.ok(new KhachHangDTO(khachHang));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable long id, @RequestBody KhachHang khachHang) {
        String error = "";

        if(ObjectUtils.isEmpty(khachHang.getTenkhachhang())){
            error = "Tên khách hàng là bắt buộc";
        }else if(ObjectUtils.isEmpty(khachHang.getSodienthoai())){
            error = "SĐT hàng là bắt buộc";
        }else if(khachHang.getHangkhachhang() == null ||
                ObjectUtils.isEmpty(khachHang.getHangkhachhang().getMahang())){
            error = "Mã hạng là bắt buộc";
        }

        if(!error.isEmpty()){
            return ResponseEntity.badRequest().body(error);
        }
        khachHang.setMakhachhang(id);
        service.save(khachHang);
        return ResponseEntity.ok(new KhachHangDTO(khachHang));
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id) {
        service.deleteById(id);
    }
}
