create table user_account(
 id bigserial not null,
	user_id varchar,
	password varchar,
	firstname varchar,
	lastname varchar,
	age integer,
	date_of_birth varchar,
	gender varchar,
	marital_status varchar,
	nationality varchar,
	status varchar,
	token_holder varchar,
	CONSTRAINT pk_usr_id PRIMARY KEY (id)
	);


	create table account_verification_details (
	    id bigserial not null,
		user_id varchar,
		id_type varchar,
		id_number varchar
	);