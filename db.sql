create table assessment(
     question_id int not null auto_increment,
     assessment_id varchar(255),
     question varchar(10240) not null,
     option1 varchar(1024) not null,
     option2 varchar(1024) not null,
     option3 varchar(1024),
     option4 varchar(1024),
     correct_answer int not null,
     marks int,
     primary key(question_id)
     );
create table project(
	id int not null auto_increment,
	name varchar(1024) not null,
	description varchar(10240),
	status_id int not null,
	duration int,
	due_date date not null,
	owner int not null,
	assessment_id int,
	positions int,
	pay int,
	primary key(id)
);



create table skills(
	id int not null auto_increment,
	name varchar(255) not null,
	primary key(id)
);


create table project_skills(
	project_id int not null,
	skill_name varchar(255) not null
);
     
create table assessment_result(
		user_id varchar(255),
		assessment_id varchar(255),
		result float(4,2),
		primary key (user_id,assessment_id),
		FOREIGN KEY (user_id) REFERENCES user(user_id)
	);
