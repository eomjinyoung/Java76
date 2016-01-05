/* 직급 코드 등록 */
insert into LVL_CODE values('LC001', '사원'); 
insert into LVL_CODE values('LC002', '주임'); 
insert into LVL_CODE values('LC003', '대리'); 
insert into LVL_CODE values('LC004', '과장'); 
insert into LVL_CODE values('LC005', '차장'); 
insert into LVL_CODE values('LC006', '부장'); 

/* 매니저 등록 */
insert into MANAGERS(NAME,PHOT,EMAIL,TEL,LEVEL)
values('홍길동','temp.png','hong@test.com','111-1111','LC001');
insert into MANAGERS(NAME,PHOT,EMAIL,TEL,LEVEL)
values('임꺽정','temp.png','leem@test.com','111-1112','LC001');
insert into MANAGERS(NAME,PHOT,EMAIL,TEL,LEVEL)
values('유관순','temp.png','yoo@test.com','111-1113','LC002');
insert into MANAGERS(NAME,PHOT,EMAIL,TEL,LEVEL)
values('안중근','temp.png','ahn@test.com','111-1114','LC002');

/* 강의 분류 코드 등록 */
insert into CAT_CODE values('CT-JA', 'JAVA');
insert into CAT_CODE values('CT-C0', 'C');
insert into CAT_CODE values('CT-CP', 'C++');
insert into CAT_CODE values('CT-C#', 'C#');
insert into CAT_CODE values('CT-LI', 'LINUX');
insert into CAT_CODE values('CT-AN', 'ANDROID');

/* 강의실 등록 */
insert into CLASSES values('KN301', '강남301호');
insert into CLASSES values('KN302', '강남302호');
insert into CLASSES values('KN303', '강남303호');
insert into CLASSES values('KN401', '강남401호');
insert into CLASSES values('KN402', '강남402호');
insert into CLASSES values('KN403', '강남403호');
insert into CLASSES values('KN501', '강남501호');
insert into CLASSES values('KN502', '강남502호');
insert into CLASSES values('KN503', '강남503호');
insert into CLASSES values('JR701', '종로701호');
insert into CLASSES values('JR702', '종로702호');
insert into CLASSES values('JR703', '종로703호');

/* 강의실 사진 */
insert into PHOTOES(CID,PHOT) values('KN301','kn301_1.png');
insert into PHOTOES(CID,PHOT) values('KN301','kn301_2.png');
insert into PHOTOES(CID,PHOT) values('KN302','kn302_1.png');
insert into PHOTOES(CID,PHOT) values('KN303','kn303_1.png');
insert into PHOTOES(CID,PHOT) values('KN303','kn303_2.png');
insert into PHOTOES(CID,PHOT) values('KN303','kn303_3.png');
insert into PHOTOES(CID,PHOT) values('JR701','jr701_1.png');
insert into PHOTOES(CID,PHOT) values('JR702','jr701_1.png');
insert into PHOTOES(CID,PHOT) values('JR703','jr701_1.png');

