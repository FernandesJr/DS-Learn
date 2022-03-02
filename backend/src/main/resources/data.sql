INSERT INTO tb_user (name, email, password) VALUES ('Alex Brown', 'alex@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (name, email, password) VALUES ('Maria Green', 'maria@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (name, email, password) VALUES ('Ana White', 'ana@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_role (authority) VALUES ('ROLE_STUDENT');
INSERT INTO tb_role (authority) VALUES ('ROLE_INSTRUCTOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 3);

INSERT INTO tb_course (name, img_Uri, img_Gray_Uri) VALUES ('Bootcamp HTML AND CSS', 'https://ayltoninacio.com.br/img/p/32w750.jpg', 'https://images.squarespace-cdn.com/content/v1/5551ffc1e4b006bc9d6ed809/1590950706330-UKY1Z9XQX6IEUTHOA6EK/html-css.jpg');

INSERT INTO tb_offer (edition, start_Moment, end_Moment, course_id) VALUES ('1.0', TIMESTAMP WITH TIME ZONE '2022-02-03T00:00:00Z', TIMESTAMP WITH TIME ZONE '2023-02-03T00:00:00Z', 1);

INSERT INTO tb_notification (text, moment, read, route, user_id) VALUES ('Seja bem vindo ao nosso querido curso de HTML e CSS', TIMESTAMP WITH TIME ZONE '2022-02-03T00:00:00Z', 0, '/ROTA', 1);


INSERT INTO tb_resource (title, description, position, img_uri, type, offer_id) VALUES ('Trilha HTML e CSS', 'Conteúdo de aprendizado', 1, 'https://ayltoninacio.com.br/img/p/32w750.jpg', 1, 1);
INSERT INTO tb_resource (title, description, position, img_uri, type, offer_id) VALUES ('Forum', 'Tire todas as suas dúvidas', 2, 'https://ayltoninacio.com.br/img/p/32w750.jpg', 2, 1);
INSERT INTO tb_resource (title, description, position, img_uri, type, offer_id) VALUES ('Lives', 'Conteúdo exclusivo para a turma', 3, 'https://ayltoninacio.com.br/img/p/32w750.jpg', 0, 1);