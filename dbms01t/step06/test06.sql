/* 연습
 */

/* 1) 다음과 같이 강의 정보를 출력하라!
 * - 강의번호,강의명,매니저명(직급명),강의분류명,강의실명
 */

select le.lno,le.title,concat(ma.name,'(',lv.name,')'),ca.name,cl.name
from lectures le 
  left outer join managers ma on le.mno=ma.mno
  left outer join lvl_code lv on ma.level=lv.lid
  left outer join cat_code ca on le.categ=ca.ctid 
  left outer join classes cl on le.cid=cl.cid;
      
/* 2) 서브 쿼리를 이용하여 매니저 이름과 직급을 출력하라 */
select 
  m.mno,
  m.name,
  m.level,
  (select name from lvl_code where lid=m.level) as position
from managers m;
      
/* 3) 직급이 사원인 매니저가 담당하는 모든 강의를 출력하라 */
select l.lno,l.title,l.categ
from lectures l
where l.mno in (select mno from managers where level = 'LC002');
      

      
      
      
      
      
      
      