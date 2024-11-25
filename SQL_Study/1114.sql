-- DDL : CREATE, ALTER, DROP
-- 테이블 생성
-- CREATE TABLE [테이블명](
-- 	  [컬럼명1] [자료형(길이)], 
-- 	  [컬럼명2] [자료형(길이)],
-- 	  ...
--    CONSTRAINT [제약조건명][제약조건]
-- );

-- 도서들을 저장하는 테이블 생성
-- 도서들 중 필요한 정보들(도서명, 저자, 출판사, 가격, 등록일)
CREATE TABLE book_t(
	b_idx BIGINT auto_increment,
    title CHAR(100),
    author VARCHAR(50),
    press VARCHAR(50),
    price DECIMAL(9,1),
    CONSTRAINT book_t_pk PRIMARY KEY(b_idx)
    );
    
-- 테이블 수정(컬럼추가)
-- 등록일 컬럼을 추가한다
-- ALTER TABLE book_t
-- ADD COLUMN reg_date DATE;
-- 등록일 컬럼을 press컬럼 두이ㅔ 추가할 때는 다음과 같다.
ALTER TABLE book_t
ADD reg_date DATE NULL AFTER press;

-- 테이블 수정(컬럼의 자료형 변경)
-- 제목의 자료형 길이를 200으로 변경하고자 한다.
ALTER TABLE book_t
MODIFY title CHAR(200);

-- 테이블 수정(컬럼명 변경)
-- title 컬럼명을 subject로 변경하자
ALTER TABLE book_t
RENAME column title TO subject;

-- 테이블 수정(컬럼 삭제)
-- 출판사(press) 정보는 삭제하자!
ALTER TABLE book_T
DROP column press;

-- 회원정보(member_t)를 저장하는 테이블이 필요한 상황이다.
-- 정보는 회원명, 이메일, 연락처가 필요함!
CREATE TABLE member_t(
	  m_idx BIGINT auto_increment,
      m_name VARCHAR(50),
      m_email VARCHAR(100),
      m_phone VARCHAR(20),
      CONSTRAINT member_t_pk PRIMARY KEY(m_idx)
);  

-- 데이터 추가(INSERT)
-- [구성]
-- INSERT INTO[테이븖명](컬럼명1, 컬럼명2, ..., 컬럼명n)
-- VALUES(값1, 값2, ..., 값n);
-- 주의해야할 점은 명시한 컬럼의 수와 지정한 값의 수가 일치해야 한다.
-- 예) 회원정보를 추가해 보자
INSERT INTO member_t(m_name, m_email, m_phone)
VALUES('마루치','maru@korea.com', '010-1234-5678');

SELECT * FROM member_t;

INSERT INTO member_t(m_name)
VALUES('이도');
-- 위는 사실 ㅡm_email이 NOT NULL이라는 제약조건을 가지므로
-- 저장시 생략하면 안되는 것이지만 MySQL이 공백으로 채워서 추가를 수행했다.(나는 추가가 안됨)

-- 회원등록날짜를 저장하는 컬럼을 추가하려면
ALTER TABLE member_t
ADD write_date DATE null;

-- member_t에서 write_date라는 컬럼을
-- reg_date로 변경하고자 한다.
ALTER TABLE member_t
RENAME column write_date TO reg_date;

-- 데이터 수정(UPDATE)
-- [구성]
-- UPDATE [테이블명]
-- SET [변경하고자하는 컬럼명] = [변경할 값]
-- WHERE [조건식];

UPDATE member_t
SET m_email = 'lee@korea.com', 
	m_phone = '010-1221-3445'
WHERE m_idx = 2;

-- 이도의 이름을 '을불'로 변경하시오
UPDATE member_t
SET m_name = '을불'
WHERE m_idx = 2;

-- 회원번호가 2번인 회원의 이름을 '이도', 이메일은 'leeDo@korea.com'으로 변경하시오!
UPDATE member_t
SET m_name = '이도', 
	m_email = 'leeDo@korea.com'
WHERE m_idx = 2;

-- 데이터 삭제
-- [구성]
-- DELETE FROM [테이블명]
-- WHERE [조건식];
-- 예) member_t 테이블에서 m_idx값이 2번인 자원을 삭제하자!
DELETE FROM member_t
WHERE m_idx = 2;

-- 예) 지금은 없지만 가정을 해보고 다음의 조건에 맞는 SQL문을 작성하자!
-- 	  member_t테이블에서 회원번호가 10, 207, 5번인 회원을 삭제하자!
DELETE FROM member_t
WHERE m_idx IN(10,207,5);

-- 계정생성과 권한부여
-- 사용자 계정을 생성하려면 우선 관리자계정(root)으로 로그인이 되어야 한다.
-- 	[구성]
-- 	현재 서버에서만 접속할 수 있는 계정 생성
-- 	CREATE USER '[사용자 계정]'@'localhost'
-- 	IDENTIFIED BY '[비밀번호]';

-- 	지정된 ip영역대에서만 접속할 수 있는 계정 생성
-- 	CREATE USER '[사용자 계정]'@'192.168.%'
-- 	IDENTIFIED BY '[비밀번호]';

-- 	어떤 외부에서든 접속할 수 있는 계정 생성
-- 	CREATE USER '[사용자 계정]'@'%'
-- 	IDENTIFIED BY '[비밀번호]';

CREATE USER 'test_admin'@'%'
IDENTIFIED BY '1111';

-- 계정이 생성되었지만 my_db에 접속조차 할 수가 없다.
-- 이유는 권한이 없기 때문이다. 권한을 부여해보자!

-- 모든 DB의 모든 객체에 대한 모든 권한을 주는 것
-- GRANT all PRIVILEGES ON *.* TO '[계정명]'@'[호스트]';

-- my_db의 모든 객체에 대한 SELECT와 INSERT 권한만 주는 것
-- GRANT SELECT, INSERT PRIVILEGES ON my_db.* TO '[계정명]'@'[호스트]';

SELECT CURRENT_USER();

SHOW GRANTS FOR 'root'@'localhost';

-- 우린 test_admin에게 my_db의 모든 객체들에게 모든 권한을 부여하자!
GRANT all privileges on my_db.* TO 'test_admin'@'%';

FLUSH PRIVILEGES;

-- 권한 회수 
-- [구성]
-- REVOKE all ON my_db.* FROM '[계정명]'@'[호스트]';

-- test_admin 계정에 부여한 권한을 회수하자!
REVOKE all ON my_db.* FROM 'test_admin'@'%';
