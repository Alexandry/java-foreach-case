# comp_profile — mapear componente (Java/Spring/JPA/JDBC/SQL/DDL)

Input:
- component_id (default: svc-core-extrato)

Fontes:
- /docs/components/<component_id>/*
- código aberto no editor (classes, repos, configs)
- /samples/sql-snippets/
- /schemas/db/ddl/
- /schemas/db/procs/

Regras:
- Não inventar.
- Cada item relevante deve ter "Evidence:".

Tarefa:
1) Atualizar 01-interfaces.md:
   - identificar inputs (DTOs, params, mensagens, arquivos)
   - identificar outputs (DTOs, writes, arquivos)
2) Atualizar 02-data-access.md:
   - encontrar @Query, JdbcTemplate, NamedParameterJdbcTemplate, EntityManager, arquivos .sql
   - listar DB/schema/tabelas tocadas
   - linkar DDL se existir em /schemas/db/ddl
3) Atualizar 03-rules-transform.md:
   - mapear validações, filtros, defaults, de-para, conversões
4) Atualizar 04-lineage.md:
   - construir cadeia de leitura/escrita e side effects
5) Atualizar 05-integrations.md:
   - chamadas REST/clients, filas/tópicos, arquivos
6) Atualizar 06-procedures.md:
   - se houver chamadas a procs, listar nome/assinatura/Evidence
   - se não houver evidência, deixar TODO e registrar pergunta
7) Atualizar 08-open-questions.md com gaps e conflitos

Formato de Evidence:
- Evidence: <path> :: <classe/método/query-id> :: "<trecho curto>"
