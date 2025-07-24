# Product Backlog

**Versão**: 01.00.00  
**Data**: 23 de julho de 2025

## Introdução

Este documento representa o Product Backlog do projeto Gatherly. Ele é um artefato vivo, uma lista ordenada de funcionalidades, melhorias e correções, e serve como a única fonte da verdade para o trabalho a ser realizado. A priorização (ordenação) dos itens é feita pelo Product Owner para garantir que o desenvolvimento sempre maximize o valor entregue ao usuário final.

## Epics

Os Épicos são as grandes funcionalidades do Gatherly, derivados dos nossos Casos de Uso. Eles serão quebrados em Features e Histórias de Usuário menores. A ordem aqui representa a prioridade inicial para o desenvolvimento do MVP.

| ID     | Epic                                   | Status        |
|--------|----------------------------------------|---------------|
| EP-001 | Gestão de Contas e Segurança           | Não Iniciado  |
| EP-002 | Descoberta de Eventos                  | Não Iniciado  |
| EP-003 | Gestão de Eventos (para Organizadores) | Não Iniciado  |
| EP-004 | Engajamento e Interação Social         | Não Iniciado  |
| EP-005 | Sistema de Avaliações e Gamificação    | Não Iniciado  |
| EP-006 | Moderação e Confiança                  | Não Iniciado  |
| EP-007 | Sistema de Notificação                 | Não Iniciado  |
| EP-008 | Inteligência e Personalização          | Não Iniciado  |
| EP-009 | Painel do Organizador (Analytics)      | Não Iniciado  |
| EP-010 | Administração do Sistema               | Não Iniciado  |

## Features

| ID     | Feature                                | Epic   | Status        |
|--------|----------------------------------------|--------|---------------|
| FT-001 | Cadastro de Usuário com E-mail e Senha | EP-001 | Não Iniciado  |
| FT-002 | Autenticação Padrão                    | EP-001 | Não Iniciado  |
| FT-003 | Verificação de E-mail                  | EP-001 | Não Iniciado  |
| FT-004 | Autenticação Social com Google         | EP-001 | Não Iniciado  |
| FT-005 | Fluxo de Recuperação de Senha          | EP-001 | Não Iniciado  |
| FT-006 | Gerenciamento Básico de Perfil         | EP-001 | Não Iniciado  |
| FT-005 | Segurança Avançada da Conta            | EP-001 | Não Iniciado  |

## Histórias de Usuários

| ID     | História de Usuário                    | Prioridade | Feature  | Status        |
|--------|----------------------------------------|------------|----------|---------------|
| US-001 | Como um visitante não cadastrado, quero criar uma nova conta na plataforma usando meu nome, e-mail e uma senha segura, para que eu possa acessar as funcionalidades exclusivas para membros, como confirmar presença em eventos e interagir com a comunidade. | Critica    | FT-001   | Não Iniciado  |
| US-003 | Como um desenvolvedor de frontend quero ter um endpoint para verificar se um e-mail já está em uso sem ter que submeter o formulário de cadastro inteiro, para que eu possa dar um feedback instantâneo ao usuário final, melhorando a experiência de cadastro. | Critica    | FT-001   | Não Iniciado  |
| US-004 | Como um visitante quero escolher um apelido único durante o meu cadastro, para que eu tenha uma identidade personalizada e fácil de compartilhar na plataforma. | Critica    | FT-001   | Não Iniciado  |
| US-002 | Como um visitante, quero ver um link para os “Termos de Serviço” e Política de Privacidade” e precisar marcar uma caixa de aceite, para que eu saiba como meus dados serão usados e possa me cadastrar com segurança e confiança. | Baixa      | FT-001   | Não Iniciado  |

## Histórias Técnicas

| ID     | História Técnica                       | Prioridade | Feature | Status        |
|--------|----------------------------------------|------------|---------|---------------|
| US-001 | Implementar Rate Limiting no endpoint de cadastro | Média      | FT-001  | Não Iniciado  |

## Prioridade

## Bugs

## Spike

## Melhorias
