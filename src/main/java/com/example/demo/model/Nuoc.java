package com.example.demo.model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Nuoc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maNuoc;

    @NotNull
    private String tenNuoc;
}
