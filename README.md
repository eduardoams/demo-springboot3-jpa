![Java](https://miro.medium.com/v2/resize:fit:1358/1*yIEa02vx20jdlcWWJM-L4Q.jpeg)

# Aplicação Java com Spring Boot

Aplicação Java com Spring Boot para o gerenciamento de pedidos de uma loja é um sistema que utiliza a estrutura do Spring Boot para criar uma API que permite o controle de operações relacionadas a clientes, produtos e pedidos. Essa aplicação facilita o gerenciamento eficiente de uma loja, oferecendo funcionalidades como cadastro, edição, exclusão e atualização de informações.

Esta aplicação utiliza o banco de dados em memória H2 localmente.

## Configuração do projeto

Clone o projeto

```bash
  git clone https://github.com/eduardoams/demo-springboot3-jpa.git
```

Acesse utilizando sua IDE de preferência

## Executando a aplicação localmente

Identifique a classe principal java **DemoApplication** e em seguida execute-a como uma aplicação **Spring Boot App**.

A API estará disponível para acesso, por padrão, em http://localhost:8080/


## Documentação da API

Esta API fornece informações do cliente, produto, categoria do produto e pedido. As rotas abaixo estão disponíveis para todas estas entidades.

#### Retorna todos os itens

```http
  GET /users
```
```http
  GET /categories
```
```http
  GET /products
```
```http
  GET /orders
```

#### Retorna um item

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `string` | **Obrigatório**. O ID do item que você quer retornar |

```http
  GET /users/{id}
```
```http
  GET /categories/{id}
```
```http
  GET /products/{id}
```
```http
  GET /orders/{id}
```

#### Deleta um item

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `string` | **Obrigatório**. O ID do item que você quer deletar |

```http
  DELETE /users/{id}
```
```http
  DELETE /categories/{id}
```
```http
  DELETE /products/{id}
```
```http
  DELETE /orders/{id}
```

#### Cria um novo item

| Tipo       | Descrição                                   |
| :--------- | :------------------------------------------ |
| `raw` | Espera um json|

Usuário:
```http
  POST /users
```
*Exemplo:*
```json
{
    "name": "Eduardo Souza",
    "email": "eduardo.souza@gmail.com",
    "phone": "11988887777",
    "password": "123456"
}
```

Categoria:
```http
  POST /categories
```

*Exemplo:*
```json
{
    "name": "Informática"
}
```
Produto:
```http
  POST /products
```
*Exemplo:*
```json
{
    "name": "PC",
    "description": "PC Gamer",
    "price": "1670.42"
}
```

#### Atualiza um item

| Parâmetro       | Tipo                                   | Body       |
| :--------- | :------------------------------------------ | :--------- |
| `id` | `string` | `raw` |

Usuário:
```http
  PUT /users/{id}
```
*Exemplo:*
```json
{
    "name": "Eduardo Souza",
    "email": "eduardoasouza@gmail.com",
    "phone": "11955122231",
    "password": "123456"
}
```

Categoria:
```http
  PUT /categories/{id}
```

*Exemplo:*
```json
{
    "name": "Smartphone"
}
```
Produto:
```http
  PUT /products/{id}
```
*Exemplo:*
```json
{
    "name": "iPhone",
    "description": "Apple iPhone 13 (128 GB) - Meia-noite",
    "price": "5500.00"
}
```

## Stack utilizada

**Back-end:** Java 17, Spring Boot 3.1.4, H2 database

