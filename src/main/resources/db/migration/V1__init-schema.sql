CREATE TABLE categories (
    id integer NOT NULL,
    category character varying(30) NOT NULL
);

CREATE TABLE distributors (
    id integer NOT NULL,
    service_name character varying(30) NOT NULL,
    language_id integer NOT NULL,
    active boolean DEFAULT false NOT NULL
);

CREATE TABLE entry_tags (
    entry_id integer NOT NULL,
    tag_id integer NOT NULL
);

CREATE TABLE languages (
    id integer NOT NULL,
    language character varying(30) NOT NULL
);

CREATE TABLE rss_draft_entries (
    link character varying(255) NOT NULL,
    title character varying(255) NOT NULL,
    lead_content text,
    pub_date timestamp with time zone,
    rssfeed_id integer NOT NULL,
    created_date timestamp with time zone DEFAULT now() NOT NULL,
    accepted boolean DEFAULT false NOT NULL,
    rejected boolean DEFAULT false NOT NULL,
    modyfied_date timestamp with time zone
);

CREATE TABLE rss_entries (
    id integer NOT NULL,
    link character varying(255) NOT NULL,
    title character varying(255) NOT NULL,
    lead_content text,
    pub_date timestamp with time zone,
    rssfeed_id integer NOT NULL,
    created_date timestamp with time zone DEFAULT now() NOT NULL,
    feed_date timestamp with time zone,
    category_id integer
);

CREATE TABLE rssfeeds (
    id integer NOT NULL,
    feed_url character varying(255) NOT NULL,
    created_date timestamp with time zone DEFAULT now() NOT NULL,
    category_name character varying(30),
    distributor_id integer
);
CREATE TABLE tags (
    id integer NOT NULL,
    tag character varying(50) NOT NULL,
    language_id integer NOT NULL
);


CREATE SEQUENCE categories_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
ALTER SEQUENCE categories_id_seq OWNED BY categories.id;

CREATE SEQUENCE distributors_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
ALTER SEQUENCE distributors_id_seq OWNED BY distributors.id;

CREATE SEQUENCE languages_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
ALTER SEQUENCE languages_id_seq OWNED BY languages.id;

CREATE SEQUENCE rss_entries_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
ALTER SEQUENCE rss_entries_id_seq OWNED BY rss_entries.id;

CREATE SEQUENCE rssfeeds_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
ALTER SEQUENCE rssfeeds_id_seq OWNED BY rssfeeds.id;

CREATE SEQUENCE tags_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
ALTER SEQUENCE tags_id_seq OWNED BY tags.id;

ALTER TABLE ONLY categories ALTER COLUMN id SET DEFAULT nextval('categories_id_seq'::regclass);
ALTER TABLE ONLY distributors ALTER COLUMN id SET DEFAULT nextval('distributors_id_seq'::regclass);
ALTER TABLE ONLY languages ALTER COLUMN id SET DEFAULT nextval('languages_id_seq'::regclass);
ALTER TABLE ONLY rss_entries ALTER COLUMN id SET DEFAULT nextval('rss_entries_id_seq'::regclass);
ALTER TABLE ONLY rssfeeds ALTER COLUMN id SET DEFAULT nextval('rssfeeds_id_seq'::regclass);
ALTER TABLE ONLY tags ALTER COLUMN id SET DEFAULT nextval('tags_id_seq'::regclass);
