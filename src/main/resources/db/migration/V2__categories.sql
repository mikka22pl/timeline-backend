
INSERT INTO categories (id, category) VALUES (1, 'kraj');
INSERT INTO categories (id, category) VALUES (3, 'world');
INSERT INTO categories (id, category) VALUES (5, 'europa');

SELECT pg_catalog.setval('categories_id_seq', 5, true);
