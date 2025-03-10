#### **MANUAL RAPIDO PASSO A PASSO PARA CRIACAO DE UM PROJETO UTILIZANDO SPRING INITIALIZR**

**1. Acesse o Spring Initializr:**

- Vá para o site do Spring Initializr: [start.spring.io](https://www.google.com/url?sa=E&source=gmail&q=https://start.spring.io/).

**2. Configure o Projeto:**

- **Project:** Escolha "Maven" ou "Gradle" como seu sistema de construção preferido.
- **Language:** Selecione "Java".
- **Spring Boot:** Escolha a versão mais recente e estável do Spring Boot.
- **Project Metadata:**
    - Preencha o "Group" (ex: com.example).
    - Preencha o "Artifact" (ex: minha-aplicacao).
    - Você pode ajustar o "Name", "Description" e "Package name" conforme necessário.
    - **Packaging:** Selecione "Jar".
    - **Java:** Escolha a versão do Java que você está usando.

**3. Adicione Dependências:**

- Clique em "Add dependencies...".
- Pesquise e selecione as dependências necessárias para o seu projeto. Algumas dependências comuns incluem:
    - "Spring Web": Para criar aplicativos web.
    - "Spring Data JPA": Para trabalhar com bancos de dados.
    - "Flyway Migration": Para realizar o versionamento do Banco de dados.
- Clique em "Add".

**4. Gere o Projeto:**

- Clique em "GENERATE".
- Um arquivo ZIP será baixado.
- Extraia o arquivo ZIP para um diretório no seu computador.

**5. Importe o Projeto:**

- Importe o projeto como um projeto Maven ou Gradle a depender da escolha realizada dentro do spring start

**6. Execute o Aplicativo:**

- Sua IDE deverá ter criado um arquivo com o nome da sua aplicação, e com a anotação "@SpringBootApplication", execute este arquivo.
- O Spring Boot iniciará o aplicativo.
- Você pode verificar se o aplicativo está em execução acessando `http://localhost:8080` no seu navegador.