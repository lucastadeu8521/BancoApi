**1. Migração de banco de dados:**
-  Em resumo simplificado, uma migration tem a funcao de versionar e gerencias as mudancas do banco de dados de uma aplicacao de modo automatico, ou seja, sem que voce deva ir no banco e execute comandos sql para cada alteracao, dessa forma tudo fica guardado e documentando permitindo o rollback em caso de necessidade alem de ficar disponivel para ser auditado no futuro 

- **Definição:**
    - Refere-se ao processo de gerenciar e versionar as mudanças no esquema do banco de dados de uma aplicação.
    - Permite que você evolua a estrutura do banco de dados de forma controlada e consistente, acompanhando as alterações no código da aplicação.
    - Ferramentas como o Flyway e o Liquibase são comumente usadas para automatizar esse processo.
- **Importância:**
    - Facilita a colaboração entre desenvolvedores, garantindo que todos trabalhem com a mesma versão do banco de dados.
    - Simplifica a implantação de novas versões da aplicação, pois as mudanças no banco de dados são aplicadas automaticamente.
    - Permite reverter alterações no banco de dados, caso necessário.

**2. Migration de versão do Spring Boot:**

- **Definição:**
    - Refere-se ao processo de atualizar a versão do framework Spring Boot utilizado em uma aplicação.
    - Pode envolver a atualização de dependências, a adaptação do código para novas versões da API e a migração para novas funcionalidades do framework.
- **Importância:**
    - Permite que a aplicação utilize as últimas funcionalidades e melhorias de desempenho do Spring Boot.
    - Garante a compatibilidade com outras bibliotecas e frameworks utilizados na aplicação.
    - Corrige vulnerabilidades de segurança e bugs presentes em versões anteriores do Spring Boot.
- **Biblioteca utilizada ([[Flyway]]):**
	- Flyway é uma ferramenta de migração de banco de dados de código aberto que simplifica o gerenciamento de alterações de esquema de banco de dados. Ele permite que desenvolvedores versionem seu banco de dados da mesma forma que versionam seu código de aplicativo.

