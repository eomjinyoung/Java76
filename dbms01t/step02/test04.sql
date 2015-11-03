/* 주제: candidate key 지정하기 
 * => 비록 PK는 아니지만 PK처럼 중복되어서는 안되는 컬럼을 설정하는 방법
 * => unique 옵션!
 */

-- 1) 테이블 생성
create table test12 (
  email varchar(100),
  name  varchar(20) not null default '홍길동', 
  age   int default 20,
  tel   varchar(20),
  constraint test12_pk primary key (email),
  constraint test12_uq unique (tel)
);

-- 데이터 입력
insert into test12(email, tel) values('aaa@test.com', '1111');
insert into test12(email, tel) values('bbb@test.com', '2222');

-- 2) 컬럼 선언할 때 unique를 지정할 수 있다.
create table test13 (
  email varchar(100),
  name  varchar(20) not null default '홍길동', 
  age   int default 20,
  tel   varchar(20) unique,
  constraint test12_pk primary key (email)
);

insert into test13(email, tel) values('aaa@test.com', '1111');
insert into test13(email, tel) values('bbb@test.com', '2222');
insert into test13(email) values('ccc@test.com');
insert into test13(email) values('ddd@test.com');

drop table test01;
drop table test02;
drop table test03;
drop table test04;
drop table test05;
drop table test06;
drop table test07;
drop table test08;
drop table test09;
drop table test10;
drop table test11;
drop table test12;

