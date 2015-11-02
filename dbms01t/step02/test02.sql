/* 주제: null 옵션
 */

-- 1) 테이블 생성
create table test09 (
  email varchar(100),
  name  varchar(20), /* NULL 여부를 지정하지 않으면 기본이 NULL 허용!*/
  age   int,
  tel   varchar(20),
  constraint test09_pk primary key (email)
);

-- PK 컬럼은 기본이 NOT NULL이다.
insert into test09(email) values('aaa@test.com');
  
-- 2) null 옵션 지정하기
create table test10 (
  email varchar(100),
  name  varchar(20) not null,
  age   int,
  tel   varchar(20) not null,
  constraint test10_pk primary key (email)
);

-- NOT NULL 컬럼의 값은 모두 채워야 한다.
insert into test10(email) values('aaa@test.com'); -- 오류!
insert into test10(email,name,tel) values('aaa@test.com', null, null); -- 오류!

insert into test10(email,name,tel) values('aaa@test.com','aaa','111');


-- tel을 not null에서 null 허용으로 변경하라!
alter table test10
  modify column tel varchar(20) null;




