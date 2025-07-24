# Visão Geral do Produto

**Versão**: 01.00.00  
**Data**: 15 de julho de 2025

## Introdução

O **Gatherly** é uma plataforma social global projetada para conectar pessoas através de eventos. O projeto ataca um problema comum: a dificuldade de encontrar e organizar eventos, cujas informações hoje estão fragmentadas em múltiplas redes sociais. O Gatherly surge para centralizar essas experiências, oferecendo uma ferramenta dedicada à interação social focada em acontecimentos.

## Objetivo do Produto

Conectar pessoas e fortalecer comunidades, transformando a descoberta de eventos em uma jornada social e personalizada. Nosso objetivo é ser a ferramenta que inspira os usuários a saírem de casa, explorarem seus interesses e criarem memórias significativas.

## Público-Alvo

O Gatherly atende a dois perfis de usuários principais:

- **Participantes de Eventos:** Jovens adultos (18-30 anos), nativos digitais.
    - **Dores (Problemas):** Sentem-se sobrecarregados pela quantidade de informações em diferentes apps, perdem eventos por falta de divulgação centralizada e acham difícil encontrar companhia para ir a eventos.
    - **Ganhos (Desejos):** Querem uma forma fácil de ver o que está acontecendo ao seu redor, receber sugestões alinhadas com seus gostos, e se conectar com pessoas que compartilham dos mesmos interesses.
- **Organizadores de Eventos:** Indivíduos, grupos ou pequenas empresas.
    - **Dores (Problemas):** Dificuldade em alcançar o público certo com orçamentos limitados, ferramentas de gestão de eventos existentes são caras ou complexas, e falta de canais para receber feedback direto dos participantes.
    - **Ganhos (Desejos):** Acesso a uma plataforma gratuita e de alto alcance para divulgar eventos, ferramentas simples para gerenciar inscrições e se comunicar com o público, e a capacidade de construir uma comunidade engajada em torno de suas iniciativas.

## Principais Funcionalidades

- **Gestão de Contas e Segurança:** Cadastro via e-mail ou Google, autenticação robusta (incluindo 2FA), gerenciamento de perfil e dispositivos conectados.
- **Gestão de Eventos (CRUD):** Permite que organizadores criem, divulguem, atualizem e gerenciem eventos, com descrições, datas, localização e imagens.
- **Descoberta e Filtragem de Eventos:** Mecanismo de busca avançada com filtros por localização, data, categoria e popularidade.
- **Rede Social e Feed:** Funcionalidades que formam o núcleo social da plataforma, incluindo seguir organizadores e outros usuários, e interagir em um feed de atividades com comentários.
- **Engajamento em Eventos:** Mecanismos para o usuário confirmar presença, ver quem mais vai, e gerenciar os eventos dos quais irá participar.
- **Sistema de Notificações:** Envio de notificações por e-mail e na plataforma sobre novos eventos, lembretes e atualizações.
- **Moderação de Conteúdo:** Sistema para garantir que o conteúdo gerado por usuários (eventos, comentários, fotos) seja apropriado e seguro.
- **Sistema de Recomendação:** Motor que sugere eventos de forma inteligente e personalizada, com base nos interesses, localização, histórico e interações do usuário na plataforma, facilitando a descoberta de novas experiências.

## Fora do Escopo (MVP)

Para garantir o foco na entrega de valor principal, as seguintes funcionalidades não fazem parte do escopo inicial:

- **Venda de Ingressos:** A plataforma não processará pagamentos. Eventos pagos deverão indicar um link externo para a compra.
- **Eventos Privados:** Todos os eventos criados no MVP serão públicos.
- **Integração com Calendários:** A funcionalidade de adicionar eventos diretamente ao Google Calendar, Outlook, etc., não será implementada inicialmente.

## Diferenciais Competitivos

