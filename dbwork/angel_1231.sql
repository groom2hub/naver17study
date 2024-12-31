-- 시퀀스를 생성해보자
CREATE SEQUENCE SEQ1; -- 1부터 1씩 자동 증가하는 시퀀스 객체가 생성
CREATE SEQUENCE SEQ2 START WITH 1 INCREMENT BY 1; -- 위와 같다
CREATE SEQUENCE SEQ3 START WITH 1 INCREMENT BY 1 NOCACHE; -- 위와 같으나 CACHE 사이즈를 20에서 0으로 변경
CREATE SEQUENCE SEQ4 START WITH 1 INCREMENT BY 1 MAXVALUE 100 NOCACHE; -- MAX값을 100까지만
CREATE SEQUENCE SEQ5 START WITH 5 INCREMENT BY 5 NOCACHE;
-- 시퀀스 전체 정보를 출력
SELECT * FROM SEQ;

-- 시퀀스 값을 발생 > 한번 발생한 값들은 두번 다시 안나옴
SELECT SEQ1.NEXTVAL, SEQ2.NEXTVAL, SEQ3.NEXTVAL, SEQ4.NEXTVAL, SEQ5.NEXTVAL FROM DUAL;

-- 시퀀스 제거
DROP SEQUENCE SEQ1;
DROP SEQUENCE SEQ2;
DROP SEQUENCE SEQ3;
DROP SEQUENCE SEQ4;
DROP SEQUENCE SEQ5;

-- TABLE 생성
CREATE TABLE TEST1 (
    NUM NUMBER(3) PRIMARY KEY,
    NAME VARCHAR2(20) NOT NULL,
    TODAY DATE);
    
-- 구조 확인
DESC TEST1;

-- 데이터 추가
INSERT INTO TEST1 VALUES (1, 'CANDY', SYSDATE); -- 컬럼명 생략 시 모든 컬럼을 순서대로 값을 넣음
-- PRIMARY KEY에 같은 값을 넣었을 경우 어떤 오류가 나오는지 확인하기
INSERT INTO TEST1 VALUES (1, 'MIRA', SYSDATE);--오류 확인하기 ,무결성 제약조건으로 코드번호가 뜬다
-- 이번에는 이름을 빼고 넣은 후 오류를 확인해보자
INSERT INTO TEST1 (NUM, TODAY) VALUES (2, SYSDATE); -- ORA-01400: NULL을 ("ANGEL"."TEST1"."NAME") 안에 삽입할 수 없습니다

--이번에는 전체 데이타를 넣는데 순서를 바꿔서 넣어보자
INSERT INTO TEST1 (NUM, TODAY, NAME) VALUES (2, '2024-11-20', 'MIRA');

-- INSERT 를 2개 추가한상태에서 ROLLBACK을 해보자
ROLLBACK;
-- 다시 위의 INSERT 문 실행해서 넣어보자. 넣은 후 COMMIT 하기
COMMIT;
-- COMMIT을 한 후 ROLLBACK해도 취소 안됨
ROLLBACK;

-- 데이터 확인
SELECT * FROM TEST1;

-- TEST2는 TEST1 과 같은데 제약조건 이름을 추가해서 생성
CREATE TABLE TEST2(
    NUM NUMBER(3) CONSTRAINT PK_TEST2_NUM PRIMARY KEY,
    NAME VARCHAR2(20) CONSTRAINT NN_TEST2_NAME NOT NULL,
    TODAY DATE);

-- 오류 발생을 시켜보자
INSERT INTO TEST2 VALUES (1, '이영자', SYSDATE); -- 추가됨
INSERT INTO TEST2 VALUES (1, '김말자', SYSDATE); -- 오류 발생, 무결성 제약 조건(ANGEL.PK_TEST2_NUM)에 위배

SELECT * FROM TEST2;

-- 테이블의 구조변경 > ALTER TABLE
-- 컬럼 추가: ADD, 컬럼 삭제: DROP COLUMN, 컬럼 수정: MODIFY,  컬럼명변경: RENAME COLUMN

-- TEST1에 AGE NUMBER(3) 컬럼 추가하기, 일단은 값은 NULL로 들어감
ALTER TABLE TEST1 ADD AGE NUMBER(3);

--  TEST1에 ADDR VARCHAR2(30) 추가하는데 기본값을 SEOUL로 주고싶다면
ALTER TABLE TEST1 ADD ADDR VARCHAR2(30) DEFAULT 'SEOUL';

-- TEST1에 GAIPDAY DATE으로 추가하는데 기본값을 현재날짜로
ALTER TABLE TEST1 ADD GAIPDAY DATE DEFAULT SYSDATE;

