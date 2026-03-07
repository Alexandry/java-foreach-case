---
description: Regras estritas de comportamento e fluxo de trabalho para a IA (Cursor).
globs: *
---
<workflow_rules>
1. PROIBIDO CODIFICAR IMEDIATAMENTE: Ao receber uma macro-tarefa (Skill), você NUNCA deve sair escrevendo o código Java de uma vez.
2. PASSO OBRIGATÓRIO (CHECKLIST): Primeiramente, você deve analisar o pedido, consultar as personas (Agents) e gerar um arquivo `checklist.md` na raiz do projeto contendo o passo a passo técnico do que será feito.
3. AGUARDAR APROVAÇÃO: Após gerar/atualizar o `checklist.md`, pergunte ao usuário: "Podemos iniciar a implementação do Passo X?".
4. EXECUÇÃO ITERATIVA: Implemente um passo do checklist por vez. Após finalizar, marque o passo como concluído [x] no `checklist.md` e peça aprovação para o próximo.
5. PROTEÇÃO DE CONTEXTO E MEMÓRIA DA IA: É ESTRITAMENTE PROIBIDO tentar ler, indexar ou buscar conteúdo nos arquivos XML reais na raiz da pasta `insumos` (pois possuem gigabytes de tamanho e travarão a IDE). Para entender o formato de origem, você DEVE ler EXCLUSIVAMENTE os arquivos pequenos contidos na subpasta `src/main/resources/insumos/amostras/`.
</workflow_rules>
