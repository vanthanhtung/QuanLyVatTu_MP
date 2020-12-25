package com.example.demo.repository;

import com.example.demo.model.Nuoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NuocRepository extends JpaRepository<Nuoc,Integer> {
}