-- TEST1의 TODAY 컬럼 삭제
ALTER TABLE TEST1 DROP COLUMN TODAY;

-- TEST1의 NAME의 길이를 20에서 30으로 수정
ALTER TABLE TEST1 MODIFY NAME VARCHAR2(30);

-- TEST1의 ADDR 을 ADDRESS로 컬럼명을 변경
ALTER TABLE TEST1 RENAME COLUMN ADDR TO ADDRESS;

-- TEST1의 GAIPDAY를 WRITEDAY로 이름 변경
ALTER TABLE TEST1 RENAME COLUMN GAIPDAY TO WRITEDAY;

-- TEST1의 제약조건 중 SYS_C008317(임시이름)을 제거
ALTER TABLE TEST1 DROP CONSTRAINT SYS_C008317;

--TEST1에 제약조건을 추가: AGE의 나이범위가 10~30으로, 제약조건명: CK_TEST1_AGE
ALTER TABLE TEST1 ADD CONSTRAINT CK_TEST1_AGE CHECK(AGE >= 10 AND AGE <= 30);

--AGE 에 범위를 벗어나게 추가해서 오류확인하기
INSERT INTO TEST1 (NUM, NAME, AGE) VALUES (3, 'SON', 34); -- 체크 제약조건(ANGEL.CK_TEST1_AGE)이 위배되었습니다

-- 5분 문제
-- 1. TEST2 에 BLOOD VARCHAR2(10) 초기값은 A로 추가
ALTER TABLE TEST2 ADD BLOOD VARCHAR2(10) DEFAULT 'A';
-- 2.TEST2에서 TODAY 컬럼 제거하기
ALTER TABLE TEST2 DROP COLUMN TODAY;
-- 3. TEST2의 NAME을 SAWON_NAME으로 컬럼이름 변경
ALTER TABLE TEST2 RENAME COLUMN NAME TO SAWON_NAME;
-- 4. BLOOD에 제약조건 추가 (A, B, O, AB만 가능하도록 CHECK) CK_TEST2_BLOOD
ALTER TABLE TEST2 ADD CONSTRAINT CK_TEST2_BLOOD CHECK(BLOOD IN ('A', 'B', 'O', 'AB'));
-- 5. NN_TEST2_NAME이라는 제약조건을 제거
ALTER TABLE TEST2 DROP CONSTRAINT NN_TEST2_NAME;

-- 연습용 테이블 제거
DROP TABLE TEST1;
DROP TABLE TEST2;

-------------------------------------------------------------------------
-- 시퀀스 생성
CREATE SEQUENCE SEQ1 NOCACHE; -- 1부터 1씩증가하는 CACHE가 없는 시퀀스 생성
-- 테이블 생성
CREATE TABLE SAWON (
    NUM NUMBER(3) CONSTRAINT PK_SAWON_NUM PRIMARY KEY,
    NAME VARCHAR2(20),
    BUSEO VARCHAR2(20),
    GENDER VARCHAR2(10) DEFAULT '남자',
    AGE NUMBER(3),
    HEIGHT NUMBER(5,1),
    WRITEDAY DATE);
    

-- 제약조건 추가: 부서명은 '홍보부', '교육부', '관리부'만 가능하다 CK_SAWON_BUSEO
ALTER TABLE SAWON ADD CONSTRAINT CK_SAWON_BUSEO CHECK(BUSEO IN ('홍보부', '교육부', '관리부'));

-- 제약조건 추가: 성별은 '남자', '여자' 만 가능하다 CK_SAWON_GENDER
ALTER TABLE SAWON ADD CONSTRAINT CK_SAWON_GENDER CHECK(GENDER IN ('남자', '여자'));

-- 데이타 추가
INSERT INTO SAWON VALUES (SEQ1.NEXTVAL, '이진', '홍보부', '여자', 29, 167.9, SYSDATE);
INSERT INTO SAWON (NUM,NAME,BUSEO,AGE) VALUES (SEQ1.NEXTVAL, '강호동', '관리부', 35);
INSERT INTO SAWON (NUM,NAME,BUSEO,HEIGHT) VALUES (SEQ1.NEXTVAL, '유재석', '홍보부', 178.5);
INSERT INTO SAWON VALUES (SEQ1.NEXTVAL, '송해나', '홍보부', '여자', 31, 159.9, SYSDATE);
INSERT INTO SAWON (NUM, NAME, BUSEO, GENDER, AGE, WRITEDAY) VALUES (SEQ1.NEXTVAL, '이영자', '교육부’, ‘여자', 42, SYSDATE);
COMMIT;

