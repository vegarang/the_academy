CREATE TABLE screenshots{
	id		int PRIMARY KEY NOT NULL,
	userid		varchar(30) NOT NULL,
	location	text NOT NULL,
	comment		text,
	title		varchar(100),
	url		text,
	created		date
};
