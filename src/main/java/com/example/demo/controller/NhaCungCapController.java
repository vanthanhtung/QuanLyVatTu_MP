package com.example.demo.controller;

import com.example.demo.model.NhaCungCap;
import com.example.demo.model.VatTu;
import com.example.demo.service.nhaCungCapService.NhaCungCapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/nhacungcap")
public class NhaCungCapController {

    @Autowired
    NhaCungCapService nhaCungCapService;

    @GetMapping()
    public ResponseEntity<List<NhaCungCap>> findAll(){
        List<NhaCungCap> nhaCungCapList = nhaCungCapService.getAll();
        return new ResponseEntity<>(nhaCungCapList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<NhaCungCap>> findById(@PathVariable Integer id){
        Optional<NhaCungCap> nhaCungCap = nhaCungCapService.getById(id);
        if (!nhaCungCap.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(nhaCungCap,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<NhaCungCap> save(@RequestBody NhaCungCap nhaCungCap){
        nhaCungCapService.save(nhaCungCap);
        return new ResponseEntity<>(nhaCungCap,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<NhaCungCap> deleteById(@PathVariable Integer id){
        nhaCungCapService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NhaCungCap> edit(@PathVariable Integer id, @RequestBody NhaCungCap nhaCungCap){
        NhaCungCap currentNhaCC = nhaCungCapService.getById(id).get();
        if (currentNhaCC == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        currentNhaCC.setTenNCC(nhaCungCap.getTenNCC());
        nhaCungCapService.save(currentNhaCC);
        return new ResponseEntity<>(currentNhaCC,HttpStatus.OK);
    }
}
