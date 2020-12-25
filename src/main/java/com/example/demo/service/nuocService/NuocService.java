package com.example.demo.service.nuocService;

import com.example.demo.model.NhaCungCap;
import com.example.demo.model.Nuoc;

import java.util.List;
import java.util.Optional;

public interface NuocService {
    List<Nuoc> getAll();
    Optional<Nuoc> getById(Integer maNuoc);
    Nuoc save(Nuoc nuoc);
    void deleteById(Integer maNuoc);
}
