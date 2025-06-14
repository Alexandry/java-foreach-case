package com.example.demo.repository;

import com.example.demo.domain.LotePagamento;
import com.example.demo.domain.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LotePagamentoRepository extends JpaRepository<Pagamento, Long> {
}
