# lo_scaffold — Scaffold do pacote de integração (Legal Orders)

Você é um arquiteto de integrações e analista de processos. Sua tarefa é criar o scaffold (template) do pacote padrão da integração de Legal Orders.

## Input do usuário (obrigatório)
- integration_name: nome curto em kebab-case (ex.: oficio-quebra-sigilo)
Se o usuário não informar, use: "oficio-quebra-sigilo".

## Regras
- Não invente campos de negócio. Este command só cria a estrutura + placeholders.
- Referencie o catálogo: /docs/legal-orders/discovery/01-notes/domain-catalog.md
- Exemplos devem ser anonimizados (mascarar dados).

## Tarefa
1) Garantir que existam as pastas:
- /docs/legal-orders/integrations/
- /docs/legal-orders/adr/
- /schemas/api/
- /schemas/events/
- /samples/payloads/
- /samples/spreadsheets/

2) Criar o pacote padrão em:
- /docs/legal-orders/integrations/<integration_name>/
  - 00-context.md
  - 01-contracts.md
  - 02-mapping.yml
  - 03-examples/ (pasta)
    - request.sample.json
    - response.sample.json
    - validation-errors.sample.json
  - 04-errors.md
  - 05-rollout.md

3) Preencher cada arquivo com o template abaixo, mantendo TODOs onde faltar informação.

---

## Conteúdo: 00-context.md
# <integration_name> — Contexto

## Objetivo
Automatizar o fluxo de ordem judicial/ofício (ex.: quebra de sigilo) do recebimento até consolidação, validação e submissão (com aprovação humana).

## Fontes (linkar arquivos do repo)
- Domain catalog: /docs/legal-orders/discovery/01-notes/domain-catalog.md
- Discovery inbox: /docs/legal-orders/discovery/00-inbox/
- Notas/resumos: /docs/legal-orders/discovery/01-notes/
- Decisões: /docs/legal-orders/discovery/02-decisions/
- Dúvidas: /docs/legal-orders/discovery/03-open-questions/

## Atores
- Negócio/Compliance (orquestra, aprova submissão)
- Áreas provedoras de dados (respondem)
- Adaptador externo (submissão ao juízo) — TODO: canal real

## Escopo do pedido (TODO)
- Tipos de dados solicitados:
  - TODO
- Janela temporal:
  - TODO
- Identificadores:
  - TODO (CPF/CNPJ/conta/chave/pessoa)

## Estados do processo (proposta inicial)
RECEIVED -> TRIAGED -> REQUESTED -> COLLECTING -> VALIDATING -> (NEEDS_FIX | READY_TO_SUBMIT) -> SUBMITTED -> CLOSED

## Requisitos não-negociáveis
- Auditoria completa (quem/quando/o quê/por quê)
- Aprovação humana antes de envio externo
- Dados sensíveis mascarados em exemplos
- Idempotência e rastreabilidade (correlationId / requestId)

## Open Questions (preencher)
- Q1:
- Q2:
- Q3:

---

## Conteúdo: 01-contracts.md
# <integration_name> — Contratos (rascunho)

> Este arquivo define o “mínimo” de contrato para tirar o fluxo do e-mail+Excel.
> Não inventar campos; apenas estrutura e pontos de integração.

## API do Orquestrador (mínimo)
### Endpoints (rascunho)
- POST /legal-orders
- GET /legal-orders/{id}
- POST /legal-orders/{id}/triage
- POST /legal-orders/{id}/requests
- POST /legal-orders/{id}/areas/{area_id}/responses
- POST /legal-orders/{id}/validate
- POST /legal-orders/{id}/approve
- POST /legal-orders/{id}/submit

## Eventos (se event-driven)
- legal_order.received
- legal_order.triaged
- legal_order.data_requested
- legal_order.data_provided
- legal_order.validation_failed
- legal_order.ready_to_submit
- legal_order.submitted

