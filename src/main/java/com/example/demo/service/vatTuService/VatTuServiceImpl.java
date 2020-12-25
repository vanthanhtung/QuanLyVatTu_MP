package com.example.demo.service.vatTuService;

import com.example.demo.model.VatTu;
import com.example.demo.repository.VatTuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VatTuServiceImpl implements VatTuService{

    @Autowired
    private VatTuRepository vatTuRepository;

    @Override
    public List<VatTu> getAll() {
        return vatTuRepository.findAll();
    }

    @Override
    public Optional<VatTu> getById(Integer id) {
        return vatTuRepository.findById(id);
    }

    @Override
    public VatTu save(VatTu vatTu) {
        return vatTuRepository.save(vatTu);
    }

    @Override
    public void deleteById(Integer id) {
        vatTuRepository.deleteById(id);
    }

    @Override
    public Optional<VatTu> findByMaVatTu(String maVatTu) {
        return vatTuRepository.findByMaVatTu(maVatTu);
    }

    @Override
    public void deleteByMaVatTu(String maVatTu) {
        vatTuRepository.deleteByMaVatTu(maVatTu);
    }

    @Override
    public List<VatTu> findAllByTenVatTuIsContaining(String tenVatTu) {
        return vatTuRepository.findAllByTenVatTuIsContaining(tenVatTu);
    }
}
