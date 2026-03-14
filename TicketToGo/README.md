# 🎫 TicketToGo - Sistema de Chamados

Sistema completo de gerenciamento de chamados desenvolvido com **Java + Spring Boot** no backend e **HTML, CSS, JavaScript (jQuery)** no frontend.

O projeto simula um sistema de help desk utilizado em empresas para registrar e acompanhar solicitações de suporte técnico.

Este projeto foi desenvolvido com foco em **boas práticas de API REST, organização de código e integração frontend/backend**, servindo como projeto de portfólio para vagas de **Desenvolvedor Java Júnior**.

---

# 🚀 Demonstração do Projeto

O sistema permite:

✔ Criar novos chamados  
✔ Listar chamados cadastrados  
✔ Atualizar status dos chamados  
✔ Filtrar chamados por status  
✔ Buscar chamados pelo nome do solicitante  
✔ Visualizar estatísticas de chamados

Status disponíveis:

- Recebido
- Em andamento
- Concluído

---

# 🧠 Arquitetura do Projeto

O projeto segue a arquitetura tradicional de aplicações Spring:


Controller
↓
Service
↓
Repository
↓
Database (H2)


### Camadas

**Controller**

Responsável por expor os endpoints da API REST.


ChamadoController


**Service**

Contém a lógica de negócio da aplicação.


ChamadoService


**Repository**

Responsável pelo acesso ao banco de dados usando Spring Data JPA.


ChamadoRepository


**Model**

Representação da entidade persistida no banco.


Chamado


---

# 🛠️ Tecnologias Utilizadas

## Backend

- Java 21
- Spring Boot
- Spring Data JPA
- Hibernate
- H2 Database
- Maven

## Frontend

- HTML5
- CSS3
- JavaScript
- jQuery
- Font Awesome

---

# 📡 API REST

Base URL


http://localhost:8080/api/chamados


---

## 📥 Listar Chamados


GET /api/chamados


Resposta

```json
[
  {
    "id": 1,
    "solicitante": "Carlos Mendes",
    "categoria": "Hardware",
    "titulo": "Impressora offline",
    "descricao": "Impressora do setor financeiro não responde",
    "status": "recebido"
  }
]
➕ Criar Chamado
POST /api/chamados

Body

{
  "solicitante": "João",
  "categoria": "Software",
  "titulo": "Erro no sistema",
  "descricao": "Sistema não abre",
  "status": "recebido"
}
🔄 Atualizar Status
PUT /api/chamados/{id}/status

Body

{
  "status": "andamento"
}

Status possíveis

recebido
andamento
concluido
💾 Banco de Dados

O projeto utiliza H2 Database em memória, ideal para testes e desenvolvimento.

Console do banco:

http://localhost:8080/h2-console

Credenciais:

JDBC URL: jdbc:h2:mem:tickettogo
User: sa
Password: (vazio)
🎨 Interface do Sistema

O frontend foi desenvolvido utilizando:

Layout moderno

Glassmorphism

Animações CSS

Interface responsiva

Dashboard com estatísticas

O sistema se comunica com a API utilizando AJAX via jQuery.

▶️ Como Executar o Projeto
1️⃣ Clonar repositório
git clone https://github.com/seuusuario/TicketToGo.git
2️⃣ Entrar na pasta
cd TicketToGo
3️⃣ Rodar o projeto
mvn spring-boot:run
4️⃣ Acessar aplicação

Frontend

http://localhost:8080

Console do banco

http://localhost:8080/h2-console
📂 Estrutura do Projeto
TicketToGo
│
├── controller
│     ChamadoController.java
│
├── service
│     ChamadoService.java
│
├── repository
│     ChamadoRepository.java
│
├── model
│     Chamado.java
│
├── resources
│     application.properties
│     static
│         index.html
│
└── TicketToGoApplication.java
👨‍💻 Autor

Wally Ferreira

Analista de Sistemas com foco em desenvolvimento Java e aplicações web.

Interesses:

Backend Java

APIs REST

Spring Boot

Desenvolvimento Web

📌 Objetivo do Projeto

Este projeto foi criado com o objetivo de:

Praticar desenvolvimento backend com Java

Construir APIs REST com Spring Boot

Integrar frontend com backend

Demonstrar habilidades técnicas para recrutadores

⭐ Melhorias Futuras

Autenticação com Spring Security

Banco PostgreSQL

Paginação de chamados

Dockerização

Deploy em nuvem