## Versionamento
- API: versionamento por path (/v1) ou header — TODO: decisão
- Eventos: versionar schema (ex.: legal_order.data_requested.v1.json)

## Segurança e auditoria (TODO)
- RBAC (perfis) — TODO
- trilha de auditoria — TODO
- criptografia em repouso/transporte — TODO

---

## Conteúdo: 02-mapping.yml
integration: <integration_name>
version: 1

source:
  description: "Origem atual (manual) ou sistema(s) que fornecem dados"
  artifacts:
    - "docs/legal-orders/discovery/00-inbox/ (planilhas/atas)"
  # TODO: quando houver contratos reais, apontar schemas

target:
  description: "Modelo canônico do orquestrador + pacote final para submissão"
  # TODO: apontar OpenAPI/JSON schema quando criado

canonical:
  # Modelo canônico mínimo (preencher no discovery)
  legalOrder:
    fields:
      - name: legalOrderId
        required: true
      - name: processNumber
        required: true
      - name: dueDate
        required: false
      - name: scope
        required: true

depara:
  # Exemplo: status internos vs externos (preencher)
  status_v1:
    TODO: TODO

mappings:
  # Preencher com catálogo de campos (excel/layout -> canônico)
  - source: "TODO.excel_col_or_field"
    target: "canonical.legalOrder.TODO"
    required: true
    transform: "TODO"
    validations:
      - "TODO"
    onUnknown: "ERROR"

defaults:
  # Defaults canônicos
  TODO: TODO

behavior:
  idempotencyKey: "TODO (ex.: processNumber + legalOrderId)"
  correlationId: "TODO"
  retry:
    policy: "exponential"
    maxAttempts: 5
  errorHandling:
    strategy: "NEEDS_FIX"
    detailsField: "validationErrors"

---

## Conteúdo: 03-examples/request.sample.json
{
  "legalOrderId": "LO-0001",
  "processNumber": "0000000-00.0000.0.00.0000",
  "scope": {
    "type": "TODO",
    "period": {"from": "2026-01-01", "to": "2026-01-31"},
    "identifiers": [{"type": "CPF", "value": "***.***.***-**"}]
  }
}

## Conteúdo: 03-examples/response.sample.json
{
  "legalOrderId": "LO-0001",
  "areaId": "TODO",
  "data": {
    "items": []
  }
}

## Conteúdo: 03-examples/validation-errors.sample.json
{
  "legalOrderId": "LO-0001",
  "status": "NEEDS_FIX",
  "errors": [
    {"field": "scope.period.from", "rule": "required", "message": "Campo obrigatório"}
  ]
}

---

## Conteúdo: 04-errors.md
# <integration_name> — Erros e validações

## Tipos de erro
- VALIDATION_ERROR: schema/obrigatoriedade/formato
- BUSINESS_RULE_ERROR: regra de negócio (ex.: período inválido)
- INTEGRATION_ERROR: falha de chamada/timeout
- AUTHZ_ERROR: falta de permissão
- AUDIT_ERROR: inconsistência de trilha

## Estratégia de retorno para a área
- Sempre devolver: campo + regra + mensagem + exemplo de correção
- Estado do caso vira NEEDS_FIX com responsável (area_id)

## Retry / Idempotência (TODO)
- Chaves de idempotência:
- Política de retry:
- DLQ (se eventos):

---

## Conteúdo: 05-rollout.md
# <integration_name> — Rollout

## Fase 0 (atual)
- Email + Excel + validação manual

## Fase 1 (ganho rápido)
- Intake via API + portal/endpoint de upload de respostas (ainda manual nas áreas)

## Fase 2 (automação interna)
- Áreas respondem via API/evento com payload padronizado
- Validação automática devolve NEEDS_FIX

## Fase 3 (submissão externa)
- Adapter para envio ao juízo (API se existir; senão geração de pacote)

## Feature flags / fallback
- flag: enable_auto_requests
- flag: enable_auto_validation
- fallback: exportar pacote para revisão humana
