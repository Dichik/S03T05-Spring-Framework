INSERT INTO users(email, first_name, second_name) VALUES ('test_email_1@email.com', 'first_name_1', 'second_name_1');
INSERT INTO users(email, first_name, second_name) VALUES ('test_email_2@email.com', 'first_name_2', 'second_name_2');
INSERT INTO users(email, first_name, second_name) VALUES ('test_email_3@email.com', 'first_name_3', 'second_name_3');

INSERT INTO petitions(title, description) VALUES ('petition_1', 'description_1');
INSERT INTO petitions(title, description) VALUES ('petition_2', 'description_2');

INSERT INTO votes(petition_id, user_id) VALUES (1, 1);
INSERT INTO votes(petition_id, user_id) VALUES (1, 2);
INSERT INTO votes(petition_id, user_id) VALUES (2, 1);


