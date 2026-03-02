# lo_field_catalog — Catálogo de campos (Discovery -> Canônico -> Mapping)

Você é um analista/arquitetto de integrações. Use APENAS as fontes do repositório (arquivos abertos e paths citados abaixo). Não invente campos.

## Input do usuário
- integration_name: nome em kebab-case (ex.: oficio-quebra-sigilo)
Se não informado, usar "oficio-quebra-sigilo".

## Fontes padrão (procure nelas)
- Catálogo: /docs/legal-orders/discovery/01-notes/domain-catalog.md
- Discovery bruto: /docs/legal-orders/discovery/00-inbox/
- Notas: /docs/legal-orders/discovery/01-notes/
- Layouts/dicionário: /schemas/data-layouts/
- Amostras: /samples/spreadsheets/ e /samples/payloads/

## Regras
- Não inventar nada: se uma coluna/termo não estiver explícito, marcar como TODO e registrar em Open Questions.
- Dados sensíveis: ao criar exemplos, mascarar (CPF, conta, nome, chave, valores).
- Sempre classificar sensibilidade do campo (PII, Banking, Public, Internal).
- Se existir conflito entre fontes (layout vs planilha vs ata), registrar o conflito.

## Tarefa (execute na ordem)
1) Identificar o “artefato primário”:
   - Qual planilha/layout é a base do processo atual? (se houver mais de uma, listar candidatas e escolher a mais completa)

2) Gerar arquivo de catálogo de campos:
   - Criar: /docs/legal-orders/integrations/<integration_name>/06-field-catalog.md
   - O catálogo deve conter:
     - lista de entidades/categorias (ex.: Pedido, Alvo, Período, Resposta de Área, Evidências)
     - tabela de campos com colunas:
       canonical_path | significado | tipo | required | source_artifact | source_field | area/system | regras/transform | validacoes | de-para | sensibilidade | observacoes

3) Propor “Modelo Canônico v0” (mínimo):
   - Dentro do 06-field-catalog.md, criar seção:
     - Canonical Model v0 (paths + tipos)
   - Objetivo: um modelo que sirva para consolidar respostas de áreas sem depender do Excel

4) Atualizar o mapping:
   - Atualizar: /docs/legal-orders/integrations/<integration_name>/02-mapping.yml
   - Preencher "canonical" com campos reais encontrados
   - Gerar entradas em "mappings" com source_field(s) -> canonical_path
   - Se algum source_field não tiver correspondência clara, manter TODO e registrar Open Questions

5) Atualizar contexto:
   - Atualizar /docs/legal-orders/integrations/<integration_name>/00-context.md
   - Preencher “Escopo do pedido (TODO)” com o que foi encontrado
   - Preencher/atualizar “Open Questions” com gaps e decisões necessárias

## Formato do 06-field-catalog.md
- Começar com "Fontes usadas" (lista de arquivos lidos)
- Depois "Resumo do artefato primário"
- Depois tabela de campos
- Depois "Canonical Model v0"
- Depois "Open Questions"
