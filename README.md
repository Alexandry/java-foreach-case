# batch_roadmap_xml_consolidation — Preencher process.md com processo, escopo e checklist (Spring Batch XML Consolidation)

Você é um Arquiteto/Tech Lead especialista em Spring Batch. Sua missão é gerar um roadmap **executável** (processo + escopo + checklist) para um projeto de **consolidação de arquivos XML** (estilo CADOC 3040), usando APENAS evidências do repositório e do **Cursor Browser** (se fornecido). Não invente layouts nem campos.

## Input do usuário
- process_id: string (default: "xml-consolidation-cadoc-3040")
- output_file: string (default: "docs/processes/<process_id>/process.md")
- xml_flavor: string (default: "cadoc-3040-like")
- target_output: string (default: "xml-consolidado")  # xml|json|db|file
- runtime: string (default: "spring-batch")
- notes: string (opcional)  # qualquer detalhe extra do usuário

## Fontes padrão para leitura (use se existirem)
### Repositório (arquivos)
- /docs/discovery/00-inbox/
- /docs/discovery/01-notes/
- /docs/discovery/02-decisions/
- /docs/discovery/03-open-questions/
- /schemas/files/  (layouts, XSD, exemplos)
- /schemas/db/ddl/ (DDL se houver)
- /schemas/db/procs/ (procedures se houver)
- /samples/files/  (xmls anonimizados, exemplos bons/ruins)
- /samples/sql-snippets/ (se houver queries)

### Cursor Browser (normativos/links externos)
- Usar conteúdo do **Browser do Cursor** SOMENTE se:
  1) a página estiver aberta no Browser, e
  2) o conteúdo estiver disponível para o Agent no contexto.
- Ao usar o Browser como fonte, sempre registrar em "Fontes usadas" no process.md:
  - título da página
  - URL (se visível)
  - seção/trecho usado (ex.: heading, item, tópico)
  - data/hora local aproximada de consulta (ex.: "consultado hoje no Cursor Browser")
- NÃO inventar requisitos do normativo. Se o texto não estiver legível no contexto, registrar como Open Question.

## Regras
- Não inventar tags XML, campos, enums ou regras. Se faltarem fontes (XSD/layout/normativo), registrar como Open Questions.
- Sempre considerar: restartability, idempotência, rastreabilidade e performance (streaming).
- O plano deve ser “implementável”: tarefas claras, ordenadas e agrupadas por PR/etapa.
- Sempre sugerir validação de XML (XSD quando existir) e política de erro (skip/retry/quarentena).
- Se houver risco de volume alto, propor partitioning/multi-resource e streaming (StAX).
- Se houver necessidade de output em arquivo, considerar escrita incremental e naming determinístico.

## Tarefa
1) Garantir que existe a pasta: /docs/processes/<process_id>/
2) Criar/atualizar o arquivo de saída (output_file) preenchendo as seções:
   - Visão geral (objetivo e resultado)
   - Entradas e saídas (contrato do processo)
   - Fluxo ponta-a-ponta (passo a passo)
   - Scope (IN / OUT, premissas, não-funcionais)
   - Arquitetura proposta (componentes Spring Batch + módulos)
   - Checklist de implementação (components) em formato de checklist Markdown
   - Estratégia de testes (unit/integração/golden files/performance)
   - Observabilidade e operação (logs/métricas/auditoria/reprocessamento)
   - Open Questions e riscos

3) O checklist deve ser **completo** e cobrir:
   - setup do projeto e infraestrutura mínima
   - reader(s) multi-resource + discovery de arquivos
   - parser XML (StAX/JAXB) + validação
   - regras de consolidação (merge/grouping/dedup)
   - writer (arquivo consolidado) + atomicidade
   - controle de erro (skip/retry/quarentena/DLQ se aplicável)
   - restartability e idempotência (JobParameters, state, checkpoint)
   - testes e datasets
   - pipeline/execução (CLI/Cloud/cron)
   - documentação e decisões (ADR)

4) Se existir normativo no Cursor Browser:
   - extrair requisitos operacionais (prazos, validações, formato, obrigatoriedades)
   - refletir esses requisitos em: Scope(IN/OUT), validações, checklist e Open Questions.

## Formato do output_file (process.md)
Use exatamente este template (preenchendo com o que for possível e deixando TODOs quando faltar evidência):

---
# <process_id> — Roadmap de Desenvolvimento (Spring Batch: XML Consolidation)

## 1) Objetivo
Descrever e implementar um Spring Batch que consolida múltiplos arquivos XML (<xml_flavor>) em um output (<target_output>), com rastreabilidade, restartability e tratamento de erros.

## 2) Fontes usadas (evidências)
- Repositório:
  - TODO: listar arquivos reais lidos (paths do repo)
- Cursor Browser:
  - TODO: (se usado) Título | URL | Seção | "consultado via Cursor Browser"

## 3) Entradas e Saídas (contrato do processo)
### Entradas
- Origem dos XMLs: TODO (pasta/bucket/sftp)
- Padrão de nome / lote: TODO
- Layout/XSD: TODO (link em /schemas/files/ ou /samples/files/)
- Requisitos do normativo (se aplicável): TODO (referenciar fonte)
- Volume esperado: TODO

### Saídas
- Tipo de output: <target_output>
- Local de saída: TODO
- Naming convention: TODO
- Relatório de processamento (sucessos/erros): TODO

