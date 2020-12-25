package com.example.demo.repository;

import com.example.demo.model.VatTu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VatTuRepository extends JpaRepository<VatTu,Integer> {
    Optional<VatTu> findByMaVatTu(String maVatTu);
    void deleteByMaVatTu(String maVatTu);
    List<VatTu> findAllByTenVatTuIsContaining(String tenVatTu);
}
