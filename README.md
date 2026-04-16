PDP — Plataforma Regulatória Integrada
1. Visão executiva

A Plataforma Regulatória Integrada nasce para resolver um problema estrutural: hoje o processo regulatório depende de múltiplas origens, ajustes manuais na ponta, conciliações frágeis e baixa rastreabilidade entre origem, processamento e entrega.

A proposta da solução é criar uma plataforma capaz de:

consolidar dados de múltiplas origens internas;
padronizar e preparar uma delivery regulatória;
publicar essa delivery para um parceiro externo, responsável pelo core regulatório;
receber de volta os resultados de processamento, inconsistências de conciliação e ajustes manuais;
internalizar esses retornos com rastreabilidade;
abrir pendências para as origens responsáveis;
recalcular apenas o recorte impactado;
manter o processo regulatório operando mesmo quando a origem ainda não corrigiu a causa raiz;
estabilizar o ciclo quando a origem passar a enviar o dado corretamente.

Em termos simples, a plataforma deixa de ser uma esteira de carga e passa a ser uma plataforma operacional de regulatório, com governança, reconciliação, reprocessamento seletivo e fechamento do ciclo com os legados.

2. Storytelling do projeto
Situação atual

O processo regulatório sofre com:

múltiplos sistemas de origem com formatos e horários distintos;
baixa uniformidade de corte e dependências;
tratamento manual feito na ponta, sem retroalimentação consistente para a origem;
dificuldades de conciliação entre documentos, como 3040 e 4010;
reprocessamentos pesados sempre que algo dá errado;
ausência de rastreabilidade ponta a ponta.
Dor central

Quando uma inconsistência aparece, o efeito em cadeia é ruim:

não fica claro onde o erro nasceu;
o time regulatório corrige o ciclo atual de forma pontual;
a origem continua errando;
o problema volta no mês seguinte;
a operação aprende a conviver com remendo.
Mudança proposta

A nova plataforma muda essa lógica:

a rede interna consolida e publica a delivery regulatória;
o parceiro externo processa, concilia e identifica achados;
a rede interna recebe esses achados formalmente;
ajustes e inconsistências viram trilha interna e pendência operacional;
a plataforma recalcula apenas o necessário;
a origem é obrigada a corrigir a causa raiz;
o overlay deixa de ser necessário quando o saneamento se comprova.
Resultado esperado

Ao final, a organização deixa de operar regulatório na lógica do improviso e passa a ter:

rastreabilidade;
governança;
recálculo seletivo;
capacidade de conciliar e explicar desvios;
fechamento de ciclo com legado/origem;
preparação para escalar a solução para outros regulatórios.
3. Objetivo do PDP

Transformar a arquitetura e os casos de uso da Plataforma Regulatória Integrada em um plano detalhado de construção, contendo:

escopo;
MVP;
roadmap evolutivo;
cronograma por fases;
workstreams;
entregáveis;
dependências;
critérios de sucesso;
riscos;
modelo de governança.
4. Objetivos estratégicos
Objetivos de negócio
aumentar a confiabilidade do processo regulatório;
reduzir dependência de ajuste manual na ponta;
criar rastreabilidade ponta a ponta;
melhorar conciliação entre documentos regulatórios;
reduzir retrabalho operacional;
acelerar saneamento das origens.
Objetivos técnicos
desacoplar origens do parceiro externo;
implantar um canal controlado de publicação;
internalizar formalmente achados do parceiro;
viabilizar reprocessamento seletivo;
manter o dado original intacto e aplicar overlay somente na camada resolved;
criar base operacional para evolução multi-regulatório.
5. Escopo do projeto
5.1 Escopo incluído
ingestão de dados de origens internas;
camadas landing/raw, trusted e canonical;
validação de dependências e corte;
geração de delivery interna;
publicação controlada ao parceiro externo;
processamento de retorno de inconsistências do parceiro;
processamento de retorno de ajustes manuais do parceiro;
shadow ledger / base espelho;
issue manager;
notificação e task para origem;
análise de impacto;
reprocessamento seletivo;
camada regulatory_resolved;
reconciliação de saneamento;
encerramento de issue e inativação do overlay;
painel operacional mínimo;
observabilidade e rastreabilidade.
5.2 Fora de escopo inicial
cobertura de todos os regulatórios desde o início;
automação total de remediação de legados;
substituição imediata de todos os fluxos regulatórios existentes;
integração full com todos os sistemas legados já na primeira onda;
modelo operacional final de todas as áreas;
refatoração completa dos domínios de origem.
6. Premissas
O parceiro externo será responsável pelo core regulatório.
A rede interna será responsável pela preparação da delivery.
O parceiro poderá devolver:
sucesso,
inconsistência,
ajuste manual,
inconsistência + ajuste.
O dado original não será sobrescrito por ajuste externo.
Ajustes vindos do parceiro serão refletidos em uma base espelho interna.
A origem permanece responsável pela correção estrutural.
Reprocessamentos devem ser seletivos, não integrais.
O primeiro regulatório de referência para implementação é o fluxo derivado do cenário já estudado, com prioridade inicial no modelo que conversa com 3040/4010.
O projeto será executado em fases, com MVP e ondas evolutivas.
7. Princípios do produto
Publicação controlada: parceiro externo não acessa legados diretamente.
Rastreabilidade obrigatória: todo retorno do parceiro gera trilha interna.
Separação entre verdade original e verdade regulatória vigente.
Tratativa operacional explícita: inconsistência vira pendência formal.
Overlay temporário: ajuste não substitui a origem permanentemente.
Reprocessamento seletivo: recalcular apenas o que foi afetado.
Saneamento orientado à causa raiz.
Escalabilidade regulatória: solução preparada para crescer além do caso inicial.
8. MVP
8.1 Objetivo do MVP

