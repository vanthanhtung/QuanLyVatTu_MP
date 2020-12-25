package com.example.demo.model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class VatTu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String maVatTu;

    private String maKKS;

    @NotNull
    private String tenVatTu;

    @NotNull
    private String dvTinh;

    @ManyToOne
    @JoinColumn(name = "maNuoc")
    private Nuoc nuoc;

    @ManyToOne
    @JoinColumn(name = "maNCC")
    private NhaCungCap nhaCungCap;
}