## 4) Fluxo ponta-a-ponta (como funciona)
1. Descobrir arquivos de entrada do lote (por data/lote/prefixo)
2. Validar pré-condições (ex.: presença, duplicidade, janela)
3. Ler XMLs em streaming (evitar carregar tudo em memória)
4. Validar XML (XSD se existir) e validar regras mínimas (incl. normativo se houver)
5. Transformar para modelo canônico interno
6. Consolidar (merge/group/dedup) conforme regras
7. Gerar output consolidado + relatório
8. Persistir metadados do job (execução, contadores, erros)
9. Permitir reprocessamento seguro (idempotência) e restart

## 5) Scope (escopo de desenvolvimento)
### IN (vamos entregar)
- Spring Batch Job completo (Job + Steps) para consolidação XML
- Reader multi-resource (varredura por lote)
- Parser XML (StAX ou JAXB) + validação
- Regras de consolidação documentadas e implementadas (com evidência)
- Writer do output consolidado (arquivo) + relatório
- Política de erro (skip/retry/quarentena) e logs/auditoria
- Testes (unit + integração + golden files) e dataset exemplo anonimizado
- Documentação técnica e ADRs principais

### OUT (fora do escopo agora)
- TODO

### Premissas e dependências
- TODO (ex.: XSD disponível? padrão do nome do arquivo? volume? exigências do normativo?)

### Não-funcionais (NFRs)
- Performance: streaming + particionamento se necessário
- Confiabilidade: restartability, idempotência, reprocessamento
- Observabilidade: logs estruturados + métricas + correlação por lote
- Segurança: dados sensíveis mascarados em samples e logs (quando aplicável)

## 6) Arquitetura proposta (Spring Batch)
### Job: <jobName TODO>
- Step 1: Discovery/Indexação de arquivos (Tasklet ou Step leve)
- Step 2: Processamento/Consolidação (Chunk-oriented, MultiResourceItemReader)
- Step 3: Geração de output + relatório (Writer + pós-processo)
- Opcional: Partitioning por arquivo/lote (se volume alto)

### Componentes principais
- Reader: MultiResourceItemReader + StAX (preferencial) / JAXB
- Processor: normalização + regras + consolidação parcial
- Writer: output consolidado (streaming) + relatório
- Error handling: SkipPolicy/RetryPolicy + quarantine folder
- Metadata: JobRepository + Execução e contadores

## 7) Components — Checklist de implementação (tarefas)
### 7.1 Fundação do projeto
- [ ] Criar módulo Spring Boot (ou app batch) + dependências Spring Batch
- [ ] Definir `application.yml` com input/output e parâmetros de job
- [ ] Definir empacotamento e entrypoint (JobLauncher)
- [ ] Definir convenções de logging (correlationId por lote)

### 7.2 Contratos e layouts
- [ ] Colocar XSD/layouts em `/schemas/files/` (se existirem)
- [ ] Colocar samples anonimizados em `/samples/files/`
- [ ] Documentar tags/campos mínimos esperados (seção 3)
- [ ] Extrair exigências do normativo (Cursor Browser) e refletir aqui (se aplicável)

### 7.3 Leitura (inputs)
- [ ] Implementar discovery de arquivos (por lote/data/prefixo)
- [ ] Implementar MultiResourceItemReader
- [ ] Implementar parser XML streaming (StAX) para evitar memória
- [ ] Definir estratégia para arquivos inválidos (quarentena)

### 7.4 Validação
- [ ] Validação XSD (se existir) e validações mínimas (campos obrigatórios)
- [ ] Política de skip/retry (o que é recuperável vs fatal)
- [ ] Padronizar erro (código, mensagem, arquivo, linha/elemento)
- [ ] Validar exigências do normativo (se aplicável)

### 7.5 Transformação e modelo canônico
- [ ] Definir modelo canônico interno (POJOs) para consolidação
- [ ] Mapear campos XML -> canônico (com evidência)
- [ ] Implementar normalizações (datas, números, enums/de-para)

### 7.6 Consolidação (regras de negócio)
- [ ] Definir chave de consolidação (grouping) — TODO evidência
- [ ] Definir deduplicação e precedência — TODO
- [ ] Implementar consolidação incremental (evitar manter tudo em memória)
- [ ] Contabilizar métricas (itens processados, rejeitados, consolidados)

### 7.7 Escrita (outputs)
- [ ] Definir formato do output consolidado (<target_output>)
- [ ] Implementar writer streaming do output (arquivo)
- [ ] Implementar geração do relatório (sucesso/erro por arquivo)
- [ ] Naming determinístico e atomicidade (temp + rename)

### 7.8 Restartability e Idempotência
- [ ] Definir JobParameters (lote/data/prefixo) e estratégia idempotente
- [ ] Garantir restart seguro (checkpoint) e não duplicar output
- [ ] Registrar “arquivo já processado” (se necessário)

### 7.9 Observabilidade e Operação
- [ ] Logs estruturados por lote/arquivo
- [ ] Métricas (timing, contadores, erros por tipo)
- [ ] Estratégia de reprocessamento (quarentena -> reentrada)
- [ ] Documentar runbook (como executar, reexecutar, limpar)

### 7.10 Testes
- [ ] Unit tests dos parsers e regras (golden inputs/outputs)
- [ ] Integration test do Job (com amostras pequenas)
- [ ] Testes de erro (xml inválido, faltando tags, etc.)
- [ ] Teste de performance básico (lote grande sintético)

### 7.11 Documentação e decisões
- [ ] Escrever ADRs: StAX vs JAXB; partitioning; idempotência; política de erro
- [ ] Atualizar docs do processo com decisões e evidências

## 8) Riscos e Open Questions
### Riscos
- TODO

### Open Questions (o que falta para fechar)
- Q1: TODO
- Q2: TODO

---
