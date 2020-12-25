package com.example.demo.service.vatTuService;

import com.example.demo.model.NhaCungCap;
import com.example.demo.model.Nuoc;
import com.example.demo.model.VatTu;

import java.util.List;
import java.util.Optional;

public interface VatTuService {
    List<VatTu> getAll();
    Optional<VatTu> getById(Integer id);
    VatTu save(VatTu vatTu);
    void deleteById(Integer id);

    Optional<VatTu> findByMaVatTu(String maVatTu);
    void deleteByMaVatTu(String maVatTu);

    List<VatTu> findAllByTenVatTuIsContaining(String tenVatTu);
}