Entregar a menor versão funcional capaz de provar o ciclo regulatório completo ponta a ponta, com rastreabilidade e tratativa operacional mínima.

8.2 O que o MVP precisa fazer

O MVP deve contemplar:

ingestão de um conjunto controlado de origens;
geração de delivery interna para um processo regulatório inicial;
publicação controlada ao parceiro externo;
recebimento de inconsistências do parceiro;
recebimento de ajustes manuais do parceiro;
gravação de base espelho;
abertura de pendência para origem;
análise de impacto;
reprocessamento seletivo básico;
geração de delivery atualizada;
reconciliação de saneamento da origem;
encerramento de issue com retirada do overlay.
8.3 O que fica fora do MVP
múltiplos regulatórios simultâneos;
painéis avançados;
motor complexo de regras parametrizáveis;
integração com todos os legados;
automação avançada de SLA e escalonamento;
otimizações finas de performance multi-volume;
governança corporativa completa de catálogo e acesso fino.
8.4 Critério de sucesso do MVP

O MVP será considerado bem-sucedido quando for possível demonstrar:

geração da delivery interna;
publicação ao parceiro;
retorno de inconsistência e ajuste;
gravação no ledger;
criação de issue;
reprocessamento do recorte afetado;
atualização da delivery;
saneamento da origem;
retirada do overlay e fechamento da pendência.
9. Capabilities do produto
C1. Ingestão regulatória

Receber dados de múltiplas origens e preservar o bruto.

C2. Padronização e consolidação

Promover dados para trusted e canonical.

C3. Delivery regulatória interna

Gerar a visão pronta para publicação.

C4. Publicação controlada

Entregar dados ao parceiro com versionamento e rastreabilidade.

C5. Recebimento de findings externos

Receber inconsistências e ajustes.

C6. Shadow ledger

Internalizar formalmente os retornos do parceiro.

C7. Gestão de pendências

Abrir, atribuir, acompanhar e cobrar origem.

C8. Reprocessamento seletivo

Recalcular só o recorte afetado.

C9. Regulatory resolved

Aplicar overlay do ajuste sem alterar o dado original.

C10. Reconciliação de saneamento

Validar se a origem corrigiu a causa raiz.

C11. Encerramento e estabilização

Remover overlay e fechar issue.

C12. Observabilidade operacional

Monitorar execução, publicação, issues, reprocessamentos e saneamento.

10. Workstreams
WS-01 — Ingestão e Padronização

Objetivo: construir a base interna de entrada e consolidação.

Inclui:

contratos de entrada;
landing/raw;
trusted;
canonical;
validação de dependências e corte.

Entregáveis:

ingestion_control
landing_*
trusted_*
canonical_*
controle de prontidão
WS-02 — Delivery e Publicação

Objetivo: preparar e publicar a delivery regulatória interna.

