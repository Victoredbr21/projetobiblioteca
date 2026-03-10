# 📚 LiterAlura

![Java](https://img.shields.io/badge/Java-17-orange?style=for-the-badge&logo=java)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?style=for-the-badge&logo=springboot)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-16-blue?style=for-the-badge&logo=postgresql)
![Status](https://img.shields.io/badge/Status-Concluído-success?style=for-the-badge)

> Catálogo de livros interativo via terminal, com integração à API Gutendex e persistência em banco de dados PostgreSQL.

---

## 📖 Sobre o Projeto

O **LiterAlura** é um desafio do programa **Oracle Next Education (ONE)** em parceria com a **Alura**. A aplicação permite ao usuário buscar livros pelo título através da [API Gutendex](https://gutendex.com/), salvar os dados no banco de dados e realizar diversas consultas sobre os livros e autores cadastrados.

---

## ⚙️ Funcionalidades

- 🔍 **Buscar livro pelo título** — consulta a API Gutendex e salva o livro e seu autor no banco
- 📋 **Listar todos os livros cadastrados** — exibe todos os livros salvos no banco de dados
- 🌍 **Listar livros por idioma** — filtra livros por idioma (en, pt, fr, es)
- 🧑‍💼 **Listar autores vivos em determinado ano** — consulta autores que estavam vivos em um ano específico

---

## 🛠️ Tecnologias Utilizadas

| Tecnologia      | Versão |
|-----------------|---|
| Java            | 17 |
| Spring Boot     | 3.x |
| Spring Data JPA | 3.x |
| PostgreSQL      | 16 |
| Hibernate       | 6.x |
| Jackson (JSON)  | 2.x |
| Gradle          | 3.x |

---

## 🗂️ Estrutura do Projeto
```
src/main/java/br/com/victorliteralura/literalura/
├── api/
│ └── ApiService.java # Integração com a API Gutendex
├── entity/
│ ├── Livro.java # Entidade Livro (tabela livros)
│ └── Autor.java # Entidade Autor (tabela autores)
├── model/
│ ├── DadosLivro.java # DTO de livro do JSON
│ ├── DadosAutor.java # DTO de autor do JSON
│ └── ResultadoBusca.java # DTO do resultado da API
├── principal/
│ └── Principal.java # Menu interativo via terminal
├── repository/
│ ├── LivroRepository.java # Repositório JPA de livros
│ └── AutorRepository.java # Repositório JPA de autores
└── LiteraluraApplication.java # Classe principal
...
```
---

## 🚀 Como Executar

### Pré-requisitos

- Java 17+
- Gradle (ou use o wrapper `./gradlew`)
- PostgreSQL rodando localmente

### Configuração do Banco de Dados

No arquivo `src/main/resources/application.properties`, configure:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/literalura
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
```


### Rodando a Aplicação

```bash
# Clone o repositório
git clone https://github.com/Victoredbr21/literalura.git

# Acesse a pasta
cd literalura

# Execute com Gradle
./gradlew bootRun

```

💻 Demonstração
```
===== LiterAlura =====
1 - Buscar livro pelo título
2 - Listar todos os livros
3 - Listar livros por idioma
4 - Listar autores vivos em determinado ano
0 - Sair
Escolha uma opção:
...
```

🧠 Aprendizados
Consumo de API REST com HttpClient e ObjectMapper

Mapeamento de entidades com JPA/Hibernate

Relacionamentos @ManyToOne / @OneToMany entre entidades

Derived queries e JPQL com Spring Data JPA

Persistência de dados com PostgreSQL

👨‍💻 Autor
Feito com 💙 por Victor Eduardo Meireles
GitHub Victoredbr21