- **Foco na Comunidade e Interação:** Diferente de simples listagens de eventos, o Gatherly é uma rede social onde a interação antes, durante e depois do evento é o pilar central.
- **Plataforma Global e Geolocalizada:** O uso intensivo de geolocalização permite uma descoberta de eventos hiperlocal, em qualquer lugar do mundo, tornando a experiência relevante para o usuário onde quer que ele esteja.
- **Conteúdo 100% Gerado pelo Usuário:** A plataforma é alimentada pela própria comunidade, garantindo uma diversidade e autenticidade de eventos que grandes portais corporativos não conseguem oferecer.
- **Inteligência de Recomendação:** Enquanto concorrentes oferecem listas genéricas, o Gatherly utiliza um motor de recomendação para criar uma experiência hiper-personalizada, conectando usuários a eventos e pessoas que eles genuinamente irão gostar. Isso aumenta o engajamento e a retenção.

## Métricas de Sucesso (KPIs)

Como este é um projeto de portfólio, as métricas focam em validar a implementação técnica e o engajamento inicial:

- **Aquisição:** Atingir 50 usuários cadastrados no primeiro mês após o deploy.
- **Engajamento:**
    - **Eventos:** Ter pelo menos 20 eventos criados e 100 confirmações de presença totais.
    - **Social:** Registrar um total de 200 interações sociais (seguidores, comentários) no primeiro mês.
- **Retenção:** Garantir que 20% dos usuários ativos em um mês retornem no mês seguinte.
- **Qualidade Técnica:** Manter a cobertura de testes unitários e de integração acima de 80%.
- **Performance:** Garantir que 95% das requisições da API tenham um tempo de resposta abaixo de 200ms.

## Tecnologias Previstas

- **Backend:** API RESTful construída com **Java 21 e Spring Boot 3**, utilizando **Maven** como gerenciador de dependências, pela robustez, ecossistema maduro e alta performance.
- **Banco de Dados:** **PostgreSQL** (via Amazon RDS), por ser um banco de dados relacional open-source poderoso, confiável e com bom suporte a dados geoespaciais (PostGIS).
- **Armazenamento de Arquivos:** **Amazon S3** para o armazenamento de imagens de perfil, banners de eventos e fotos postadas por usuários.
- **Infraestrutura:** **Amazon Web Services (AWS)**, utilizando os serviços do Free Tier:
    - **Amazon EC2** para hospedar a aplicação Spring Boot.
    - **Amazon RDS** para o banco de dados PostgreSQL.
    - **Amazon S3** para armazenamento de mídia.
    - **Amazon SES (Simple Email Service)** para o envio de e-mails transacionais (notificações, redefinição de senha).

## Ferramentas de Desenvolvimento e Gestão

- **Controle de Versão:** **GitHub**, para gerenciamento do código-fonte e versionamento.
- **CI/CD:** **GitHub Actions**, para automação de testes, build e deploy.
- **Gestão de Projeto e Documentação:** **Notion** e próprio GitHub com Markdown, para gerenciamento do backlog, ADRs e documentação geral.

## Glossário

- **Evento:** Qualquer acontecimento com data e local definidos, criado por um organizador na plataforma.
- **Organizador:** O usuário responsável pela criação e gerenciamento de um evento.
- **Participante:** O usuário que demonstra interesse ou confirma presença em um evento.
- **Feed:** Fluxo de atualizações e atividades relevantes para o usuário, como novos eventos de organizadores que ele segue.
- **MVP (Minimum Viable Product):** A versão mais simples do Gatherly que já entrega o valor principal aos usuários: a capacidade de criar e encontrar eventos.
- **Comunidade:** Um grupo de usuários conectado por interesses comuns, eventos frequentados ou por seguirem um mesmo organizador. A formação de comunidades é um objetivo central do Gatherly.

## Referências

- MARTIN, Robert C. **Arquitetura limpa**: o guia do artesão para estrutura e design de software. Rio de Janeiro: Alta Books, 2019.
- CAGAN, Marty. **Inspired**: how to create tech products customers love. 2. ed. Hoboken: John Wiley & Sons, 2018.
- RUBIN, Kenneth S. **Essential Scrum**: a practical guide to the most popular agile process. Boston: Addison-Wesley, 2013.
- EVANS, Eric. **Domain-driven design**: tackling complexity in the heart of software. Boston: Addison-Wesley, 2004.