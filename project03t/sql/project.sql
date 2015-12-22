/* 수강 신청 테이블 */
drop table cour_enroll;
create table cour_enroll (
  email   varchar(100) not null,
  name    varchar(20) not null,
  tel     varchar(20) not null,
  status  int default 0,
  reg_dt  DATETIME,
  constraint cour_enroll_pk primary key (email)
);

