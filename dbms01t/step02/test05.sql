/* 주제: 자동 증가 컬럼 설정 
 * => 자동 증가 컬럼 반드시 PK이어야 한다. 일반 컬럼 불가!
 */

-- 테이블 생성
-- unique 컬럼은 자동으로 not null로 설정되지 않는다. 명시해야 한다.
create table test14 (
  no    int primary key auto_increment,
  email varchar(100) not null unique,
  name  varchar(20) not null default '홍길동', 
  age   int default 20,
  tel   varchar(20) unique
);

-- 데이터 입력
insert into test14(email) values('aaa@test.com');
insert into test14(email) values('bbb@test.com');

-- 테이블 정의2
create table test15 (
  no    int,
  email varchar(100) not null,
  name  varchar(20) not null default '홍길동', 
  age   int default 20,
  tel   varchar(20)
);

alter table test15
  add constraint tests15_pk primary key(no);

alter table test15
  add constraint test15_uq1 unique(email);
  
alter table test15
  add constraint test15_uq2 unique(tel);

alter table test15
  modify column no int auto_increment;
  
insert into test15(email) values('aaa@test.com');
insert into test15(email) values('bbb@test.com');  
insert into test15(email) values('ccc@test.com'); 
delete from test15 where no=2;
insert into test15(email) values('ddd@test.com');  
delete from test15 where no=4;  
insert into test15(email) values('eee@test.com');  
  
  