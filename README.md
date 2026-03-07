Olá Cursor. Vamos iniciar o desenvolvimento do nosso pipeline de consolidação do Bacen 3040.

Por favor, leia e absorva todo o contexto dos arquivos na pasta .cursor/rules/, com atenção absoluta ao @00-workflow-rules.mdc e ao @skills-consolidation.mdc.

Nossa estrutura de diretórios já está criada. Para o mapeamento inicial, aqui estão as premissas:
-> Veículo Legal 1: Os arquivos de insumo de exemplo estão em src/main/resources/insumos/amostras/veiculo1/.
-> Veículo Legal 2: Os arquivos de insumo de exemplo estão em src/main/resources/insumos/amostras/veiculo2/.
-> Fonte da Verdade: O manual oficial está em docs/normativos/.

⚠️ REGRA DE OURO E PROTEÇÃO DE MEMÓRIA: É ESTRITAMENTE PROIBIDO tentar ler ou indexar qualquer arquivo fora da pasta amostras/. Os arquivos reais na raiz de insumos/veiculo1 e insumos/veiculo2 possuem até 2GB e vão travar a sua engine. Use APENAS os arquivos menores das amostras para entender o layout de origem.

Sua tarefa agora:
Assuma as personas definidas (@agent-bacen-analyst, @agent-batch-architect, @agent-java-dev) e execute exclusivamente o PASSO 0 do nosso roteiro. Analise o desafio (considerando GKE, Java 21, Spring Batch, Streaming e paralelismo de veículos) e gere o arquivo checklist.md detalhado na raiz do projeto. NÃO ESCREVA NENHUMA LINHA DE CÓDIGO JAVA AINDA. Apenas gere o checklist e me pergunte se podemos prosseguir para o Passo 1.
