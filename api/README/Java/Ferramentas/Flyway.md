Flyway é uma ferramenta de migração de banco de dados de código aberto que simplifica o gerenciamento de alterações de esquema de banco de dados. Ele permite que desenvolvedores versionem seu banco de dados da mesma forma que versionam seu código de aplicativo. 


### **Principais Características e Benefícios:**

- **Automação:**
    - Flyway automatiza o processo de aplicação de migrações, reduzindo o risco de erros humanos.
    - As migrações podem ser aplicadas automaticamente na inicialização do aplicativo.
- **Histórico de Migração:**
    - Flyway mantém um histórico de todas as migrações aplicadas, permitindo que você rastreie as alterações do banco de dados ao longo do tempo.
    - Isso é feito através de uma tabela criada no banco de dados, onde ele armazena quais scripts já foram executados.
- **Suporte a Múltiplos Bancos de Dados:**
    - Flyway suporta uma ampla variedade de sistemas de gerenciamento de banco de dados relacionais (RDBMS), incluindo MySQL, PostgreSQL, Oracle, SQL Server e muitos outros.

**Como o Flyway Funciona:**

- Os scripts de migração são armazenados em um diretório específico (por exemplo, `src/main/resources/db/migration`). -- **ESTE PADRAO SE REPETE PARA QUALQUER APLICACAO SPRING**
- Cada script de migração recebe um número de versão exclusivo.
- Quando o aplicativo é iniciado, o Flyway verifica o histórico de migração no banco de dados.
- Ele aplica todos os scripts de migração que ainda não foram aplicados, na ordem de seus números de versão.

**Integração com Spring Boot:**

- Spring Boot fornece suporte **integrado** para Flyway.
- Ao adicionar a dependência Flyway ao seu projeto, Spring Boot configurará automaticamente o Flyway.
- Você pode configurar o Flyway usando as propriedades do Spring Boot.


### **Como sao nomeados os arquivos no flyway???**


**1. Convenção de Nomenclatura:**

- Os arquivos de migração do Flyway seguem um padrão de nomenclatura que permite ao Flyway identificar e ordenar as migrações.
- O formato básico é: `V<versão>__<descrição>.sql`.
    - `V`: Indica que é uma migração versionada.
    - `<versão>`: Um número de versão que define a ordem de execução das migrações (ex: V1, V2, V1.1, V1.2.3).
    - `__`: Dois underscores separando a versão da descrição.
    - `<descrição>`: Uma descrição textual da migração (ex: create_users_table).
    - `.sql`: A extensão do arquivo, indicando que é um script SQL.
- Exemplo: `V1__create_users_table.sql`, `V2__add_email_column.sql`.

**2. Ordem de Execução:**

- O Flyway executa as migrações em ordem crescente de número de versão.
- Isso garante que as alterações no banco de dados sejam aplicadas na sequência correta.
- Se você adicionar uma nova migração com um número de versão mais alto, o Flyway a executará após as migrações anteriores.

**3. Tabela de Histórico:**

- O Flyway mantém uma tabela de histórico no banco de dados (por padrão, chamada `flyway_schema_history`).
- Essa tabela registra quais migrações foram aplicadas e seus resultados.
- Quando o Flyway é executado, ele verifica essa tabela para determinar quais migrações precisam ser aplicadas.

**4. Processo de Migração:**

- Na inicialização da aplicação, o Flyway verifica a tabela de histórico.
- Ele compara a lista de migrações disponíveis com as migrações já aplicadas.
- As migrações que ainda não foram aplicadas são executadas na ordem de versão.
- Após a execução de uma migração, o Flyway atualiza a tabela de histórico.

**5. Migrações Repetíveis:**

- Além das migrações versionadas, o Flyway também suporta migrações repetíveis.
- Essas migrações são identificadas pelo prefixo `R` em vez de `V`.
- As migrações repetíveis são executadas toda vez que o Flyway é executado, se o conteúdo do arquivo tiver mudado.
- Elas são úteis para scripts que precisam ser executados repetidamente, como a criação de funções ou procedures.