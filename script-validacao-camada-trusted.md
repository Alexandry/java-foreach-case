# Script de Validação da Primeira Camada Trusted

## 1. Objetivo

Validar que os dados solicitados:

1. Foram corretamente extraídos pela Origem.
2. Foram integralmente disponibilizados na camada Raw.
3. Percorreram corretamente o pipeline Raw → Trusted.
4. Foram padronizados sem alteração indevida do significado.
5. Estão aptos para utilização na construção dos dados regulatórios.

> **Diretriz:** a validação funcional pode ser realizada por amostragem dirigida. Quantidade, completude, integridade e reconciliação da ingestão devem considerar 100% da carga, preferencialmente por controles automatizados.

---

## 2. Papéis e responsabilidades

| Responsável | O que valida |
|---|---|
| Origem | Se o dado solicitado foi disponibilizado corretamente e chegou à Raw |
| Engenharia de Dados | Execução da ingestão, transformação, controles técnicos e disponibilização na Trusted |
| Usuário requisitante/Negócio | Se os dados na Trusted representam o requisito solicitado e possuem significado funcional correto |
| Engenharia/Arquitetura da plataforma | Evidências, rastreabilidade, tratamento de erros e resultado consolidado da validação |

---

## 3. Identificação da validação

Preencher antes da execução:

| Campo | Informação |
|---|---|
| Domínio/processo | |
| Sistema de origem | |
| Tabela/arquivo/API de origem | |
| Dataset/tabela Raw | |
| Dataset/tabela Trusted | |
| Data de referência da carga | |
| Identificador da execução | |
| Responsável da Origem | |
| Responsável de Dados | |
| Usuário requisitante | |
| Requisito relacionado | |

---

## 4. Validação da Origem → Raw

**Responsável principal:** Origem, com evidências fornecidas pela Engenharia de Dados.

| Validação | Como validar | Resultado esperado | Resultado obtido | Status | Evidência/observação |
|---|---|---|---|---|---|
| Escopo solicitado | Comparar campos e estruturas solicitados com o que foi ingerido | Todos os dados acordados estão disponíveis | | | |
| Disponibilidade na Raw | Consultar tabela, arquivo ou partição correspondente | Carga disponível na data e no local esperados | | | |
| Quantidade de registros | Comparar contagem da Origem com a Raw | Quantidades reconciliadas | | | |
| Chaves de negócio | Comparar quantidade de chaves e registros distintos | Nenhuma chave perdida ou duplicada indevidamente | | | |
| Completude dos campos | Verificar campos obrigatórios e percentual de nulos | Resultado dentro dos limites acordados | | | |
| Período da carga | Comparar data mínima, máxima e data de referência | Período integralmente carregado | | | |
| Valores de controle | Comparar somas, saldos ou totais financeiros | Totais reconciliados | | | |
| Duplicidade | Verificar duplicidade pela chave definida | Nenhuma duplicidade não prevista | | | |
| Fidelidade à Origem | Comparar amostra entre Origem e Raw | Dados brutos sem transformação indevida | | | |

### 4.1 Evidências mínimas

- Contagem da Origem e da Raw.
- Quantidade de chaves distintas.
- Data mínima e máxima.
- Quantidade e percentual de nulos nos campos críticos.
- Somatórios financeiros ou valores de controle relevantes.
- Registros selecionados para comparação.
- Identificador, data e horário da execução.

### 4.2 Critério de aceite

A Raw somente será considerada validada quando:

- O escopo solicitado estiver completamente disponível.
- As contagens estiverem reconciliadas ou com divergência formalmente justificada.
- Não houver perda de registros ou duplicidade indevida.
- Os dados permanecerem fiéis à Origem.

---

## 5. Validação do pipeline Raw → Trusted

**Responsável principal:** Engenharia de Dados.

O sucesso técnico da execução não é suficiente. A validação deve demonstrar que toda a carga elegível foi corretamente processada.

| Validação | Como validar | Resultado esperado | Resultado obtido | Status | Evidência/observação |
|---|---|---|---|---|---|
| Execução do pipeline | Consultar status e logs da execução | Execução concluída com sucesso | | | |
| Leitura da carga correta | Validar partição, data de referência e identificador da carga | Pipeline processou a carga esperada | | | |
| Registros lidos | Comparar volume lido com a Raw | Todos os registros elegíveis foram lidos | | | |
| Registros gravados | Comparar lidos, aprovados, rejeitados e gravados | Balanço de processamento fechado | | | |
| Regras de transformação | Validar conversões, padronizações e derivações | Regras aplicadas conforme especificação | | | |
| Registros rejeitados | Conferir quantidade, motivo e localização | Rejeições rastreáveis e justificadas | | | |
| Idempotência | Reexecutar controladamente a mesma carga | Sem duplicação ou alteração indevida | | | |
| Tratamento de falhas | Simular ou verificar comportamento em erro | Falha identificada, registrada e recuperável | | | |
| Rastreabilidade | Localizar um registro da Origem até a Trusted | Linhagem ponta a ponta disponível | | | |
| Metadados técnicos | Validar data da carga, origem, execução e referência | Metadados preenchidos corretamente | | | |

### 5.1 Balanço obrigatório da carga

