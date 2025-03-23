INSERT INTO tb_setor (nome, descricao) VALUES ('T.I', 'Responsável pela infraestrutura tecnológica, suporte técnico, desenvolvimento e manutenção de sistemas, garantindo a segurança e o funcionamento dos recursos digitais da empresa.');
INSERT INTO tb_setor (nome, descricao) VALUES ('Diretoria', 'Encarregada da tomada de decisões estratégicas, planejamento organizacional e supervisão das operações para alcançar os objetivos da empresa.');
INSERT INTO tb_setor (nome, descricao) VALUES ('Controladoria', 'Responsável pelo controle financeiro e contábil, assegurando a conformidade com normas e regulamentos, além de realizar análises para otimizar os recursos da empresa.');

INSERT INTO tb_demanda (pendencia, servico, data_abertura, nivel, prazo, canal) VALUES ('Criando SQL para projetinho', 'T.I', '2025-02-11', 7, '2025-02-15', 'Interno');
INSERT INTO tb_demanda (pendencia, servico, data_abertura, nivel, prazo, canal) VALUES ('Revisão de relatório financeiro', 'Controladoria', '2025-02-11', 5, '2025-02-13', 'Chamado');
INSERT INTO tb_demanda (pendencia, servico, data_abertura, nivel, prazo, canal) VALUES ('Planejamento estratégico anual', 'Diretoria', '2025-02-11', 9, '2025-02-20', 'Presencial');

INSERT INTO tb_funcionario (nome, cpf, endereco, data_nascimento, email_pessoal, email_workspace, telefone, setor_id) VALUES ('Jhon Adolfo', '12345678901', 'Rua 1', '1990-05-15', 'jhonadolfo@gmail.com', 'jhon.adolfo@empresa.com', '27999999991', 1);
INSERT INTO tb_funcionario (nome, cpf, endereco, data_nascimento, email_pessoal, email_workspace, telefone, setor_id) VALUES ('Paulo Henrique', '12345678902', 'Rua 2', '1990-05-16', 'paulohenrique@gmail.com', 'paulo.henrique@empresa.com', '27999999992', 2);
INSERT INTO tb_funcionario (nome, cpf, endereco, data_nascimento, email_pessoal, email_workspace, telefone, setor_id) VALUES ('Thiago Emiliano', '12345678903', 'Rua 3', '1990-05-17', 'thiagoemiliano@gmail.com', 'thiago.emiliano@empresa.com', '27999999993', 3);

INSERT INTO tb_usuario (nome, email, telefone, senha, data_nascimento) VALUES ('Thiago Brown', 'thiago@gmail.com', '988888888', '$2a$10$N7SkKCa3r17ga.i.dF9iy.BFUBL2n3b6Z1CWSZWi/qy7ABq/E6VpO', '2001-07-25');
INSERT INTO tb_usuario (nome, email, telefone, senha, data_nascimento) VALUES ('Davi Green', 'davi@gmail.com', '977777777', '$2a$10$N7SkKCa3r17ga.i.dF9iy.BFUBL2n3b6Z1CWSZWi/qy7ABq/E6VpO', '1987-12-13');

INSERT INTO tb_role (authority) VALUES ('ROLE_CLIENT');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);

INSERT INTO tb_equipamento (patrimonio, tipo, modelo, descricao, funcionario_id, setor_id) VALUES ('1233', 'Notebook', 'Dell Latitude 3420', 'Notebook utilizado pelo setor de T.I para suporte técnico.', 1, 1);
INSERT INTO tb_equipamento (patrimonio, tipo, modelo, descricao, funcionario_id, setor_id) VALUES ('1234', 'Monitor', 'AOC 240hz', 'Monitor utilizado pelo setor de T.I para desenvolvimento.', 2, 2);
INSERT INTO tb_equipamento (patrimonio, tipo, modelo, descricao, funcionario_id, setor_id) VALUES ('1235', 'Impressora', 'HP LaserJet Pro M404', 'Impressora da Controladoria para impressão de relatórios financeiros.', 3, 3);

INSERT INTO tb_funcionario_demanda (demanda_id, funcionario_id) VALUES (1, 1);
INSERT INTO tb_funcionario_demanda (demanda_id, funcionario_id) VALUES (2, 2);
INSERT INTO tb_funcionario_demanda (demanda_id, funcionario_id) VALUES (3, 3);

