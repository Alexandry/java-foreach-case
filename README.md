CA-02 — Aderência ao cenário do CADOC 3040

A solução deverá demonstrar suporte ao processamento do 3040 no escopo da POC, considerando o leiaute e as instruções de preenchimento aplicáveis ao documento. O 3040 é um documento mensal, em XML, com estrutura de cabeçalho, informações individualizadas por cliente/operação e informações agregadas, além de remessa e particionamento quando aplicável.

Aceite: aprovado se o parceiro demonstrar entendimento e processamento aderente ao documento 3040 utilizado como referência na POC.

CA-03 — Validações mínimas do 3040

A solução deverá emitir, no mínimo, críticas relacionadas a:

leiaute;
campos obrigatórios;
consistência estrutural do XML;
obrigatoriedade mínima dos blocos/campos necessários ao cenário testado;
coerência mínima dos dados processados.

O Bacen mantém materiais específicos de críticas, campos obrigatórios e regras de validação para o 3040.

Aceite: aprovado se a solução identificar erros intencionais inseridos na massa de teste e apresentar a crítica correspondente de forma compreensível.

CA-04 — Identificação de erros de conciliação

A solução deverá indicar inconsistências de conciliação encontradas no processamento, com prioridade para as divergências relacionadas ao 4010.

O próprio fluxo operacional histórico do 3040 no Bacen contempla comparação com o 4010/COSIF e exibição de “indícios” quando há divergências acima de determinados percentuais.

Aceite: aprovado se a solução detectar e demonstrar, no mínimo, as divergências previamente injetadas no cenário de teste relacionadas ao batimento com o 4010.

CA-05 — Explicação do erro encontrado

A solução não poderá se limitar a um status genérico de falha. Ela deverá permitir identificar:

qual regra falhou;
qual registro ou conjunto de registros foi impactado;
qual campo ou agrupamento está inconsistente;
qual a natureza do erro.

Aceite: aprovado se a evidência apresentada permitir que a equipe interna entenda o erro e inicie tratativa sem engenharia reversa manual pesada.

CA-06 — Rastreabilidade da execução

A solução deverá permitir rastrear:

qual arquivo ou lote foi processado;
quando foi processado;
qual versão/execução foi considerada;
quais erros foram encontrados;
qual foi o resultado final da execução.

Aceite: aprovado se o parceiro demonstrar trilha suficiente para suportar análise operacional da POC.

6.2 Critérios não funcionais obrigatórios
CA-07 — Desempenho mínimo

A solução deverá demonstrar tempo de execução compatível com o cenário da POC.

Aceite: o critério deverá ser medido em ambiente de POC com massa previamente definida.
Sugestão de redação:

processar a massa de teste acordada dentro do tempo máximo de X minutos;
disponibilizar resultado consolidado em até Y minutos após a carga.

Observação: aqui vocês ainda precisam calibrar X e Y com base no volume real da POC. Não inventem número agora.

CA-08 — Estabilidade da execução

A solução deverá conseguir repetir a execução do mesmo cenário sem comportamento inconsistente.

Aceite: aprovado se duas execuções com o mesmo insumo produzirem o mesmo resultado funcional, salvo diferenças de identificadores técnicos da própria execução.

CA-09 — Segurança mínima no tratamento dos arquivos da POC

A solução deverá demonstrar:

controle de acesso ao ambiente da POC;
proteção dos insumos fornecidos;
segregação mínima entre processamento e visualização;
descarte ou retenção conforme combinado.

Aceite: aprovado se o parceiro apresentar evidência objetiva do modelo de proteção adotado na POC.

CA-10 — Operabilidade mínima

A solução deverá permitir que a equipe avalie, sem dependência integral do fornecedor, pelo menos:

status da execução;
erros identificados;
resumo dos resultados;
evidências de processamento.

Aceite: aprovado se houver visão, relatório ou interface minimamente utilizável para acompanhamento da execução.

6.3 Critérios específicos de negócio/regulatório
CA-11 — Suporte a cenário válido e inválido

A POC deverá contemplar pelo menos:

1 cenário válido;
1 cenário com crítica mínima de preenchimento/estrutura;
1 cenário com divergência de conciliação com 4010.

Aceite: aprovado se a solução diferenciar claramente os três cenários e produzir o comportamento esperado para cada um.

CA-12 — Suporte a reenvio/reprocessamento do cenário

O documento 3040 trabalha com conceito de remessa, e qualquer reenvio para a mesma data-base representa nova remessa; quando há particionamento, as partes devem ser sequenciais e sem lacunas.

Aceite: aprovado se o parceiro demonstrar como a solução trata reexecução/reprocessamento do cenário da POC, mesmo que em escopo simplificado.

CA-13 — Capacidade de processamento de XML

Como parte relevante da POC virá em XML, a solução deverá demonstrar capacidade de:

ler corretamente os XMLs fornecidos;
validar estrutura mínima;
apontar falhas de formação quando existirem.

O Bacen mantém validador XML específico e documentação técnica associada a esse processo.

Aceite: aprovado se a solução processar os XMLs válidos e rejeitar/controlar adequadamente XMLs inválidos do cenário.

7. Itens fora do escopo da POC

Ficam fora do escopo, salvo ajuste posterior:

emissão automática de eventos da plataforma externa para a plataforma interna;
integração com todos os legados do banco;
implantação produtiva;
cobertura integral de todos os regulatórios;
automação completa de reconciliação e saneamento de origens;
modelo operacional definitivo.
8. Evidências mínimas que o parceiro deve apresentar

Cada parceiro deverá apresentar ao final da POC:

evidência de ingestão dos insumos fornecidos;
evidência de processamento do cenário do 3040;
lista das críticas identificadas;
evidência das inconsistências de conciliação detectadas, especialmente com foco em 4010;
tempos de processamento observados;
visão ou relatório de rastreabilidade da execução;
limitações identificadas no escopo testado;
premissas técnicas para evolução da POC para uma fase seguinte.
9. Critério de aprovação da POC

A POC será considerada aprovada para um parceiro que:

atender aos critérios funcionais obrigatórios;
demonstrar identificação das críticas mínimas do 3040;
demonstrar identificação das inconsistências de conciliação esperadas no cenário, com foco em 4010;
apresentar rastreabilidade mínima da execução;
atender ao desempenho acordado para a massa de teste da POC;
não exigir customização desproporcional para executar o cenário proposto.
