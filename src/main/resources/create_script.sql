create table user_info(
		id bigint primary key not null,
		username varchar(50),
		pwd varchar(50),
		email varchar(100),
		dob date,
		phone_no char(10)
	);
	
	
	create table contact_info(
		id bigint,
		userid bigint,
		contact_name varchar(50),
		status char(1) default 'N',
		email varchar(100),
		dob date,
		phone_no char(10),
	   PRIMARY KEY(id),
	   CONSTRAINT fk_user_info
		  FOREIGN KEY(userid) 
		  REFERENCES user_info(id)
		  ON DELETE SET NULL
	);
	