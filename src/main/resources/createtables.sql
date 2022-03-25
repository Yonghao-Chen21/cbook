CREATE TABLE public.contact (
	cid serial4 NOT NULL,
	"name" varchar(50) NOT NULL,
	email varchar(50) NOT NULL,
	mobile varchar(50) NULL,
	dob date NULL,
	uid int4 NOT NULL,
	status int4 NOT NULL,
	CONSTRAINT contact_pk PRIMARY KEY (cid)
);

CREATE TABLE public."user" (
	uid serial4 NOT NULL,
	"name" varchar(50) NOT NULL,
	"password" varchar(50) NOT NULL,
	email varchar(50) NOT NULL,
	mobile varchar(50) NOT NULL,
	dob date NULL,
	CONSTRAINT appuser_pk PRIMARY KEY (uid),
	CONSTRAINT user_un UNIQUE (uid, email, mobile)
);