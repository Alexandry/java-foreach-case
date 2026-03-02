# comp_scaffold — cria pacote de documentação do componente

Input:
- component_id (default: svc-core-extrato)
- tipo: svc|job|sp|etl|lib (default: svc)

Tarefa:
1) Criar /docs/components/<component_id>/
2) Criar os arquivos:
- 00-overview.md
- 01-interfaces.md
- 02-data-access.md
- 03-rules-transform.md
- 04-lineage.md
- 05-integrations.md
- 06-procedures.md
- 07-tests.md
- 08-open-questions.md
3) Atualizar /docs/catalogs/component-catalog.md adicionando o componente (se não existir)

Templates:

00-overview.md
# <component_id> — Overview
- Tipo: <tipo>
- Sistema: TODO (system_id)
- Objetivo: TODO
- Dono: TODO
- Execução: (request/cron/manual/event) TODO
- SLA/volumetria: TODO
- Dependências: TODO
- Riscos: TODO

01-interfaces.md
# Interfaces observáveis
## Inputs
- TODO
## Outputs
- TODO
## Erros
- TODO

02-data-access.md
# Data Access
## Databases/Schemas
- TODO
## Tabelas lidas
- TODO
## Tabelas escritas
- TODO
## Queries encontradas (com Evidence)
- TODO

03-rules-transform.md
# Rules & Transformations
## Regras (com Evidence)
- R-001: TODO
## Transformações
- T-001: TODO
## De-Para/Enums
- D-001: TODO

04-lineage.md
# Data Lineage
## Lê -> Escreve
- TODO
## Side effects
- TODO

05-integrations.md
# Integrações
## REST/SOAP
- TODO
## Filas/Tópicos
- TODO
## Arquivos
- TODO

06-procedures.md
# Procedures (espaço reservado)
## Procedures chamadas pelo componente
- TODO (nome, assinatura, Evidence)
## Procedures a adicionar (se existirem no DB)
- TODO
## Scripts
- /schemas/db/procs/ (colocar aqui)

07-tests.md
# Tests
## Golden inputs/outputs
- TODO
## Casos críticos
- TODO

08-open-questions.md
# Open Questions
- Q1: TODO
