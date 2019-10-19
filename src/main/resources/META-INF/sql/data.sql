INSERT INTO authors (firstName, lastName) VALUES ('Jan', 'Kowalski');
INSERT INTO authors (firstName, lastName) VALUES ('Mietek', 'Szczesniak');
INSERT INTO categories (description, name) VALUES ('description of category1', 'name 1');
INSERT INTO categories (description, name) VALUES ('description of category2', 'name 2');

INSERT INTO article (content, created, draft, title, updated, Author_id) VALUES ('content1 of article 1 2222222222222222222222222222222222222222', NOW(),false,'title of article 1', null, 1);
INSERT INTO article (content, created, draft,title, updated, Author_id) VALUES ('content1 of article 2 222222222222222222222222222222222222222', NOW(),false,'title of article 2', null, 1);
INSERT INTO article (content, created, draft,title, updated, Author_id) VALUES ('content1 of article 3', NOW(), false,'title of article 3', null, 1);


