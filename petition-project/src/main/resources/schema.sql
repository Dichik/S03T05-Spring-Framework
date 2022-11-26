-- drop table petitions, users, votes;

CREATE SEQUENCE IF NOT EXISTS petition_id_seq;
CREATE TABLE IF NOT EXISTS petitions
(
    id bigint PRIMARY KEY DEFAULT NEXTVAL('petition_id_seq'),
    title character varying(255) NOT NULL,
    description character varying(255) NOT NULL
);

CREATE SEQUENCE IF NOT EXISTS user_id_seq;
CREATE TABLE IF NOT EXISTS users
(
    id bigint PRIMARY KEY DEFAULT NEXTVAL('user_id_seq'),
    email character varying(255) NOT NULL,
    first_name character varying(255),
    second_name character varying(255)
);

CREATE SEQUENCE IF NOT EXISTS vote_id_seq;
CREATE TABLE IF NOT EXISTS votes
(
    id bigint PRIMARY KEY DEFAULT NEXTVAL('vote_id_seq'),
    petition_id bigint NOT NULL,
    user_id bigint NOT NULL,
    CONSTRAINT votes_users_fkey FOREIGN KEY(user_id) REFERENCES users(id),
    CONSTRAINT votes_petitions_fkey FOREIGN KEY(petition_id) REFERENCES petitions(id)
);
