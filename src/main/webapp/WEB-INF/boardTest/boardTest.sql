show tables;

desc test;

select * from test;

insert into test values ('kms','4321',29,'여','청주');
insert into test values ('abc','4321',39,'남','광주');
insert into test values ('bcd','4321',49,'여','제주');
insert into test values ('cde','4321',22,'남','서울');
insert into test values ('atom','4321',32,'여','청주');
insert into test values ('btom','4321',42,'남','광주');
insert into test values ('ctom','4321',52,'여','인천');
insert into test values ('dtom','1234',23,'중','서울');

update test set age = 39 where mid='dtom';

select * from test where gender = '남';
select * from test where gender = '남' and age >= 30 and age < 40;
select * from test where gender = '남' and (age >= 30 and age < 40);
select * from test where gender = '남' and age between 30 and 40;
select * from test where (gender = '남' or gender = '여') and age between 30 and 40;
select * from test where age between 30 and 40;

delete from test where mid='dtom';

select * from test order by mid desc;

/*
  여러줄 주석....
  여러줄 주석2...
  명령어 뒤에 주석 달을때 사용...
*/

-- boardTest 테이블 설계
create table boardTest (
  idx		int not null auto_increment,	/* 게시글의 고유번호 */
  name  varchar(20) not null, 				/* 게시글 올린이 성명 */
  title varchar(100) not null,				/* 게시글 제목 */
  content text  not null,							/* 게시글 내용 */
  wDate datetime default now(),				/* 글쓴 날짜(기본값은 현재 날짜/시간) */
  readNum int default 0,							/* 글 조회수 */
  hostIp	varchar(40) not null,				/* 글 올린이의 접속 IP */
  primary key(idx)										/* 기본키 : 고유번호(idx) */
);

desc boardTest;

insert into boardTest values (default,'관리자','게시판 서비스를 시작합니다.','즐거운 게시판 생활하기','192.168.50.20',default,default);

select * from boardTest;
select * from boardTest order by idx desc;