Inclui:

delivery ready;
publication control;
versionamento de entrega;
canal controlado de publicação.

Entregáveis:

delivery_*
publication_control
delivery_manifest
serviço de publicação
WS-03 — Integração com Parceiro Externo

Objetivo: estabelecer a integração funcional e técnica com o parceiro.

Inclui:

contrato de envio;
correlação por publication_id;
contrato de retorno de findings;
tratamento de ACK/rejeição.

Entregáveis:

contrato de integração
modelo de retorno
validação de correlação
WS-04 — Retorno de Inconsistências e Ajustes

Objetivo: receber e persistir os achados do parceiro.

Inclui:

consumer de ajuste;
consumer de inconsistência;
persistência bruta;
normalização.

Entregáveis:

adjustment_event_received
reconciliation_event_received
adjustment_ledger
external_reconciliation_issue
WS-05 — Gestão de Pendências e Notificações

Objetivo: transformar finding externo em ação operacional.

Inclui:

issue manager;
source remediation task;
notificação de origem;
SLA básico.

Entregáveis:

data_issue
source_remediation_task
regras de abertura e atribuição
painel operacional mínimo
WS-06 — Reprocessamento Seletivo

Objetivo: recalcular apenas o recorte afetado.

Inclui:

impact analyzer;
escopo de reprocessamento;
execução de reprocessamento;
update incremental da resolved.

Entregáveis:

reprocessing_scope
reprocessing_run
regulatory_resolved_*
engine de recálculo
WS-07 — Saneamento e Fechamento do Ciclo

Objetivo: validar correção na origem e encerrar a pendência.

Inclui:

reconciliador de saneamento;
inativação de ajuste;
retirada de overlay;
encerramento de issue.

Entregáveis:

sanitation_reconciliation_result
issue_resolution
recálculo final sem overlay
WS-08 — Capacidades Transversais

Objetivo: garantir sustentação operacional e técnica.

Inclui:

observabilidade;
rastreabilidade;
logs;
métricas;
segurança mínima;
versionamento de publicação;
evidências de execução.

Entregáveis:

modelo de correlação ponta a ponta
eventos/logs mínimos
dashboards operacionais
métricas de SLA e falha
11. Roadmap por fases
Fase 0 — Preparação e Alinhamento

Objetivo: estabelecer base de decisão, escopo e contratos.

Entregas:

blueprint funcional
blueprint técnico
catálogo de casos de uso
definição de regulatório inicial
definição do parceiro e modelo de integração
alinhamento entre arquitetura, dados, engenharia e operação

Resultado:

projeto pronto para mobilização
Fase 1 — Fundação da Plataforma Interna

Objetivo: construir a esteira base até a delivery interna.

Inclui:

WS-01
parte de WS-08

Entregas:

ingestão funcional
landing/raw
trusted
canonical
validação de corte/dependência
delivery interna
observabilidade básica

Resultado:

dado interno preparado e controlado
Fase 2 — Publicação e Integração Externa

Objetivo: disponibilizar delivery ao parceiro e formalizar o contrato de troca.

Inclui:

WS-02
WS-03

Entregas:

publication control
canal controlado de publicação
contrato de envio
correlação publication_id
handshake operacional com parceiro

Resultado:

delivery publicada com rastreabilidade
Fase 3 — Internalização dos Findings Externos

Objetivo: receber e persistir inconsistências e ajustes vindos do parceiro.

Inclui:

WS-04
parte de WS-05

Entregas:

consumers de retorno
persistência bruta
shadow ledger
normalização de inconsistências
painel mínimo de retorno

Resultado:

parceiro deixa de ser caixa-preta
Fase 4 — Tratativa Operacional e Reprocessamento

Objetivo: abrir pendência, analisar impacto e recalcular o mínimo necessário.

Inclui:

WS-05
WS-06

Entregas:

issue manager
source remediation task
impact analyzer
reprocessing scope/run
regulatory resolved
delivery atualizada

Resultado:

ciclo atual segue mesmo com erro na origem
Fase 5 — Saneamento da Origem e Estabilização

Objetivo: fechar o ciclo de causa raiz.

Inclui:

WS-07
complemento de WS-08

Entregas:

reconciliador de saneamento
retirada do overlay
encerramento de issue
métricas de estabilidade e reincidência

Resultado:

