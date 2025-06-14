package com.example.demo.service;

import com.example.demo.domain.LotePagamento;
import com.example.demo.domain.Pagamento;
import com.example.demo.repository.LotePagamentoRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class LotePagamentoService {

    private LotePagamentoRepository repository;

    @Transactional
    @Modifying
    public LotePagamento efetivarLancamentos(LotePagamento lotePagamentos) {

        long inicio = System.nanoTime();

        lotePagamentos.getPagamentos()
                .parallelStream()
                .forEach(lotePagamento -> {
                    try {
                        repository.save(lotePagamento);

                    } catch (Exception e) {
                        log.error("Erro ao processar pagamento: " + lotePagamento);
                    }

                });

        long fim = System.nanoTime();
        double duracaoSegundos = (fim - inicio) / 1_000_000_000.0;

        log.info("Tempo de processamento foreach: " + duracaoSegundos + " seg");
        return lotePagamentos;
    }

    @Transactional
    @Modifying
    public LotePagamento efetivarLancamentosStreamSequential(LotePagamento lotePagamentos) {


        long inicio = System.nanoTime();

        lotePagamentos.getPagamentos()
                .stream()
                .map(repository::save)
                .toList();

        long fim = System.nanoTime();
        double duracaoSegundos = (fim - inicio) / 1_000_000_000.0;

        log.info("Tempo de processamento stream sequencial: " + duracaoSegundos + " seg");

        return lotePagamentos;
    }

    public LotePagamento efetivarPagamentoParallMap(LotePagamento lotePagamento) {

        long inicio = System.nanoTime();

        List<Pagamento> salvos = lotePagamento.getPagamentos()
                .parallelStream()
                .map(this::saveComTransaction)
                .toList();

        long fim = System.nanoTime();
        double duracaoSegundos = (fim - inicio) / 1_000_000_000.0;

        log.info("Tempo de processamento parallel map: " + duracaoSegundos + " seg");
        lotePagamento.setPagamentos(salvos);

        return lotePagamento;
    }

    @Transactional
    public Pagamento saveComTransaction(Pagamento p) {
        return repository.save(p);
    }

}
