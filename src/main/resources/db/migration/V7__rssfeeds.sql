
INSERT INTO rssfeeds (id, feed_url, created_date, category_name, distributor_id) VALUES (18, 'http://themostimportantnews.com/archives/category/world/feed', '2017-02-10 20:52:03.523+01', 'World', 6);
INSERT INTO rssfeeds (id, feed_url, created_date, category_name, distributor_id) VALUES (4, 'http://feeds.bbci.co.uk/news/world/europe/rss.xml', '2017-02-01 17:46:32.828+01', 'World - Europe', 7);
INSERT INTO rssfeeds (id, feed_url, created_date, category_name, distributor_id) VALUES (5, 'http://feeds.bbci.co.uk/news/world/us_and_canada/rss.xml', '2017-02-01 17:48:37.773+01', 'World - US & Ca', 7);
INSERT INTO rssfeeds (id, feed_url, created_date, category_name, distributor_id) VALUES (6, 'http://feeds.bbci.co.uk/news/world/middle_east/rss.xml', '2017-02-01 17:54:47.989+01', 'World - Middle East', 7);
INSERT INTO rssfeeds (id, feed_url, created_date, category_name, distributor_id) VALUES (7, 'http://feeds.bbci.co.uk/news/world/asia/rss.xml', '2017-02-01 17:55:53.399+01', 'World - Asia', 7);
INSERT INTO rssfeeds (id, feed_url, created_date, category_name, distributor_id) VALUES (1, 'http://feeds.abcnews.com/abcnews/internationalheadlines', '2017-01-30 18:57:13.539+01', 'World', 1);
INSERT INTO rssfeeds (id, feed_url, created_date, category_name, distributor_id) VALUES (2, 'http://feeds.abcnews.com/abcnews/usheadlines', '2017-01-30 20:54:58.085+01', 'USA', 1);
INSERT INTO rssfeeds (id, feed_url, created_date, category_name, distributor_id) VALUES (3, 'http://feeds.abcnews.com/abcnews/politicsheadlines', '2017-01-30 20:55:54.257+01', 'Politics', 1);
INSERT INTO rssfeeds (id, feed_url, created_date, category_name, distributor_id) VALUES (8, 'http://www.polskatimes.pl/rss/strona-glowna.xml', '2017-02-01 18:05:45.287+01', 'Wydarzenia', 2);
INSERT INTO rssfeeds (id, feed_url, created_date, category_name, distributor_id) VALUES (9, 'http://www.polskatimes.pl/rss/fakty_kraj.xml', '2017-02-01 18:07:05.521+01', 'Fakty kraj', 2);
INSERT INTO rssfeeds (id, feed_url, created_date, category_name, distributor_id) VALUES (10, 'http://www.polskatimes.pl/rss/fakty_swiat.xml', '2017-02-01 18:07:36.725+01', 'Fakty świat', 2);
INSERT INTO rssfeeds (id, feed_url, created_date, category_name, distributor_id) VALUES (11, 'http://www.polskatimes.pl/rss/fakty_polityka.xml', '2017-02-01 18:09:27.889+01', 'Fakty polityka', 2);
INSERT INTO rssfeeds (id, feed_url, created_date, category_name, distributor_id) VALUES (12, 'http://www.rp.pl/rss/1000', '2017-02-01 18:12:11.53+01', 'Kraj', 3);
INSERT INTO rssfeeds (id, feed_url, created_date, category_name, distributor_id) VALUES (13, 'http://www.rp.pl/rss/1001', '2017-02-01 18:12:42.055+01', 'Świat', 3);
INSERT INTO rssfeeds (id, feed_url, created_date, category_name, distributor_id) VALUES (14, 'http://www.rp.pl/rss/1004', '2017-02-01 18:13:32.847+01', 'Ekonomia', 3);
INSERT INTO rssfeeds (id, feed_url, created_date, category_name, distributor_id) VALUES (15, 'http://www.polityka.pl/rss/articles.xml?list=515', '2017-02-04 10:45:27.782+01', 'Świat', 5);
INSERT INTO rssfeeds (id, feed_url, created_date, category_name, distributor_id) VALUES (16, 'http://www.polityka.pl/rss/articles.xml?list=531', '2017-02-04 10:46:00.221+01', 'Kraj', 5);
INSERT INTO rssfeeds (id, feed_url, created_date, category_name, distributor_id) VALUES (17, 'http://www.pap.pl/API/pl/Cms.Informations/Rss/1159/0', '2017-02-04 10:59:45.794+01', 'All', 4);

SELECT pg_catalog.setval('rssfeeds_id_seq', 18, true);
