![Código Certo Coders](https://utfs.io/f/3b2340e8-5523-4aca-a549-0688fd07450e-j4edu.jfif)

# 📚 Trilha Inicial BackEnd Jr
Este projeto tem como objetivo desenvolver uma API RESTful para gerenciamento de tarefas, proporcionando funcionalidades de CRUD (Create, Read, Update, Delete) de tarefas, autenticação de usuários e armazenamento dos dados em um banco de dados.

### Tecnologia utilizada
- Spring Boot
- Maven
- Spring Data JPA
- Spring Security
- SQLite
- JWT
- Java 17




### Funcionalidades
- Cadastrar usuário
- Lista de usuários
- Autenticação de usuário
- Listar tarefas
- Criar tarefa
- Atualizar tarefa
- Deletar tarefa.



## Como utilizar
- Necessário realizar um registro de usuário para ter acesso aos endpoints.
```bash
POST: http://localhost:8080/registro

{
   "usuario":"string",
   "senha":"string
}
```
- Acessar os usuarios cadastrados.
```bash
GET: http://localhost:8080/login

{
   "usuario":"string",
   "senha":"string
}
```
- Fazer o login preenchendo com as mesmas informações registradas e pegar o token que será gerado como resposta para acessar os endpoints.
```bash
POST: http://localhost:8080/login

{
   "usuario":"string",
   "senha":"string
}
```
- o Id não é necessário preencher, pode deixar como 0.
```bash
POST: http://localhost:8080/tarefas

{
    "titulo": "Limpar casa",
    "descricao": "Fazer limpeza da casa no domingo",
    "status": "pedente",
    "prioridade": "mediana"
}
```
- Para editar uma tarefa, é só preencher com o id na url e depois preencher com os campos que deseja mudar
```bash
PUT: http://localhost:8080/tarefas/2

{
    "titulo": "Limpar casa",
    "descricao": "Fazer limpeza da casa no domingo",
    "status": "pedente",
    "prioridade": "mediana"
}
```
- Para listar todas tarefas.
```bash
GET: http://localhost:8080/tarefas/
```
- Para apagar é só enviar um o id como  parâmetro
```bash
DELETE: http://localhost:8080/tarefas/2
```



## Autor
- [Davi Dias](https://www.linkedin.com/in/davifernandodias/)
