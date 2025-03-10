**Insomnia: Um Cliente de API**

O Insomnia é um cliente de API popular que simplifica o teste e a depuração de APIs. Ele permite que você envie requisições HTTP (GET, POST, PUT, DELETE, etc.) e inspecione as respostas.

**Requisições GET**

As requisições GET são usadas para recuperar dados de um servidor.

**Passos no Insomnia:**

1. **Abra o Insomnia:** Inicie o aplicativo Insomnia.
2. **Crie uma Nova Requisição:**
    - Clique no botão "+" e selecione "New Request".
    - Escolha "GET" no menu suspenso de métodos.
3. **Insira a URL:**
    - No campo URL, insira o endpoint que você deseja acessar (por exemplo, `https://api.exemplo.com/usuarios`).
    - Se você precisar adicionar parâmetros de consulta, pode adicioná-los diretamente à URL (por exemplo, `https://api.exemplo.com/usuarios?id=123&nome=João`) ou usar a interface de parâmetros de consulta do Insomnia.
4. **Envie a Requisição:**
    - Clique no botão "Send".
5. **Inspecione a Resposta:**
    - O Insomnia exibirá a resposta do servidor, incluindo o código de status, os cabeçalhos e o corpo.

**Requisições POST**

As requisições POST são usadas para enviar dados a um servidor, geralmente para criar ou atualizar recursos.

**Passos no Insomnia:**

1. **Abra o Insomnia:** Inicie o aplicativo Insomnia.
2. **Crie uma Nova Requisição:**
    - Clique no botão "+" e selecione "New Request".
    - Escolha "POST" no menu suspenso de métodos.
3. **Insira a URL:**
    - No campo URL, insira o endpoint para o qual você deseja enviar dados (por exemplo, `https://api.exemplo.com/usuarios`).
4. **Defina o Corpo da Requisição:**
    - Na guia "Body", selecione o tipo de conteúdo apropriado (por exemplo, "JSON", "Form URL-Encoded", "Multipart Form").
    - Se você estiver enviando dados JSON, insira o objeto JSON na área de texto.
    - Exemplo de corpo JSON:
        
        JSON