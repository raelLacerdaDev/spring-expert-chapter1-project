# 🧪 Spring Boot - Masterclass de Testes e Funcionalidades Avançadas

Este repositório contém a implementação de um projeto Spring Boot focado profundamente em **Testes Automatizados (Unidade, Integração e API)**, aplicando as melhores práticas de desenvolvimento, TDD, cobertura de código com Jacoco e testes de API com RestAssured. 

Além do ecossistema de testes, o projeto aborda tópicos essenciais para APIs robustas, como Segurança (OAuth2/JWT), Validação Customizada, Envio de E-mails e Otimização de Consultas (N+1).

---

## 🚀 Tecnologias e Ferramentas

- **Kotlin & Spring Boot**
- **Testes:** JUnit 5, Mockito, RestAssured, Spring MockMvc
- **Cobertura de Código:** Jacoco
- **Segurança:** Spring Security, OAuth2, JWT
- **Banco de Dados:** ORM (JPA/Hibernate), Seed de Dados
- **Outros:** Bean Validation, JavaMailSender (SMTP Gmail)

---

## 📚 Conteúdo do Projeto e Tópicos Abordados

### 1. Fundamentos de Testes e JUnit
- **Conceitos:** Benefícios dos testes automatizados e introdução ao **TDD** (Test-Driven Development).
- **Boas Práticas:** Padrões para elaboração e estruturação de testes.
- **JUnit Vanilla:** Implementação de testes Java puros (*vanilla*) com JUnit 5.
- **Design Patterns:** Uso do padrão **Factory** para instanciar e preparar objetos nos testes.
- **Ciclo de Vida:** Utilização de Fixtures com a anotação `@BeforeEach`.
- **Prática:** Resolução de exercícios práticos focados em testes isolados.

### 2. Testes com Spring e Camada de Acesso a Dados (Repository)
- **Anotações:** Uso das principais *annotations* de teste do ecossistema Spring.
- **Camada de Dados:** Implementação e configuração de testes de **Repository**.
- **Prática:** Exercícios práticos focados em consultas e persistência de dados.

### 3. Testes de Unidade na Camada Service (Mockito)
- **Mockito vs MockBean:** Diferenças estruturais, de contexto e cenários de uso de cada um.
- **Implementação:** Testes de unidade da camada Service com total isolamento.
- **Clean Code:** Utilização de *imports estáticos* do Mockito para melhorar a legibilidade.
- **Comportamentos:** Simulação de diversos cenários (retornos esperados, lançamento de exceções, verificação de número de chamadas).
- **Prática:** Exercício de testes de unidade aplicando o Mockito.

### 4. Testes na Camada Web e Integração
- **MockMvc:** Testes na camada Web (Controllers).
- **Design de API:** Foco em legibilidade e negociação de conteúdo (JSON, HTTP Status).
- **Testes de Integração:** Implementação de testes envolvendo o contexto do Spring para rotas Web.
- **Prática:** Exercícios na camada web e implementação completa do desafio TDD resolvido.

### 5. Domínio, Validação e Tratamento de Erros
- **Modelagem:** Implementação das entidades `User` e `Role`, mapeamento ORM e seed de banco de dados.
- **Bean Validation:** Introdução e anotações básicas de validação.
- **Tratamento de Exceções:** Captura global da `MethodArgumentNotValidException`.
- **Respostas Customizadas:** Padronização do payload de erro de validação.
- **Validação Avançada:** Implementação de um `ConstraintValidator` customizado.

### 6. Segurança (Spring Security)
- **Autenticação:** Inclusão de segurança no projeto base.
- **Tokens:** Configuração e emissão de tokens com **OAuth2 e JWT**.
- **Autorização:** Pré-autorização de métodos nos Controllers com base no perfil do usuário (`Role`).

### 7. Casos de Uso, Otimização e CORS
- **Consultas Complexas:** Consulta detalhada de produtos.
- **Performance:** Identificação e solução do problema de **N+1 consultas**.
- **Paginação:** Busca paginada eficiente utilizando SQL padrão.
- **Manutenção de Testes:** Correção e adaptação dos testes automatizados após refatorações no banco.
- **CORS:** Configuração de Cross-Origin Resource Sharing.
- **Casos de Uso Principais:**
  - Fluxo de **Signup** (cadastro de novo usuário).
  - Obtenção do usuário logado no contexto da requisição.
  - Envio de e-mail transacional via SMTP do Gmail.
  - Fluxo completo de recuperação de senha.

### 8. Cobertura de Código com Jacoco
- **Setup:** Configuração do Jacoco no projeto Spring Boot.
- **Escopo:** Seleção e exclusão de pacotes alvo para cobertura.
- **Técnica:** Análise de fluxos de cobertura e testes de caixa branca.
- **Mocks Avançados:** Mock de dependências com Mockito, com ênfase especial na simulação de contextos de segurança.
- **Métricas:** Geração e leitura do relatório de cobertura HTML.

### 9. Testes de API com RestAssured
- **Integração:** Setup do Spring Boot em conjunto com RestAssured.
- **Sintaxe BDD:** Explorando a *Domain-Specific Language (DSL)* do RestAssured (`Given`, `When`, `Then`).
- **Análise Prática:** Implementação e estruturação de testes E2E de API.
- **Estado do Banco:** Considerações sobre os testes de integração e a recomposição (seed) da base de dados.
- **Comparativo:** O paralelo definitivo entre `MockMvc` vs `RestAssured`.

---

## ⚙️ Como Executar o Projeto

1. Clone o repositório:
   ```bash
   git clone [https://github.com/seu-usuario/seu-repositorio.git](https://github.com/seu-usuario/seu-repositorio.git)
