package com.example.demo.controller;

import com.example.demo.model.VatTu;
import com.example.demo.service.nhaCungCapService.NhaCungCapService;
import com.example.demo.service.nuocService.NuocService;
import com.example.demo.service.vatTuService.VatTuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/vattu")
public class VatTuController {

    @Autowired
    VatTuService vatTuService;

    @Autowired
    NuocService nuocService;

    @Autowired
    NhaCungCapService nhaCungCapService;

    @GetMapping()
    public ResponseEntity<List<VatTu>> findAll(){
        List<VatTu> vatTuList = vatTuService.getAll();
        return new ResponseEntity<>(vatTuList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<VatTu>> findById(@PathVariable Integer id){
        Optional<VatTu> vatTu = vatTuService.getById(id);
        if (!vatTu.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(vatTu,HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<VatTu> save(@RequestBody VatTu vatTu){
        List<VatTu> vatTuList = vatTuService.getAll();
        for (VatTu x : vatTuList){
            if (x.getTenVatTu().equals(vatTu.getTenVatTu())){
                return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
            }
        }
        vatTuService.save(vatTu);
        return new ResponseEntity<>(vatTu,HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<VatTu> deleteById(@PathVariable Integer id){
        vatTuService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VatTu> edit(@PathVariable Integer id, @RequestBody VatTu vatTu){
        VatTu currentVatTu = vatTuService.getById(id).get();
        if (currentVatTu == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        currentVatTu.setTenVatTu(vatTu.getTenVatTu());
        currentVatTu.setNuoc(vatTu.getNuoc());
        currentVatTu.setNhaCungCap(vatTu.getNhaCungCap());
        currentVatTu.setMaVatTu(vatTu.getMaVatTu());
        currentVatTu.setMaKKS(vatTu.getMaKKS());
        currentVatTu.setDvTinh(vatTu.getDvTinh());
        vatTuService.save(currentVatTu);
        return new ResponseEntity<>(currentVatTu,HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<VatTu>> search(@RequestParam String tenVatTu){
        List<VatTu> searchResult = vatTuService.findAllByTenVatTuIsContaining(tenVatTu);
        if (searchResult.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(searchResult,HttpStatus.OK);
    }
}
