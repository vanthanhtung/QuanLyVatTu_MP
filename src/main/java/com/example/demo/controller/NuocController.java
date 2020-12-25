package com.example.demo.controller;

import com.example.demo.model.NhaCungCap;
import com.example.demo.model.Nuoc;
import com.example.demo.service.nuocService.NuocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/nuoc")
public class NuocController {

    @Autowired
    NuocService nuocService;

    @GetMapping()
    public ResponseEntity<List<Nuoc>> findAll(){
        List<Nuoc> nuocList = nuocService.getAll();
        return new ResponseEntity<>(nuocList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Nuoc>> findById(@PathVariable Integer id){
        Optional<Nuoc> nuoc = nuocService.getById(id);
        if (!nuoc.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(nuoc,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Nuoc> save(@RequestBody Nuoc nuoc){
        nuocService.save(nuoc);
        return new ResponseEntity<>(nuoc,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Nuoc> deleteById(@PathVariable Integer id){
        nuocService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Nuoc> edit(@PathVariable Integer id, @RequestBody Nuoc nuoc){
        Nuoc currentNuoc = nuocService.getById(id).get();
        if (currentNuoc == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        currentNuoc.setTenNuoc(nuoc.getTenNuoc());
        nuocService.save(currentNuoc);
        return new ResponseEntity<>(currentNuoc,HttpStatus.OK);
    }
}
