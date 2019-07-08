# Planets-api

O projeto tarta-se de uma API REST que permite o cadastro, a busca e a remoção de planetas referente ao mundo do StarWars.

## Tecnologias Utilizadas no Projeto
* Linguagem de programação: Java
* Framework: Spring boot
* Banco de dados: H2 

## Recursos disponíveis para acesso via API:
* [**Info**](#reference/recursos/info)
* [**Planets**](#reference/recursos/planets)

## Métodos
Requisições para a API devem seguir os padrões:

| Método    | Descrição |
|-----|-----|
| `GET`     | Retorna informações de um ou mais registros. |
| `POST`    | Utilizado para criar um novo registro. |
| `DELETE ` | Utilizado para remover um registro. |

## Principais Respostas

| Código | Descrição |
|---|---|
| `200` | Requisição executada com sucesso (Success).|
| `400` | Erros de validação ou os campos informados não existem (BadRequest).|
| `404` | Registro pesquisado não encontrado (NotFound).|


## Listar (Sem o ID)
As ações de `listar` permitem o envio dos seguintes parâmetros:

| Parâmetro | Descrição |
|---|---|
| `name` | Filtra pelo nome do planeta. |
| `page` | Informa qual página deve ser retornada (default: 0). |
| `size` | Informa quantidade retornada por pagina (default: 5). |


# Group Recursos

# Info [/info]

É disponibilizado a versão atual da API.

### Listar (List) [GET]

+ Request (application/json)

+ Response 200 (application/json)
	 + Body
           {
			 "versao": "1.0",
			 "nome": "planets-api"
		   }

			


# Planets [/planets]

É disponibilizado os recursos para remoção, busca e inserção de informações sobre os planetas no mundo do StarWars.

### Novo (Create) [POST]

+ Attributes (object)

    + name: nome do planeta (string, required) 
    + climate: clima do planeta (string, required) 
    + terrain: terreno do planeta (string, required)
   
+ Request (application/json)
    + Body
            {
              "name": "Alderaan",
              "climate": "temperate",
              "terrain": "grasslands"
            }

+ Response 201 (application/json)
    + header
           Location: Caminho para o recurso criado.


+ Response 400 (application/json)
  Quando existe erro de validação ou os campos informados não existem.
    + Body
            {
			  "status": 400,
			  "error": "Bad Request",
			  "message": "O planeta Alderaan já está cadastrado!",
			  "path": "/planets"
			}
           
           
           
### Listar por ID (Read) [GET /planets/{id}]

+ Parameters
    + id (required, number, `1`) ... ID do planeta
   
+ Request (application/json)

+ Response 200 (application/json)
    + Body
            {
              "name": "Alderaan",
              "climate": "temperate",
              "terrain": "grasslands",
              "films": 3
            } 

+ Response 404 (application/json)
  Quando o registro não for encontrado.
    + Body
            {
			  "status": 404,
			  "error": "Not Found",
			  "message": "Id não encontrado!",
			  "path": "/planets/4"
			}


### Listar (List) [GET]

+ Request (application/json)

+ Response 200 (application/json)
	 + Body
            {
              "name": "Alderaan",
              "climate": "temperate",
              "terrain": "grasslands",
              "films": 3
            } 

+ Response 404 (application/json)
	 + Body
           {
			 "status": 404,
			 "error": "Not Found",
			 "message": "O planeta Alderaa não foi encontrado!",
			 "path": "/planets"
		   }
		   



### Remover (Delete) [DELETE  /planets/{id}]

+ Request (application/json)

+ Response 204 (application/json)
	No content.
 
+ Response 404 (application/json)
  Quando o registro não for encontrado.
    + Body
            {
			  "status": 404,
			  "error": "Not Found",
			  "message": "Id não encontrado!",
			  "path": "/planets/4"
			}
		   

## Contatos

Leticya Siqueira – [@Linkedin](https://www.linkedin.com/in/leticya-siqueira/) – leticya.siqueira@gmail.com
![](header.png)        