# process_scaffold — criar pacote do processo

Input:
- process_id (default: rotina-extrato)

Tarefa:
Criar /docs/processes/<process_id>/
- 00-process.md
- 01-scope-sla.md
- 02-components.md
- 03-io-contract.md
- 04-controls-audit.md
- 05-rollout.md

Templates:

00-process.md
# <process_id> — Processo
## Objetivo
TODO
## Gatilho
cron/event/manual TODO
## Etapas (alto nível)
1. TODO
2. TODO
## Entradas/Saídas
- Entrada: TODO
- Saída: TODO

02-components.md
# Componentes participantes
- TODO (linkar /docs/components/<id>/00-overview.md)

04-controls-audit.md
# Controles & Auditoria
- Trilha de auditoria: TODO
- Aprovações: TODO
- Retenção: TODO
- Reprocessamento/idempotência: TODO
