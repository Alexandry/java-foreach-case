---
description: Regras globais de tecnologia, infraestrutura e escopo para o Consolidador Bacen 3040
globs: *.java, *.xml, pom.xml, application.yml, infra.yml
---
<context>
- Este projeto consolida o Cadoc 3040 (SCR) do Banco Central.
- ZERO validações de negócio nesta fase. Foco apenas em agrupamento e geração estrutural.
- MÚLTIPLOS VEÍCULOS LEGAIS: O sistema deve gerar DOIS (2) arquivos XML finais separados, um para cada CNPJ base (Veículo 1 e Veículo 2). O mapeamento de quais arquivos de origem pertencem a qual veículo será fornecido pelo usuário.
</context>

<infrastructure_and_volume>
- Volumetria Extrema: Arquivos de origem variam de 100KB a 2GB. Os arquivos finais (XML) terão entre 1.5GB e 2.5GB, com tendência de crescimento contínuo.
- Infraestrutura: A aplicação roda em Kubernetes (GKE). O arquivo `infra.yml` define os *limits* e *requests* de CPU e Memória (RAM é finita e restrita).
- Restrição Arquitetural: É EXTREMAMENTE PROIBIDO carregar a árvore inteira do XML na memória (DOM). O processamento deve ser 100% via Streaming/Chunks.
</infrastructure_and_volume>

<tech_stack>
- Java 21 (Records, Pattern Matching).
- Spring Boot 3.x e Spring Batch 5.2.3.
- Banco em Memória/Staging: H2.
- Mapeamento XML: Jackson Dataformat XML (otimizado para leitura em streaming de fragmentos).
</tech_stack>
