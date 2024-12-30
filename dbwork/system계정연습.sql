-- 시스템에 등록된 테이블 확인
-- 커서가 있는 SQL 문 실행 단축키: Ctrl+Enter
SELECT * FROM tab;

-- 등록된 사용자(계정) 확인
SELECT username FROM dba_users; -- dba_users 테이블에서 username 컬럼만 확인

-- dba_users 테이블의 구조 확인 (데이터는 확인되지 않음)
DESC dba_users; 

-- 계정과 잠금 상태 알아보기
SELECT username, account_status FROM dba_users;

-- SCOTT 계정을 생성 (비밀번호: TIGER)
-- 오류 발생: Oracle 12버전부터 규칙 적용
CREATE USER scott IDENTIFIED BY tiger;

-- 12버전부터는 사용자 이름에 공통 문자열 "C##"가 포함되어야 함
-- C##SCOTT 계정을 생성 (비밀번호: TIGER)
CREATE USER c##scott IDENTIFIED BY tiger;

-- C##SCOTT 계정을 삭제 후 공통 문자열 없이 생성하는 방법 적용
DROP USER c##scott;

-- 세션 설정 변경
ALTER SESSION SET "_ORACLE_SCRIPT"=TRUE; -- 공통 문자열 규칙 무시

-- 공통 문자열 없이 SCOTT 계정 생성 (비밀번호: TIGER)
CREATE USER scott IDENTIFIED BY tiger;

-- ANGEL 계정 생성 (비밀번호: A1234)
CREATE USER angel IDENTIFIED BY a1234;

-- 계정과 잠금 상태 확인
SELECT username, account_status FROM dba_users;

-- ANGEL 계정 잠금 설정
ALTER USER angel ACCOUNT LOCK;

-- ANGEL 계정 잠금 해제
ALTER USER angel ACCOUNT UNLOCK;

-- 기본 권한 부여 (CONNECT: 접속 권한, RESOURCE: 데이터 관리 권한)
GRANT connect, resource TO angel;
GRANT connect, resource TO scott;

-- 테이블 생성 및 데이터 추가 시 테이블 스페이스 관련 오류 방지
-- 테이블 스페이스를 무제한으로 설정 (SYSTEM 계정에서만 가능)
ALTER USER angel DEFAULT TABLESPACE users QUOTA UNLIMITED ON users;
ALTER USER scott DEFAULT TABLESPACE users QUOTA UNLIMITED ON users;

-- ANGEL 계정 비밀번호 변경 (A1234 -> PW1234)
ALTER USER angel IDENTIFIED BY pw1234;

