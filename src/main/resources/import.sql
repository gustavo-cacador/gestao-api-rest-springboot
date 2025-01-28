INSERT INTO tb_setor (nome, descricao) VALUES ('TI', 'Setor de Tecnologia');

INSERT INTO tb_funcionario (nome, cpf, endereco, data_nascimento, email_pessoal, email_trabalho, telefone, setor_id) VALUES ('Fábio', '123456789311', 'Rua 1', '1995-01-01', 'fabio@gmail.com', 'fabioempresa@gmail.com', '27999999999', 1);
INSERT INTO tb_funcionario (nome, cpf, endereco, data_nascimento, email_pessoal, email_trabalho, telefone, setor_id) VALUES ('Thiago', '123456789312', 'Rua 2', '1995-01-02', 'thiago@gmail.com', 'thiagoempresa@gmail.com', '27999999998', 1);
INSERT INTO tb_funcionario (nome, cpf, endereco, data_nascimento, email_pessoal, email_trabalho, telefone, setor_id) VALUES ('Samuel', '123456789313', 'Rua 3', '1995-01-03', 'samuel@gmail.com', 'samuelempresa@gmail.com', '27999999997', 1);

INSERT INTO tb_demanda (pendencia, situacao, servico, data_abertura, nivel, prazo, canal, solicitante_id, executor_id) VALUES ('Consertar monitor', 'Em andamento', 'Serviço prestado pela TI', '2025-01-28', 1, '2025-01-29', 'Interno', 1, 2);
INSERT INTO tb_demanda (pendencia, situacao, servico, data_abertura, nivel, prazo, canal, solicitante_id, executor_id) VALUES ('Criação Banco de Dados H2', 'Em andamento', 'Serviço prestado pela TI', '2025-01-28', 7, '2025-02-08', 'Interno', 3, 1);