O processamento deve demonstrar a seguinte reconciliação:

```text
Registros Raw elegíveis
= Registros gravados na Trusted
+ Registros rejeitados
+ Registros descartados por regra
```

Todo descarte deve possuir regra, justificativa e evidência. Nenhum registro pode desaparecer durante o pipeline sem rastreabilidade.

---

## 6. Validação da qualidade da Trusted

**Responsáveis:** Engenharia de Dados e usuário requisitante, respeitando as respectivas responsabilidades técnica e funcional.

| Dimensão | Validação | Critério/limite | Resultado obtido | Status | Evidência/observação |
|---|---|---|---|---|---|
| Completude | Campos obrigatórios preenchidos | | | | |
| Unicidade | Ausência de duplicidade nas chaves definidas | | | | |
| Validade | Tipos, formatos, domínios e intervalos corretos | | | | |
| Consistência | Campos relacionados não apresentam contradições | | | | |
| Integridade referencial | Relacionamentos e referências existentes | | | | |
| Atualidade | Dados correspondem à data de referência esperada | | | | |
| Conformidade | Padronização aplicada conforme regra definida | | | | |
| Rastreabilidade | Registro relacionado à Origem e à execução | | | | |
| Exatidão funcional | Valor representa corretamente o evento de negócio | | | | |

> **Regra de bloqueio:** regras críticas devem ser avaliadas individualmente. Um índice geral de qualidade satisfatório não compensa o descumprimento de uma regra crítica para o processo regulatório.

---

## 7. Validação funcional por amostragem dirigida

**Responsável principal:** usuário que solicitou o requisito.

A amostra deve cobrir, quando aplicável:

- Casos de maior volume ou valor financeiro.
- Casos comuns do processo.
- Casos de fronteira.
- Situações excepcionais.
- Registros com campos nulos permitidos.
- Diferentes produtos, modalidades e status.
- Registros transformados ou classificados por regras.
- Casos rejeitados pelos controles de qualidade.
- Pelo menos um registro de cada cenário funcional relevante.

### 7.1 Registro da amostragem

| Identificador | Cenário funcional | Valor na Origem/Raw | Valor esperado na Trusted | Valor encontrado | Regra aplicada | Status | Evidência/observação |
|---|---|---|---|---|---|---|---|
| | | | | | | | |

### 7.2 Confirmações do usuário requisitante

- [ ] Os campos solicitados foram disponibilizados.
- [ ] O significado dos dados foi preservado.
- [ ] As classificações e padronizações estão corretas.
- [ ] Os registros representam adequadamente o processo de negócio.
- [ ] Os dados estão aptos a alimentar a próxima etapa regulatória.

---

## 8. Critérios de aprovação da Trusted

A primeira camada Trusted será considerada aprovada quando:

- [ ] Origem → Raw estiver reconciliada.
- [ ] O pipeline tiver processado toda a carga elegível.
- [ ] Rejeições e descartes estiverem contabilizados e justificados.
- [ ] Regras críticas de qualidade estiverem atendidas.
- [ ] A amostragem funcional estiver aprovada pelo usuário requisitante.
- [ ] Divergências residuais tiverem plano de ação, responsável e prazo.
- [ ] Todas as evidências estiverem vinculadas ao identificador da carga.

---

## 9. Resultado final

| Item | Resultado |
|---|---|
| Validação Origem → Raw | Aprovado / Reprovado |
| Validação do pipeline | Aprovado / Reprovado |
| Qualidade da Trusted | Aprovado / Reprovado |
| Validação funcional | Aprovado / Reprovado |
| Pendências bloqueantes | |
| Pendências não bloqueantes | |
| Responsável pelas correções | |
| Prazo para correção | |
| Necessidade de reprocessamento | Sim / Não |
| Parecer final | Aprovado / Aprovado com ressalvas / Reprovado |

---

## 10. Aceites

Os aceites devem ser registrados separadamente para evitar sobreposição de responsabilidades.

### 10.1 Aceite da Origem

Confirma que o dado correto foi disponibilizado e chegou integralmente à Raw.

| Nome | Área | Decisão | Data | Observação |
|---|---|---|---|---|
| | | | | |

### 10.2 Aceite técnico de Dados

Confirma a integridade da ingestão, transformação, qualidade técnica, reconciliação e rastreabilidade.

| Nome | Área | Decisão | Data | Observação |
|---|---|---|---|---|
| | | | | |

### 10.3 Aceite funcional do requisitante

Confirma que a Trusted atende ao requisito e preserva o significado funcional dos dados.

| Nome | Área | Decisão | Data | Observação |
|---|---|---|---|---|
| | | | | |

---

## 11. Diretrizes de auditoria e rastreabilidade

- A Raw deve permanecer fiel ao dado recebido da Origem.
- Limpezas e padronizações devem ocorrer na Trusted conforme regras documentadas.
- Correções posteriores não devem apagar ou sobrescrever o histórico original.
- Deve ser possível reconstruir o caminho do registro desde a Origem até a Trusted.
- A trilha deve identificar o que entrou, o que foi transformado, o que foi rejeitado e o que foi disponibilizado.
- Reprocessamentos devem manter referência à carga e à execução anteriores.

