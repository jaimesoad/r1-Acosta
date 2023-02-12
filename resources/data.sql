CREATE TABLE account
(
    account_number INT          NOT NULL PRIMARY KEY,
    account_state  BIT          NOT NULL,
    balance        FLOAT        NOT NULL,
    client_name    varchar(255) NOT NULL
);