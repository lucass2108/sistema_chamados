# 📦 Projeto: Sistema de Controle de Solicitações Internas

## 🧠 Contexto

Uma empresa de médio porte precisa de um sistema simples para **registrar, acompanhar e finalizar solicitações internas** feitas pelos funcionários.

Essas solicitações podem ser, por exemplo:

- Pedido de material (mouse, teclado, cadeira)
- Solicitação de manutenção
- Pedido de acesso a algum sistema
- Outros tipos definidos pela empresa

Atualmente isso é feito por e-mail, o que causa **perda de informações** e **falta de controle**.  
O objetivo do projeto é criar um **sistema em Java**, executado no **console**, que permita **gerenciar essas solicitações de forma organizada**.

---

## 🎯 Objetivo do Sistema

Criar um programa em Java que permita:

- Cadastrar novas solicitações
- Listar solicitações existentes
- Alterar o status de uma solicitação
- Finalizar solicitações
- Garantir regras básicas de funcionamento e validações

O sistema **não precisa usar banco de dados** — todas as informações podem ficar em memória enquanto o programa estiver rodando.

---

## ⚙️ Funcionalidades Esperadas

O sistema deve permitir ao usuário, através de um **menu no console**:

### 1️⃣ Criar uma nova solicitação

Ao criar uma solicitação, o sistema deve coletar informações como:

- Nome do solicitante
- Tipo da solicitação
- Descrição do problema ou pedido
- Data e hora da criação (gerada automaticamente)

Toda solicitação criada inicia com um **status padrão** (exemplo: aberta).

---

### 2️⃣ Listar solicitações

O sistema deve permitir:

- Listar **todas** as solicitações cadastradas
- Exibir claramente as informações principais de cada uma
- Mostrar o status atual de cada solicitação

---

### 3️⃣ Atualizar o status de uma solicitação

O usuário deve poder:

- Escolher uma solicitação pelo seu identificador
- Alterar seu status seguindo uma **sequência lógica**  
  (por exemplo: aberta → em andamento → finalizada)

O sistema **não deve permitir mudanças inválidas de status**.

---

### 4️⃣ Finalizar uma solicitação

Quando uma solicitação for finalizada:

- Ela **não pode mais ser alterada**
- Deve registrar a **data e hora da finalização**
- Deve ficar marcada como **concluída** no sistema

---

### 5️⃣ Validações e regras

O sistema deve garantir que:

- Campos obrigatórios não sejam vazios
- Não seja possível acessar uma solicitação inexistente
- Não seja possível alterar uma solicitação já finalizada
- Entradas inválidas do usuário não quebrem o programa

---

## 📌 Requisitos Técnicos

- **Linguagem:** Java
- **Interface:** Console (Scanner)
- **Paradigma:** Programação Orientada a Objetos

### Uso obrigatório de:
- `enum` para estados ou tipos
- Tratamento de exceções
- Coleções (`List`, por exemplo)
- Datas modernas (`LocalDateTime`)

### Boas práticas:
- Código organizado, legível e bem nomeado
- **Não utilizar frameworks** (Spring, Hibernate, etc.)

---

💡 *Este projeto simula um teste técnico real para vagas de estágio ou júnior, focando em lógica, organização e domínio dos fundamentos de Java.*
