![Código Certo Coders](https://utfs.io/f/3b2340e8-5523-4aca-a549-0688fd07450e-j4edu.jfif)


### Tecnologia utilizada
- Spring Boot
- Maven
- Spring Data
- Spring Security
- SQLite
- JWT
- Java 17

### Funcionalidades
- Criação para usuários.
- Listagem de usuarios.
- Authenticação via token JWT.
- CRUD para tarefas.

## Como utilizar
- Necessário realizar um registro de usuário para ter acesso aos endpoints.
```bash
POST: http://localhost:8080/registro

{
   "usuario":"string",
   "senha":"string",
   "role": "string"
}
```
- Fazer o login preenchendo com login e senha que foram registradas e pegar o token que será gerado como resposta para acessar os endpoints.
```bash
POST: http://localhost:8080/login

{
   "usuario":"string",
   "senha":"string
}
```
- A tarefa tem como campos titulo, descricao, status, prioridade . o Id não é necessário preencher.
```bash
POST: http://localhost:8080/tarefas

{
   "titulo": "string",
  "descricao": "string",
 "prioridade": "string",
  "status": "string"
}
```
- Para editar uma tarefa, é só preencher com o id na url e depois preencher com os campos que deseja mudar
```bash
PUT: http://localhost:8080/tarefas/5

{
    "titulo": "string",
    "descricao": "string",
    "status": "string",
    "prioridade": "string"
}
```
- Para listar todas tarefas.
```bash
GET: http://localhost:8080/tarefas
```
- Para resgatar tarefa específica.
```bash
GET: http://localhost:8080/tarefas/{id}
```
- Para apagar é só enviar um o id como  parâmetro
```bash
DELETE: http://localhost:8080/tarefas/{id}
```



## Autor
- [@Davi Dias](https://www.linkedin.com/in/davifernandodias/)
