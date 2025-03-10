## Principais Anotações Spring

### 1. Anotações de Componente

- **@Component:** Marca uma classe como um componente Spring, permitindo que ela seja detectada e gerenciada pelo contêiner Spring.
- **@Service:** Especialização de @Component para classes que contêm lógica de negócios.
- **@Repository:** Especialização de @Component para classes que acessam dados (por exemplo, repositórios de banco de dados).
- **@Controller:** Especialização de @Component para classes que lidam com solicitações HTTP (controladores web).
- **@RestController:** Combinação de @Controller e @ResponseBody, simplificando a criação de APIs RESTful.
- **@Configuration:** Indica que uma classe contém definições de beans (@Bean).

### 2. Anotações de Injeção de Dependência

- **@Autowired:** Injeta automaticamente dependências em um componente Spring.
- **@Qualifier:** Especifica qual bean deve ser injetado quando há várias opções disponíveis.
- **@Value:** Injeta valores de propriedades em um componente Spring.

### 3. Anotações de Mapeamento Web

- **@RequestMapping:** Mapeia solicitações HTTP para métodos de controlador.
- **@GetMapping:** Mapeia solicitações HTTP GET.
- **@PostMapping:** Mapeia solicitações HTTP POST.
- **@PutMapping:** Mapeia solicitações HTTP PUT.
- **@DeleteMapping:** Mapeia solicitações HTTP DELETE.
- **@PathVariable:** Extrai valores de variáveis de caminho de URL.
- **@RequestParam:** Extrai valores de parâmetros de consulta.
- **@RequestBody:** Extrai o corpo da solicitação HTTP.

### 4. Anotações de Gerenciamento de Dados

- **@Entity:** Marca uma classe como uma entidade JPA (Java Persistence API).
- **@Id:** Marca um campo como a chave primária de uma entidade JPA.
- **@GeneratedValue:** Especifica como a chave primária de uma entidade JPA é gerada.
- **@Transactional:** Define um método ou classe como transacional.

### 5. Anotações do Spring Boot

- **@SpringBootApplication:** Combinação de @Configuration, @EnableAutoConfiguration e @ComponentScan, simplificando a configuração de aplicativos Spring Boot.

### 6. Anotações de Validação ([[Bean Validation]])

- **@Valid:** Valida um objeto.
- **@NotNull:** Garante que um campo não seja nulo.
- **@Size:** Garante que um campo tenha um tamanho específico.
- **@Email:** Garante que um campo seja um endereço de e-mail válido.

### 7. Anotações do [[Flyway]]

- **@Configuration:** Indica que uma classe contém definições de beans (@Bean).
- **@Bean:** Indica que um método produz um bean gerenciado pelo contêiner Spring.

## Benefícios das Anotações Spring

- **Redução da configuração XML:** As anotações eliminam a necessidade de arquivos de configuração XML complexos.
- **Maior legibilidade do código:** As anotações tornam o código mais conciso e fácil de entender.
- **Melhor organização do código:** As anotações ajudam a organizar o código em componentes lógicos.
- **Maior produtividade:** As anotações simplificam o desenvolvimento de aplicativos Spring.