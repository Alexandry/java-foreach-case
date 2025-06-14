package com.example.demo.rest;


import com.example.demo.domain.LotePagamento;
import com.example.demo.service.LotePagamentoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pagamento")
@AllArgsConstructor
public class LotePagamentoController {

    private LotePagamentoService service;

    @PostMapping("/realizar-lancamentos-foreach")
    public ResponseEntity<LotePagamento> efetivarLancamentosPagamentos(@RequestBody LotePagamento lotePagamentos){

        return ResponseEntity.ok(service.efetivarLancamentos(lotePagamentos));
    }

    @PostMapping("/realizar-lancamentos-safe-stream")
    public ResponseEntity<LotePagamento> efetivarLancamentosPagamentosStream(@RequestBody LotePagamento lotePagamentos){
        return ResponseEntity.ok(service.efetivarLancamentosStreamSequential(lotePagamentos));
    }

    @PostMapping("/realizar-lancamentos-task-executor")
    public ResponseEntity<LotePagamento> efetivarLancamentosPagamentosTaskExecutor(@RequestBody LotePagamento lotePagamentos){
        return ResponseEntity.ok(service.efetivarPagamentoParallMap(lotePagamentos));
    }


}
