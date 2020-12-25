package com.example.demo.service.nuocService;

import com.example.demo.model.NhaCungCap;
import com.example.demo.model.Nuoc;
import com.example.demo.repository.NuocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NuocServiceImpl implements NuocService{

    @Autowired
    private NuocRepository nuocRepository;

    @Override
    public List<Nuoc> getAll() {
        return nuocRepository.findAll();
    }

    @Override
    public Optional<Nuoc> getById(Integer maNuoc) {
        return nuocRepository.findById(maNuoc);
    }

    @Override
    public Nuoc save(Nuoc nuoc) {
        return nuocRepository.save(nuoc);
    }

    @Override
    public void deleteById(Integer maNuoc) {
        nuocRepository.deleteById(maNuoc);
    }
}
