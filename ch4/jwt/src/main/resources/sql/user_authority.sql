create table user_authority
(
    username  varchar(50) not null,
    authority varchar(50) not null,
    constraint ix_auth_username
        unique (username, authority),
    constraint fk_authorities_users
        foreign key (username) references user (username)
);

INSERT INTO learn_spring_security.user_authority (username, authority) VALUES ('apple', '/api/index:read');
INSERT INTO learn_spring_security.user_authority (username, authority) VALUES ('apple', 'ROLE_USER');
INSERT INTO learn_spring_security.user_authority (username, authority) VALUES ('user', 'ROLE_ADMIN');
