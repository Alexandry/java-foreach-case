---
description: Roteiro de tarefas para a implementação da fase de consolidação do 3040.
globs: *
---
<task_flow>
Siga estas etapas para construir o pipeline. SEMPRE atualize o `checklist.md` antes de codificar.

- **Passo 0: Planejamento Inicial**
  Crie o arquivo `checklist.md` detalhando as tarefas técnicas baseadas nos passos abaixo. Peça permissão ao usuário antes de iniciar o Passo 1.

- **Passo 1: Domínio e Mapeamento (`@agent-bacen-analyst` e `@agent-java-dev`)**
  Analise os XMLs na pasta `insumos`. O usuário irá informar no chat quais arquivos pertencem ao Veículo 1 e quais pertencem ao Veículo 2. Crie os `Records` Java 21 correspondentes à árvore do 3040.

- **Passo 2: Staging Area e Ingestão (`@agent-batch-architect` e `@agent-java-dev`)**
  Crie o schema do banco H2. Implemente o Step particionado de ingestão (via `StaxEventItemReader`) para jogar os dados crus de até 2GB para as tabelas temporárias, associando cada registro ao seu respectivo Veículo Legal.

- **Passo 3: Consolidação Paralela dos Veículos (`@agent-batch-architect` e `@agent-java-dev`)**
  Crie um `Flow` paralelo no Spring Batch. Uma thread/branch orquestrará a geração do XML do Veículo 1, enquanto a outra processa o Veículo 2 simultaneamente.

- **Passo 4: Escrita de Alta Performance**
  Implemente a leitura paginada do H2 (`JdbcPagingItemReader`) com JOINs que trazem o Cliente complexo, e escreva nos arquivos finais via `StaxEventItemWriter` de forma contínua no disco, lidando corretamente com o `headerCallback` para as raízes do Bacen.
</task_flow>