origem corrigida e processo estabilizado
Fase 6 — Escala e Industrialização

Objetivo: expandir a plataforma para novos regulatórios e maior volume.

Inclui:

expansão de origens
expansão de regulatórios
melhoria de performance
governança refinada
automações complementares

Resultado:

plataforma corporativa escalável
12. Cronograma de referência

Vou propor um cronograma em semanas, porque é mais realista que fixar datas sem conhecer o tamanho exato dos times.

Janela sugerida: 28 semanas
Fase	Duração	Semanas
Fase 0 — Preparação	2 semanas	1–2
Fase 1 — Fundação interna	6 semanas	3–8
Fase 2 — Publicação e integração	4 semanas	9–12
Fase 3 — Findings externos	4 semanas	13–16
Fase 4 — Reprocessamento seletivo	5 semanas	17–21
Fase 5 — Saneamento e estabilização	4 semanas	22–25
Fase 6 — Hardening / industrialização inicial	3 semanas	26–28
Leitura honesta do cronograma

Isso é um cronograma referência, não promessa.
Ele pressupõe:

alinhamento entre times;
parceiro relativamente responsivo;
escopo de MVP controlado;
poucas dependências externas não resolvidas.

Se o projeto tiver muita indefinição de integração, legado ou contrato com parceiro, esse cronograma escapa fácil.

13. MVP dentro do cronograma
MVP funcional recomendado até a semana 21

O MVP mais útil deveria estar de pé ao final da Fase 4, contendo:

carga interna até delivery;
publicação controlada;
retorno de inconsistência;
retorno de ajuste;
shadow ledger;
issue manager básico;
reprocessamento seletivo;
delivery atualizada com overlay.
Por quê?

Porque isso já prova o coração da plataforma:

o ciclo não quebra com erro;
o parceiro não vira buraco negro;
a origem passa a ser cobrada;
o dado pode ser reprocessado sem rerun total.

A Fase 5 fecha o ciclo de qualidade estrutural, mas o valor principal já aparece antes.

14. Roadmap evolutivo
Onda 1 — Provar o ciclo

Meta:

construir o caminho completo do dado até o parceiro e de volta para a delivery.

Foco:

MVP
Onda 2 — Fechar o ciclo de saneamento

Meta:

garantir que origem corrija e overlay seja removido.

Foco:

reconciliação de saneamento
encerramento de issue
Onda 3 — Escalar operacionalmente

Meta:

sair de um fluxo funcional para uma plataforma operável.

Foco:

dashboards
métricas
SLA
automação de acompanhamento
estabilidade
Onda 4 — Escalar regulatórios

Meta:

reaproveitar a arquitetura para outros regulatórios e novos domínios.

Foco:

parametrização
reuso de componentes
ampliação do catálogo regulatório
15. Dependências entre workstreams
Workstream	Depende de
WS-02 Delivery e Publicação	WS-01
WS-03 Integração Externa	WS-02
WS-04 Findings Externos	WS-03
WS-05 Gestão de Pendências	WS-04
WS-06 Reprocessamento Seletivo	WS-04, WS-05
WS-07 Saneamento	WS-05, WS-06
WS-08 Transversal	Acompanha todos
16. Marcos do projeto
M1 — Arquitetura e escopo aprovados

Critério:

blueprint funcional e técnico aceitos
parceiro e integração direcionados
M2 — Delivery interna pronta

Critério:

ingestão → trusted → canonical → delivery funcionando
M3 — Publicação controlada concluída

Critério:

publication_id, versionamento e envio ao parceiro implementados
M4 — Retorno do parceiro internalizado

Critério:

ajuste e inconsistência entrando em eventos brutos e ledger
M5 — Reprocessamento seletivo funcionando

Critério:

delivery recalculada sem rerun total
M6 — Fechamento do ciclo de saneamento

Critério:

origem corrigiu
overlay foi removido
issue encerrada
M7 — MVP aceito

Critério:

