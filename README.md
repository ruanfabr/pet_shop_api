# Pet CRUD Simples com Spring Boot

Este é um projeto simples em Java com Spring Boot criado para aprendizado e simulação de um CRUD (Create, Read, Update, Delete) básico, sem o uso de banco de dados. Os dados são armazenados em uma lista na memória.

## Funcionalidades

- **Adicionar um pet**  
  Cada pet possui as seguintes informações:  
  - Nome  
  - Tipo do animal  
  - Raça  
  - Idade  
  - Sexo  

  Não é permitido inserir um pet já existente (validação baseada no conjunto dos campos).

- **Remover um pet**  
  A remoção é feita com base no nome, raça e idade para garantir que seja o mesmo animal.

- **Atualizar um pet**  
  A atualização é feita com base no nome e tipo do animal. Se um pet com esse nome e tipo existir, os dados dele são atualizados conforme o novo JSON enviado.

- **Listar os pets registrados**  
  Retorna todos os pets atualmente cadastrados na lista.

## Endpoints HTTP

| Método   | Endpoint                                  | Descrição                       | Corpo / Parâmetros                |
|----------|-------------------------------------------|---------------------------------|-----------------------------------|
| POST     | `/pets/addPet`                            | Adiciona um novo pet            | JSON com dados do pet             |
| POST     | `/pets/removePet/{nome}`                  | Remove um pet                   | JSON com nome, raça e idade       |
| POST     | `/pets/updtPet/{nome}/{tipo_animal}`      | Atualiza um pet existente       | JSON com nome, tipo e novos dados |
| GET      | `/pets/verPets`                           | Lista todos os pets registrados | Nenhum                            |

### Exemplo de JSON para adicionar um pet (POST `/pets/addPet`):

```json
{
  "nome": "Rex",
  "tipo_animal": "Cachorro",
  "raca": "Labrador",
  "idade": 5,
  "sexo": "M"
}
```

### Exemplo de JSON para atualizar um pet (PUT /pets/updtPet/{nome}/{tipo_animal}):

```json
{
  "nome": "Rex",
  "tipo_animal": "cachorro",
  "raca": "Golden Retriever",
  "idade": 6,
  "sexo": "M"
}
```

### Como rodar o projeto

    Certifique-se de ter o Java 11+ e Maven instalados.

    Clone este repositório.

    No terminal, dentro da pasta do projeto, execute:

### mvn spring-boot:run

    O serviço estará disponível em http://localhost:8080.

### Observações

    Este projeto não usa banco de dados. Todos os dados são armazenados apenas em memória durante a execução.

    Ao reiniciar a aplicação, os dados serão perdidos.

    O foco principal é aprendizado e entendimento dos conceitos básicos de Spring Boot e manipulação de dados via HTTP.
