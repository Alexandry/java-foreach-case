
Você está analisando um regulatório específico já tratado neste chat.

Contexto:
Neste chat já existem informações sobre este regulatório, incluindo matriz de dados necessários, áreas fornecedoras, insumos, regras, normativos, leiautes, validações e observações levantadas anteriormente.

Objetivo:
Quero que você complemente a análise fazendo um mapeamento de relacionamento deste regulatório com outros regulatórios atendidos pelo banco.

A análise deve responder três perguntas:

1. Este regulatório impacta algum outro regulatório?
2. Este regulatório precisa ser conciliado, validado ou batido contra algum outro regulatório?
3. Este regulatório serve como insumo, referência, base de validação ou base de comparação para algum outro regulatório?

Regras obrigatórias:
- NÃO invente dependências.
- NÃO invente batimentos.
- NÃO invente regras de conciliação.
- NÃO assuma que existe relação apenas porque os domínios são parecidos.
- Só considere uma relação como confirmada se houver evidência no material deste chat, em normativo, leiaute, manual, FAQ, regra de validação, crítica do órgão regulador ou observação interna registrada.
- Quando a relação parecer provável, mas não estiver comprovada, classifique como “não confirmado”.
- Quando não houver evidência suficiente, escreva explicitamente “não identificado no material analisado”.
- Diferencie claramente:
  - insumo para geração;
  - insumo para validação;
  - conciliação/batimento;
  - equivalência de classificação;
  - dependência operacional;
  - impacto indireto;
  - apenas semelhança de domínio.

Definições que devem ser usadas:

1. Insumo para geração:
Quando dados, arquivos, documentos ou informações deste regulatório são usados diretamente para gerar outro regulatório.

2. Insumo para validação:
Quando este regulatório não gera o outro, mas é usado para validar, comparar ou conferir outro regulatório.

3. Conciliação / batimento:
Quando valores, saldos, posições, quantidades, classificações ou chaves precisam fechar entre este regulatório e outro.

4. Equivalência:
Quando existe uma tabela, regra ou mapeamento oficial entre classificações, modalidades, contas, códigos ou categorias de dois regulatórios.

5. Dependência operacional:
Quando o envio, fechamento, aceite ou processamento deste regulatório depende de outro envio, arquivo, sistema ou evento regulatório.

6. Impacto indireto:
Quando uma divergência neste regulatório pode afetar análise, auditoria, questionamento, coerência ou governança de outro regulatório, mas sem evidência de batimento oficial.

Saída esperada:

## 1. Identificação do regulatório analisado

Informe:
- Nome/código do regulatório:
- Órgão regulador:
- Periodicidade, se conhecida:
- Área(s) dona(s), se conhecidas:
- Principais domínios de dados envolvidos:
- Fontes/normativos considerados neste chat:

## 2. Relacionamentos encontrados

Monte uma tabela com as colunas abaixo:

| Regulatório analisado | Regulatório relacionado | Órgão do regulatório relacionado | Tipo de relação | Direção da relação | Descrição da relação | Evidência encontrada | Nível de confiança | Observações |
|---|---|---|---|---|---|---|---|---|

Regras para preencher:

- Em “Tipo de relação”, use apenas:
  - Insumo para geração
  - Insumo para validação
  - Conciliação / batimento
  - Equivalência
  - Dependência operacional
  - Impacto indireto
  - Não identificado

- Em “Direção da relação”, use:
  - Este regulatório → Outro regulatório
  - Outro regulatório → Este regulatório
  - Relação bidirecional
  - Não identificado

- Em “Nível de confiança”, use:
  - Confirmado
  - Provável, mas não confirmado
  - Não identificado
  - Descartado

- Em “Evidência encontrada”, informe:
  - trecho do normativo;
  - regra do leiaute;
  - crítica/validação;
  - observação interna já existente no chat;
  - ou escreva “não há evidência suficiente no material analisado”.

## 3. Conciliações e batimentos

Se existirem batimentos ou conciliações, monte a tabela:

| Regulatório A | Regulatório B | O que precisa bater | Chave/campo de comparação | Tipo de divergência possível | Evidência | Status |
|---|---|---|---|---|---|---|

Regras:
- Não invente campos.
- Se a chave/campo não estiver documentada, escreva “não identificado”.
- Se o batimento for apenas uma hipótese, classifique como “provável, mas não confirmado”.
- Se não houver conciliação identificada, escreva: “Não foram identificadas conciliações formais no material analisado.”

## 4. Regulatório como insumo para outro

Monte uma tabela:

| Regulatório origem | Regulatório destino | Tipo de insumo | O que é reaproveitado | Evidência | Status |
|---|---|---|---|---|---|

Tipos de insumo permitidos:
- Arquivo regulatório
- Saldo contábil
- Classificação/modalidade
- Evento de fechamento
- Dados cadastrais
- Dados transacionais
- Dados fiscais
- Dados de risco
- Dados de posição
- Não identificado

Regras:
- Se o regulatório não servir de insumo para outro, informe explicitamente.
- Se houver apenas reaproveitamento de domínio de dados, mas não do regulatório em si, deixe isso claro.

## 5. Outros regulatórios que impactam este regulatório

Monte uma tabela:

| Regulatório origem | Este regulatório | Tipo de impacto | Descrição | Evidência | Status |
|---|---|---|---|---|---|

Use esta tabela para identificar se outro regulatório precisa existir, fechar, ser aceito ou estar consistente antes deste regulatório.

## 6. Lacunas e dúvidas

Liste tudo que não foi possível confirmar:

| Dúvida / lacuna | Por que é importante | Onde validar | Prioridade |
|---|---|---|---|

Exemplos de lacunas:
- Falta normativo oficial.
- Falta manual de críticas.
- Falta leiaute atualizado.
- Falta confirmação da área regulatória.
- Falta evidência de batimento com outro documento.
- Falta regra de equivalência entre classificações.

## 7. Conclusão objetiva

Finalize com:

- Relações confirmadas:
- Relações prováveis, mas não confirmadas:
- Relações não identificadas:
- Pontos que precisam ser validados com a área regulatória:
- Risco de assumir dependência sem evidência:

Importante:
Se não houver evidência suficiente para qualquer relacionamento, não tente completar por inferência. Prefira uma resposta incompleta, mas correta, do que uma matriz cheia de relações não comprovadas.
