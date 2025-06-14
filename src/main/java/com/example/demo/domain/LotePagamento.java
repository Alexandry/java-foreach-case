package com.example.demo.domain;


import com.example.demo.domain.enumerated.StatusLote;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "lote_pagamento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LotePagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigoReferencia;

    @Enumerated(EnumType.STRING)
    private StatusLote status;

    private LocalDateTime criadoEm;

    private LocalDateTime aprovadoEm;

    @OneToMany(mappedBy = "lote", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pagamento> pagamentos;

}
