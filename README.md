# ✨ Gatherly API

_Uma plataforma social global projetada para conectar pessoas através de eventos._

O **Gatherly** é uma API RESTful robusta que serve como backend para uma rede social de eventos. O projeto resolve um problema recorrente: a dificuldade de encontrar e organizar eventos, cujas informações estão atualmente dispersas entre várias redes sociais. O Gatherly surge para centralizar essas experiências, oferecendo uma ferramenta dedicada à interação social focada em acontecimentos.

## 📚 Tabela de Conteúdos

- [Visão Geral do Projeto](#-visão-geral-do-projeto)
- [Funcionalidades](#-funcionalidades)
- [Arquitetura e Tecnologias](#-arquitetura-e-tecnologias)
- [Como Executar o Projeto Localmente](#-como-executar-o-projeto-localmente)
- [Estrutura do Projeto](#-estrutura-do-projeto)
- [Documentação da API](#-documentação-da-api)
- [Licença](#-licença)

## 🎯 Visão Geral do Projeto

O objetivo do Gatherly é ser a ferramenta que inspira os usuários a explorarem seus interesses e criarem memórias significativas, conectando pessoas e fortalecendo comunidades através de uma jornada social e personalizada. Este repositório contém exclusivamente a API backend, construída com as melhores práticas de Engenharia de Software para garantir segurança, escalabilidade e manutenibilidade.

## 🚀 Funcionalidades

A API do Gatherly oferece um conjunto rico de funcionalidades, divididas pelos papéis dos usuários:

### Visitante (Não Autenticado)

- Visualizar eventos em destaque.
- Buscar e filtrar eventos por múltiplos critérios (data, local, categoria).
- Visualizar detalhes de eventos públicos e seus comentários.

### Usuário Cadastrado

- **Gestão de Conta:** Cadastro, login (e-mail/senha e Google), edição de perfil, alteração de senha, configuração de 2FA e gerenciamento de dispositivos.
- **Engajamento Social:** Seguir perfis, interagir por comentários e favoritar eventos.
- **Presença e Participação:** Confirmar/desmarcar presença e visualizar participantes.
- **Gamificação:** Receber e visualizar badges por conquistas na plataforma.
- **Segurança:** Denunciar eventos e comentários impróprios.
- **Reviews:** Avaliar e deixar reviews para eventos que participou.

### Organizador

- CRUD completo de eventos (criar, editar, cancelar).
- Gerenciar mídias (fotos, banners) de seus eventos.
- Acessar um painel com análises sobre o engajamento de seus eventos.

### Moderador & Admin

- Painel para visualizar e moderar conteúdos denunciados.
- Ferramentas administrativas para gerenciamento de usuários e papéis.

## 🏗️ Arquitetura e Tecnologias

O projeto adota a **Arquitetura Hexagonal (Ports and Adapters)**, promovendo baixo acoplamento e alta testabilidade do núcleo de regras de negócio.

As principais tecnologias utilizadas são:

- **Linguagem:** Java 21
- **Framework:** Spring Boot 3
- **Segurança:** Spring Security 6 (com JWT e OAuth2)
- **Persistência:** Spring Data JPA / Hibernate
- **Banco de Dados:** PostgreSQL
- **Build:** Apache Maven
- **Testes:** JUnit 5, Mockito e Testcontainers
- **Serviços AWS:** S3 (armazenamento de arquivos) e SES (envio de e-mails)

## 💻 Como Executar o Projeto Localmente

### Pré-requisitos

- JDK 21
- Apache Maven 3.8+
- Cliente PostgreSQL (ex: DBeaver, pgAdmin)
- Instância do PostgreSQL rodando localmente

### Instalação e Configuração

1. **Clone o repositório:**

```bash
git clone https://github.com/barbaraguarino/gatherly-api.git
cd gatherly-api
```

2. **Criação do Banco de Dados:**

Acesse seu cliente PostgreSQL (como pgAdmin ou DBeaver), conecte-se à instância local e crie um banco de dados com o seguinte comando:

```sql
CREATE DATABASE nome_da_base_de_dados;
```

3. **Configuração do Properties:**

```properties
# src/main/resources/application.properties
DB_URL=jdbc:postgresql://localhost:5432/nome_da_base_de_dados
DB_USERNAME=seu_usuario_postgres
DB_PASSWORD=sua_senha_postgres

JWT_SECRET=seu_segredo_super_secreto_aqui

AWS_ACCESS_KEY_ID=sua_chave_de_acesso_aws
AWS_SECRET_ACCESS_KEY=sua_chave_secreta_aws
AWS_REGION=sua_regiao_aws
S3_BUCKET_NAME=seu_bucket_s3
```

4. **Instale as dependências do projeto:**

```bash
mvn clean install
```

### Executando a Aplicação

Para iniciar a API:

```bash
mvn spring-boot:run
```

A API estará disponível em: `http://localhost:8080`

## ✅ Testes

Para rodar os testes automatizados (unitários e de integração):

```bash
mvn test
```

## 📂 Estrutura do Projeto

A estrutura do projeto segue a **Arquitetura Hexagonal**, com os principais diretórios em `src/main/java`:

- `domain`: Entidades e regras de negócio puras.
- `application`: Casos de uso e interfaces (portas) de entrada e saída.
- `infrastructure`: Adaptadores externos (controllers, repositórios, serviços AWS, etc).

```text
com.guarino
└── gatherly
    ├── domain
    │   ├── model
    │   │   // Ex: User.java, Event.java
    │   └── exception
    │       // Ex: UserNotFoundException.java
    ├── application
    │   ├── port
    │   │   ├── in  // Interfaces dos Casos de Uso
    │   │   │   // Ex: RegisterUserUseCase.java
    │   │   └── out // Interfaces para a Infraestrutura
    │   │       // Ex: UserRepositoryPort.java
    │   └── service // Implementações dos Casos de Uso
    │       // Ex: RegisterUserService.java
    └── infrastructure
        ├── config
        │   // Ex: SecurityConfig.java, BeanConfig.java
        ├── web
        │   ├── controller
        │   │   // Ex: AuthController.java
        │   ├── dto
        │   │   ├── request
        │   │   │   // Ex: RegisterUserRequest.java
        │   │   └── response
        │   │       // Ex: UserResponse.java
        │   └── mapper
        │       // Ex: UserMapper.java
        └── persistence
            ├── entity
            │   // Ex: UserEntity.java
            ├── repository
            │   // A interface do Spring Data JPA: UserJpaRepository.java
            └── adapter
                // Implementação da porta: UserRepositoryAdapter.java
```

## 📖 Documentação da API

Este projeto utiliza documentação manual em formato Markdown, mantida versionada junto ao código, garantindo que evolua junto ao projeto.

➡️ **A documentação completa de todos os endpoints, com exemplos de requisições, respostas e códigos de erro, está disponível no diretório: [`/docs/api`](./docs/api).**

## 📜 Licença

Este projeto está licenciado sob os termos da [Licença MIT](./LICENSE).