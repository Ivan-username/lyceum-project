CREATE TABLE users (
    user_id VARCHAR(40) PRIMARY KEY NOT NULL,

    name VARCHAR(255) NOT NULL,
    birth_day DATE NOT NULL,

    created_at TIMESTAMP NOT NULL
);

CREATE TABLE documents (
    document_id VARCHAR(40) PRIMARY KEY NOT NULL,

    doc_type VARCHAR(255) NOT NULL,
    document_ref VARCHAR(255) NOT NULL,
    user_id  VARCHAR(40) NOT NULL,

    created_at TIMESTAMP NOT NULL
);
