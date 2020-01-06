create table t_student
(
	studentId bigint auto_increment,
	studentName varchar(255) null,
	studentAge int null,
	constraint t_student_pk
		primary key (studentId)
);