fluxo ponta a ponta executado com sucesso e rastreabilidade
17. Critérios de sucesso do projeto
Critérios funcionais
delivery interna gerada corretamente;
publication control ativo;
retorno de inconsistência tratado;
retorno de ajuste tratado;
issue aberta automaticamente;
reprocessamento seletivo funcionando;
delivery atualizada corretamente;
saneamento comprovado e issue encerrada.
Critérios operacionais
rastreabilidade ponta a ponta por publication_id / issue_id / adjustment_id;
visibilidade operacional mínima por painel ou relatório;
capacidade de explicar o motivo do recálculo;
controle de SLA para pendência de origem.
Critérios técnicos
idempotência no recebimento dos retornos externos;
canonical preservada;
overlay apenas em regulatory_resolved;
reprocessamento por escopo definido;
logs e métricas mínimas implementadas.
18. Indicadores recomendados
Indicador	Objetivo
% de deliveries publicadas com sucesso	medir estabilidade da publicação
% de findings externos tratados	medir absorção operacional
tempo médio até abertura de issue	medir responsividade
tempo médio de reprocessamento seletivo	medir eficiência técnica
% de issues encerradas com saneamento	medir efetividade do fechamento
tempo médio até correção da origem	medir maturidade dos legados
% de recálculos seletivos vs full rerun	medir eficiência da arquitetura
taxa de reincidência por origem	medir causa raiz
19. Riscos principais
R1. Integração com parceiro pouco madura

Impacto:

atrasa publicação e retorno

Mitigação:

contrato de integração formal
piloto técnico cedo
correlation id obrigatório
R2. Legados sem dono claro

Impacto:

issue aberta sem resolução

Mitigação:

mapeamento de ownership
task com responsável explícito
escalonamento
R3. Reprocessamento granular demais

Impacto:

custo e complexidade excessivos

Mitigação:

definir unidade mínima de reprocessamento
permitir fallback por partição/competência
R4. Mistura entre dado original e overlay

Impacto:

quebra de rastreabilidade

Mitigação:

canonical imutável
resolved como camada separada
R5. Projeto crescer cedo demais

Impacto:

cronograma explode

Mitigação:

MVP rígido
regulatório inicial único
backlog evolutivo por onda
R6. Operação virar dependente do parceiro

Impacto:

baixa autonomia interna

Mitigação:

internalização obrigatória dos findings
painel e ledger internos
governance local
20. Governança do projeto
Fóruns sugeridos
Fórum semanal de delivery

Participantes:

engenharia
dados
arquitetura
parceiro
operação

Objetivo:

acompanhar andamento dos workstreams
resolver impedimentos
Fórum quinzenal de arquitetura

Objetivo:

validar aderência ao blueprint
revisar riscos
revisar exceções e evolução de desenho
Fórum quinzenal de operação regulatória

Objetivo:

validar fluxos de issue, saneamento e reconciliadores
discutir achados e ajustes operacionais
21. RACI resumido
Atividade	Arquitetura	Engenharia	Dados	Operação	Parceiro	Times de Origem
Definir blueprint	A	C	C	C	I	I
Construir ingestão/trusted/canonical	C	R	R	I	I	I
Construir delivery/publicação	C	R	R	I	C	I
Definir contrato com parceiro	A	C	C	I	R	I
Implementar retorno de findings	C	R	C	I	R	I
Abrir e gerir issues	I	R	C	A	I	C
Corrigir causa raiz	I	I	I	C	I	R
Reprocessar seletivamente	C	R	R	C	I	I
Encerrar issue e remover overlay	C	R	C	A	I	C

Legenda: A = accountable, R = responsible, C = consulted, I = informed

22. Backlog macro priorizado
Prioridade 1
contratos de entrada
ingestão
landing/raw
trusted
canonical
delivery interna
Prioridade 2
publication control
canal de publicação
integração com parceiro
Prioridade 3
adjustment consumer
reconciliation consumer
shadow ledger
Prioridade 4
issue manager
source remediation task
painel mínimo
Prioridade 5
impact analyzer
reprocessing scope/run
regulatory resolved
Prioridade 6
sanitation reconciler
retirada de overlay
issue resolution
Prioridade 7
dashboards e governança refinada
automações avançadas
expansão multi-regulatório
23. Encerramento do PDP

Este PDP organiza a construção da Plataforma Regulatória Integrada em uma sequência lógica, incremental e rastreável.

A estratégia adotada busca evitar dois erros clássicos:

tentar resolver tudo em uma única onda;
construir apenas pipeline sem capacidade operacional.

O plano proposto prioriza primeiro a capacidade de:

gerar delivery,
publicar,
absorver findings,
recalcular seletivamente,
fechar o ciclo com as origens.
