package com.example.demo.service.nhaCungCapService;

import com.example.demo.model.NhaCungCap;

import java.util.List;
import java.util.Optional;

public interface NhaCungCapService {
    List<NhaCungCap> getAll();
    Optional<NhaCungCap> getById(Integer maNCC);
    NhaCungCap save(NhaCungCap nhaCungCap);
    void deleteById(Integer maNCC);
}
