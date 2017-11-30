/*create table person (
	id integer not null,
	name varchar(255) not null,
	location varchar(255),
	birth_date timestamp,
	primary key (id)
);*/

INSERT INTO USER (ID, NAME, BIRTH_DATE) VALUES
(101, 'Joao', sysdate()),
(102, 'Maria', sysdate()),
(103, 'Jose', sysdate());

INSERT INTO POST (ID, DESCRIPTION, USER_ID) VALUES
(101, 'My first post', 101),
(102, 'My second post', 101);
