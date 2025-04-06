# 📋Sistema de Gestão de Demandas, Equipamentos, Funcionários e Setores

## 📖Descrição
Este projeto é um sistema de controle de funcionários, setores, demandas e equipamentos, desenvolvido em Java com Spring Boot. Ele oferece uma API REST para gerenciar demandas de funcionários e seus setores, gestão de equipamentos, permitindo criar, ler, atualizar e deletar registros de atividades, tarefas, funcionários, setores e equipamentos.

## 💻Tecnologias Utilizadas
- Java 17
- Spring Boot 3.4.2
- Spring Web
- Spring Data JPA
- Spring Security
- Validation
- H2 Database (para desenvolvimento)
- Maven (gerenciamento de dependências)
- REST API

## 🚀Funcionalidades
- Criar novas demandas, funcionários, setores e equipamentos
- Listar todas as demandas, funcionários, setores e equipamentos
- Buscar uma demanda, funcionário, setor e equipamento específico por ID
- Atualizar informações de uma demanda, funcionário, setor e equipamento existente
- Deletar uma demanda, funcionário, setor e equipamento

## 📁Estrutura do Projeto
- `entities`: Contém as entidades `Demanda`, `Equipamento`, `Funcionario` e `Setor` que define a estrutura dos dados
- `dto`: Contém os DTOs das entidades para transportar os dados
- `repositories`: Interface `DemandaRepository`, `EquipamentoRepository`, `FuncionarioRepository` `SetorRepository` para operações de banco de dados
- `services`: Classe `DemandaService`, `EquipamentoService`,  `FuncionarioService`, `SetorService` com a lógica de negócios
- `controllers`: Classe `DemandaController`, `EquipamentoController`, `FuncionarioController`, `SetorController` que define os endpoints da API
- `enums`: Contém a classe `DemandaStatus` para definir o status de cada demanda
- `exceptions`: Para tratar exceções de serviço
- `handlers`: Contém a classe para customizar a resposta de validação

## ▶️Como Executar
1. Clone o repositório
2. Navegue até a pasta do projeto
3. Execute `mvn spring-boot:run`
4. A aplicação estará disponível em `http://localhost:8080`

## 📌Endpoints Principais

## 🔧Demandas
- POST `/demandas`: Criar uma nova demanda
- GET `/demandas`: Listar todas as demandas
- GET `/demandas/{id}`: Buscar uma demanda específica
- PUT `/demandas/{id}`: Atualizar uma demanda existente
- DELETE `/demandas/{id}`: Deletar uma demanda
  
## 🛠️Equipamentos
- POST `/equipamentos`: Criar um novo equipamento
- GET `/equipamentos`: Listar todos os equipamentos
- GET `/equipamentos/{id}`: Buscar um equipamento específico
- GET `/equipamentos/buscar?tipo=nome`: Buscar um equipamento por nome
- PUT `/equipamentos/{id}`: Atualizar um equipamento existente
- DELETE `/equipamentos/{id}`: Deletar um equipamento

## 💼Funcionários
- POST `/funcionarios`: Criar um nov funcionario
- GET `/funcionarios`: Listar todos os funcionarios
- GET `/funcionarios/{id}`: Buscar um funcionario específico
- PUT `/funcionarios/{id}`: Atualizar um funcionario existente
- DELETE `/funcionarios/{id}`: Deletar um funcionario

## 🏢Setores
- POST `/setores`: Criar um novo setor
- GET `/setores`: Listar todos os setores
- GET `/setores/{id}`: Buscar um setor específico
- PUT `/setores/{id}`: Atualizar um setor existente
- DELETE `/setores/{id}`: Deletar um setor

## 📦Exemplo de Payload (JSON)
```
Funcionário:
{
  "nome": "Gustavo Caçador",
  "cpf": "12345678911",
  "endereco": "Rua 1",
  "dataNascimento": "2001-01-09",
  "emailPessoal": "gustavo@gmail.com",
  "emailWorkspace": "gustavoempresa@gmail.com,
  "telefone": "27111111111"
}
```
```
Demanda:
{
  "pendencia": "Implementar API RESTful",
  "servico": "T.I",
  "dataAbertura": "2025-02-11",
  "nivel": "7",
  "prazo": "2025-02-18",
  "canal": "Interno"
}
```
```
Equipamento:
{
  "patrimonio": "1234",
  "tipo": "Monitor",
  "modelo": "AOC",
  "descricao": "Monitor com defeito"
}
```
```
Setor:
{
  "nome": "T.I",
  "descricao": "Setor destinado a tecnologia"
}
```


## 🛠️Configuração do Banco de Dados
O projeto utiliza H2 Database para desenvolvimento. As configurações podem ser encontradas em `src/main/resources/application-test.properties`.

## 🧪Testes
Os testes podem ser executados via Maven: `mvn test`



![image](https://github.com/user-attachments/assets/f8a4a8ed-7b53-4c8a-8520-dc0f1e1cedd7)
