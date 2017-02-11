ALTER TABLE ONLY categories
    ADD CONSTRAINT categories_category_key UNIQUE (category);

ALTER TABLE ONLY categories
    ADD CONSTRAINT categories_pkey PRIMARY KEY (id);

ALTER TABLE ONLY distributors
    ADD CONSTRAINT distributors_pkey PRIMARY KEY (id);

ALTER TABLE ONLY entry_tags
    ADD CONSTRAINT entry_tags_pkey PRIMARY KEY (entry_id, tag_id);

ALTER TABLE ONLY languages
    ADD CONSTRAINT languages_pkey PRIMARY KEY (id);

ALTER TABLE ONLY rss_draft_entries
    ADD CONSTRAINT rss_draft_entries_link_key UNIQUE (link);

ALTER TABLE ONLY rss_draft_entries
    ADD CONSTRAINT rss_draft_entries_pkey PRIMARY KEY (link);

ALTER TABLE ONLY rss_entries
    ADD CONSTRAINT rss_entries_pkey PRIMARY KEY (id);

ALTER TABLE ONLY rssfeeds
    ADD CONSTRAINT rssfeeds_pkey PRIMARY KEY (id);

ALTER TABLE ONLY tags
    ADD CONSTRAINT tags_pkey PRIMARY KEY (id);

ALTER TABLE ONLY tags
    ADD CONSTRAINT tags_tag_language_id_key UNIQUE (tag, language_id);

ALTER TABLE ONLY tags
    ADD CONSTRAINT tags_tag_language_id_key1 UNIQUE (tag, language_id);

ALTER TABLE ONLY distributors
    ADD CONSTRAINT distributors_language_id_fkey FOREIGN KEY (language_id) REFERENCES languages(id);

ALTER TABLE ONLY entry_tags
    ADD CONSTRAINT entry_tags_entry_id_fkey FOREIGN KEY (entry_id) REFERENCES rss_entries(id);

ALTER TABLE ONLY entry_tags
    ADD CONSTRAINT entry_tags_tag_id_fkey FOREIGN KEY (tag_id) REFERENCES tags(id);

ALTER TABLE ONLY rss_draft_entries
    ADD CONSTRAINT rss_draft_entries_rssfeed_id_fkey FOREIGN KEY (rssfeed_id) REFERENCES rssfeeds(id);

ALTER TABLE ONLY rss_entries
    ADD CONSTRAINT rss_entries_rssfeed_id_fkey FOREIGN KEY (rssfeed_id) REFERENCES rssfeeds(id);
