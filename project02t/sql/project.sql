-- 프로젝트 테이블 생성
drop table project;
create table project (
  pno    int auto_increment,
  title  varchar(100) not null,
  sdt    datetime not null,
  edt    datetime not null,
  member varchar(100),
  constraint project_pk primary key (pno)
);

-- 샘플 데이터 입력 
insert into project(title,sdt,edt) values('aaaa','2015-1-1','2015-5-5');
insert into project(title,sdt,edt) values('bbbb','2015-2-1','2015-6-5');
insert into project(title,sdt,edt) values('cccc','2015-3-1','2015-7-5');
insert into project(title,sdt,edt) values('dddd','2015-4-1','2015-8-5');

drop table student;
create table student (
  name    varchar(20) not null,
  email   varchar(100) not null,
  tel     varchar(20),
  cid     varchar(20),
  constraint student_pk primary key (email)
);

drop table board;
create table board (
  bno     int not null auto_increment,
  title   varchar(255) not null,
  content text not null,
  views   int default 0,
  cre_dt  datetime not null,
  pwd     varchar(20),
  constraint board_pk primary key (bno)
);

alter table student
  add column pwd varchar(20);
