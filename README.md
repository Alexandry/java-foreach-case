---
name: legacy-mapping-kit
description: Mapeia processos e componentes legados (Java/Spring/JPA/JDBC/SQL/DDL) extraindo regras, transformações, acesso a dados, lineage, integrações e documentação. Sempre com evidências. Mantém espaço para procedures.
---

# Legacy Mapping Kit

## Use cases
- Mapear rotina legado ponta-a-ponta (processo)
- Mapear componente legado (service/job/procedure/ETL)
- Extrair regras e transformações do código/SQL
- Catalogar DDL e relacionar com componentes

## Inputs esperados
- Código Java (Spring/JPA/JDBC), configs, arquivos .sql
- DDL (create table/view) em /schemas/db/ddl
- Notas/transcrições em /docs/discovery/00-inbox

## Outputs
- /docs/processes/<process_id>/*
- /docs/components/<component_id>/*
- Atualização em /docs/catalogs/*

## Procedure (alto nível)
1) Criar scaffold (processo e/ou componente)
2) Extrair “interfaces observáveis” (inputs/outputs)
3) Extrair acesso a dados (queries/tabelas/DDL)
4) Extrair regras/transformações (com evidência)
5) Construir lineage e integrações
6) Registrar gaps (Open Questions) e riscos
