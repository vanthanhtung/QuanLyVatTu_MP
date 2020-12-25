package com.example.demo.service.nhaCungCapService;

import com.example.demo.model.NhaCungCap;
import com.example.demo.repository.NhaCungCapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NhaCungCapServiceImpl implements NhaCungCapService{

    @Autowired
    private NhaCungCapRepository nhaCungCapRepository;

    @Override
    public List<NhaCungCap> getAll() {
        return nhaCungCapRepository.findAll();
    }

    @Override
    public Optional<NhaCungCap> getById(Integer maNCC) {
        return nhaCungCapRepository.findById(maNCC);
    }

    @Override
    public NhaCungCap save(NhaCungCap nhaCungCap) {
        return nhaCungCapRepository.save(nhaCungCap);
    }

    @Override
    public void deleteById(Integer maNCC) {
        nhaCungCapRepository.deleteById(maNCC);
    }
}
