
INSERT INTO distributors (id, service_name, language_id, active) VALUES (1, 'ABC News', 2, true);
INSERT INTO distributors (id, service_name, language_id, active) VALUES (2, 'Polska The Times', 1, true);
INSERT INTO distributors (id, service_name, language_id, active) VALUES (3, 'Rzeczpospolita', 1, true);
INSERT INTO distributors (id, service_name, language_id, active) VALUES (4, 'PAP', 1, true);
INSERT INTO distributors (id, service_name, language_id, active) VALUES (5, 'Polityka', 1, true);
INSERT INTO distributors (id, service_name, language_id, active) VALUES (6, 'The Most Important News', 2, true);
INSERT INTO distributors (id, service_name, language_id, active) VALUES (7, 'BBC News', 2, true);

SELECT pg_catalog.setval('distributors_id_seq', 7, true);