# Planets-api

O projeto tarta-se de uma API REST que permite o cadastro, a busca e a exclusão de planetas referente ao mundo do StarWars.

## Tecnologias Utilizadas no Projeto
* Linguagem de programação: Java
* Framework: Spring boot
* Banco de dados: H2 embedded

Recursos disponíveis para acesso via API:
* [**Informação**](#reference/recursos/info)
* [**Planetas**](#reference/recursos/planets)

## Métodos
Requisições para a API devem seguir os padrões:
| Método | Descrição |
|---|---|
| `GET` | Retorna informações de um ou mais registros. |
| `POST` | Utilizado para criar um novo registro. |
| `DELETE` | Utilizado pata remover um registro. |

## Principais Respostas

| Código | Descrição |
|---|---|
| `200` | Requisição executada com sucesso (success).|
| `400` | Erros de validação ou os campos informados não existem.|
| `404` | Registro pesquisado não encontrado (Not found).|


## Listar (Sem o ID)
As ações de `listar` permitem o envio dos seguintes parâmetros:

| Parâmetro | Descrição |
|---|---|
| `name` | Filtra pelo nome do planeta. |
| `page` | Informa qual página deve ser retornada (default: 0). |
| `size` | Informa quantidade retornada por pagina (default: 5). |


