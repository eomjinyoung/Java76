-- 정렬하기 

-- 1) Ascendent 정렬(오름차순 정렬)
-- 정렬 방식을 지정하지 않으면 기본으로 오름차순 정렬이다.
select bno, title 
from board
order by bno;

-- 오름차순 정렬 방식을 지정할 수 있다.
select bno, title 
from board
order by bno asc;

-- 2) Descendent(내림차순) 정렬
select bno, title 
from board
order by bno desc;


