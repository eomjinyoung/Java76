/* 주제: default 값 지정 
 */

-- 1) 테이블 생성
create table test11 (
  email varchar(100),
  name  varchar(20) not null default '홍길동', 
  age   int default 20,
  tel   varchar(20),
  constraint test09_pk primary key (email)
);

-- 데이터 입력
-- 기본 값이 있는 not null 컬럼인 경우, 값을 생락할 수 있다.
insert into test11(email) values('aaa@test.com');
insert into test11(email,name) values('bbb@test.com','임꺽정');


