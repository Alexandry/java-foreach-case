---
description: Legacy Mapping Kit - regras para mapear componentes legados (Java/Spring/JPA/JDBC/SQL/DDL) com evidências e documentação.
globs:
  - "**/*"
---

# Legacy Mapping Kit — Regras

## Não negociáveis
- Não inventar regra, campo, transformação, integração ou tabela sem evidência.
- Toda regra/transformação deve conter:
  - Evidence: caminho do arquivo + identificador (classe/método/query) + trecho.
- Se faltar informação, registrar em /docs/components/<id>/08-open-questions.md.

## Segurança e dados
- Em samples, mascarar dados sensíveis.
- Evitar colar credenciais/hostnames. Foque em nomes lógicos (db/schema/tabela).

## Onde escrever
- Componentes: /docs/components/<component_id>/*
- Processo: /docs/processes/<process_id>/*
- SQL snippets: /samples/sql-snippets/
- DDL: /schemas/db/ddl/
- Procs: /schemas/db/procs/

## Saída padrão quando eu pedir "mapear componente"
Atualizar sempre:
- 01-interfaces.md (inputs/outputs observáveis)
- 02-data-access.md (db/schema/tabelas/queries)
- 03-rules-transform.md (regras, de-para, transforms)
- 04-lineage.md (lê/escreve + side effects)
- 05-integrations.md (REST, fila, arquivos)
- 06-procedures.md (mesmo que TODO)
- 08-open-questions.md (gaps)
