
INSERT INTO languages (id, language) VALUES (1, 'polski');
INSERT INTO languages (id, language) VALUES (2, 'angielski');
INSERT INTO languages (id, language) VALUES (3, 'niemiecki');

SELECT pg_catalog.setval('languages_id_seq', 3, true);