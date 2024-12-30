-- emp 테이블로 연습
-- job 컬럼의 데이터 중 중복되는 데이터 한번만 출력
SELECT DISTINCT JOB FROM emp;
SELECT DISTINCT job,ename FROM emp;
SELECT * FROM emp; --전체 컬럼데이타 조회
SELECT ename,job FROM emp;
-- ename 의 오름차순 조회(asc 인경우는 생략)
SELECT ename,job FROM emp ORDER BY ename; 
-- ename의 내림차순 조회(desc 인경우는 생략안됨)
SELECT ename,job FROM emp ORDER BY ename DESC;

-- job을 오름차순, 같은 job일 경우는 ename 내림차순 조회
SELECT job,ename FROM emp ORDER BY job,ename DESC;
-- job을 오름차순, 같은 job일 경우는 ename 오름차순 조회
SELECT job,ename FROM emp ORDER BY job,ename;
-- 순서를 정할때 컬럼명 대신 컬럼 번호로 해도 됨 (첫번째 컬럼은 1)
SELECT job,ename FROM emp ORDER BY 1,2; 

-- sal 오름차순 정렬
SELECT * FROM emp order by 6;
SELECT * FROM emp order by sal;

-- empno 오름차순 조회
SELECT ename, sal, comm, job, empno FROM emp ORDER BY 5;
SELECT ename, sal, comm, job, empno FROM emp ORDER BY empno;

-- ename 내림차순
SELECT ename, sal, comm, job, empno FROM emp ORDER BY 1 DESC;
SELECT ename, sal, comm, job, empno FROM emp ORDER BY ename DESC;

-- where 조건문
SELECT ename, job, sal, comm FROM emp WHERE sal >= 1500;
SELECT ename, job, sal, comm FROM emp WHERE ename = 'allen'; --데이타는 대소문자 정확히 써야한다
SELECT ename, job, sal, comm FROM emp WHERE ename = 'ALLEN'; 

-- ename이 A로 시작하는 데이터 조회
SELECT ename, job, sal, comm FROM emp WHERE ename LIKE 'A%';
-- ename에 A가 포함되는 데이터 조회
SELECT ename, job, sal, comm FROM emp WHERE ename LIKE '%A%';
-- ename에 A로 시작하거나 S로 시작하는 데이터 조회
SELECT ename, job, sal, comm FROM emp WHERE ename LIKE 'A%' OR ename LIKE 'S%';
-- ename에 A와 S를 모두 포함하는 데이터만 출력
SELECT ename, job, sal, comm FROM emp WHERE ename LIKE '%A%' AND ename LIKE '%S%';

-- ename의 두번째 글자가 A인 사람만 조회
SELECT ename, job, sal, comm FROM emp where ename LIKE '_A%' ORDER BY SAL;
-- ename의 두번째 글자가 A이거나 세번째가 A 인사람만 조회
SELECT ename, job, sal, comm FROM emp where ename LIKE '_A%' OR ENAME LIKE '__A%';

-- ename이 N이나 K 로 끝나는 사람만 조회
SELECT ename, job, sal, comm FROM emp WHERE ENAME LIKE '%N' OR ENAME LIKE '%K';

-- job 이 ANALYST이면서 sal 이 1500 이상인 사람 조회
SELECT ename, job, sal, comm FROM emp WHERE JOB = 'ANALYST' AND SAL >= 1500;

-- sal 1200~2000 사이값 조회
SELECT ename, job, sal, comm FROM emp WHERE SAL > 1200 AND SAL <= 2000;
SELECT ename, job, sal, comm FROM emp WHERE SAL BETWEEN 1200 AND 2000;

-- job이 MANAGER, SALESMAN, ANALYST 이 3가지 직업의 사람을 조회
SELECT ename, job, sal, comm FROM emp WHERE JOB = 'MANAGER' OR JOB = 'SALESMAN' OR JOB = 'ANALYST';
SELECT ename, job, sal, comm FROM emp WHERE JOB IN ('MANAGER','SALESMAN','ANALYST’);

-- EMPNO 가 7654,7788,7844,7902인 사람만 조회(IN 을 이용해서)
SELECT EMPNO, ename, job, sal, comm FROM emp WHERE EMPNO IN (7654, 7788, 7844, 7902);

-- COMM 이 NULL 인 데이터만 조회
SELECT ename, job, sal, comm FROM emp WHERE COMM IS NULL;

-- COMM 이 NULL이 아닌 경우 데이터만 조회
SELECT ename, job, sal, comm FROM emp WHERE COMM IS NOT NULL;

-- MGR 이 NULL이 아닌 경우만 조회
SELECT * FROM emp WHERE mgr IS NOT NULL;

-- comm이 null 인 경우는 0으로 출력, mgr은 null인경우 100으로
SELECT ename, job, sal, NVL(mgr, 100), NVL(comm, 0) FROM emp;

-- comm이 null 일 경우 sal+comm 도 null
SELECT sal,comm, sal+comm FROM emp; 
-- 위의 경우 sal+comm 이경우 comm이 null 이면 0으로 계산
SELECT sal,comm, sal+NVL(comm, 0) FROM emp; 

-- 컬럼제목에 별칭 (alias)
-- 생략없이 alias 지정하는 방법
SELECT ename AS "사원명", sal AS "월급여" FROM emp; 
-- as 생략하고 alias 지정하는 방법
SELECT ename "사원명", sal "월급여" FROM emp; 
-- alias에 공백이 없는 경우는 "" 도 생략가능
SELECT ename 사원명, sal 월급여 FROM emp;
-- 중간에 공백이 있는경우 "" 반드시 넣어야함
SELECT ename "사원 이름", sal "월 급여" FROM emp;

-- 총 레코드 갯수(데이터 갯수)
SELECT count(*) FROM emp; -- 이경우는 컬럼명이 count(*)
SELECT count(*) count FROM emp; -- 이경우는 컬럼명이 count
SELECT count(*) 총갯수 FROM emp; -- 이경우는 컬럼명이 총갯수

-- sal+NVL(comm,0)열의 컬럼명은 sum 으로 변경
SELECT sal, comm, sal+NVL(comm, 0) sum FROM emp; 
SELECT sal 월급여, comm 커미션, sal+NVL(comm, 0) 총금액 FROM emp; -- 컬럼명을 한글로

-- 문자열을 컬럼에 추가 시 || 연산자 사용
SELECT '내 이름은 '||ename||'입니다' 자기소개  FROM emp;

-- 내 직업은 salesman이고 내 월 급여는 1600입니다. 라고 컬러명 "자기소개" 에 나오도록 작성
SELECT '내 직업은 '||job||'이고 내 월 급여는 '||sal||'입니다' 자기소개 FROM emp;

-- sal 이 1500~2000 사이가 아닌 경우만 조회
SELECT * FROM emp WHERE sal NOT BETWEEN 1500 AND 2000;

-- NOT IN 을 사용하여 job이 salesman, clerk가 아닌 경우만 조회
SELECT * FROM emp WHERE job NOT IN ('SALESMAN','CLERK');

-- GROUP 함수(COUNT, SUM, AVG, MAX, MIN)
SELECT count(*) FROM emp; -- 전체 데이터 갯수
SELECT sum(sal) FROM emp; -- sal 의 총 합계
SELECT avg(sal) FROM emp; -- sal 의 평균,소숫점 이하가 너무 많이 나옴
SELECT round(avg(sal),2) FROM emp;-- sal 의 평균을 구하는데 소숫점 이하 2자리로 구한다
SELECT max(sal) FROM emp; -- 최고 급여액수
SELECT min(sal) FROM emp; -- 최소 급여액수

-- 평균급여보다 sal 이 더 높은 사람을 조회하시오 (서브쿼리문)
SELECT * FROM emp WHERE sal > (SELECT avg(sal) FROM emp);

-- SCOTT의 직업과 같은 직업을 가진 사람을 조회하시오
SELECT * FROM EMP WHERE JOB = (SELECT JOB FROM EMP WHERE ENAME = 'SCOTT');

-- SCOTT의 MGR과 같은 MGR을 가진 사람
SELECT * FROM EMP WHERE MGR = (SELECT MGR FROM EMP WHERE ENAME = 'SCOTT');

-- GROUP BY
SELECT JOB FROM EMP GROUP BY JOB; --JOB이 그룹별로 나열

-- JOB 의 GROUP 별로 인원수를 구해보자
SELECT JOB, COUNT(*) FROM EMP GROUP BY JOB;

-- 제목에 별칭 부여
SELECT JOB 직업, COUNT(*) 인원수 FROM EMP GROUP BY JOB;

-- JOB 의 GROUP 별로 인원수를 구해보자(인원이 3명이상인경우에만 조회)
SELECT JOB 직업, COUNT(*) 인원수 FROM EMP GROUP BY JOB HAVING COUNT(JOB) >= 3;

-- JOB 의 GROUP 별로 인원수를 구해보자(인원이 3명이상인경우에만 조회)-인원순으로 출력(오름차순)
SELECT JOB 직업, COUNT(*) 인원수 FROM EMP GROUP BY JOB HAVING COUNT(JOB) >= 3 ORDER BY 인원수;
SELECT JOB 직업, COUNT(*) 인원수 FROM EMP GROUP BY JOB HAVING COUNT(JOB) >= 3 ORDER BY 2;

-- 직업별 인원수, 최저연봉, 최고연봉, 평균연봉(소숫점 이하 없이)을 구하시오
SELECT JOB 직업, COUNT(*) 인원수, MIN(SAL) 최저연봉, MAX(SAL) 최고연봉, ROUND(AVG(SAL), 0) 평균연봉 
  FROM EMP GROUP BY JOB ORDER BY 직업;

-- 48페이지 숫자함수
SELECT ABS(-5), ABS(5) FROM DUAL; -- 5  5  절대값출력

--ROUND:반올림,CEIL:무조건올림,FLOOR:무조건내림
SELECT ROUND(3.6, 0), CEIL(3.6), FLOOR(3.6) FROM DUAL; --  4  4  3
SELECT ROUND(3.4, 0), CEIL(3.4), FLOOR(3.4) FROM DUAL; --  3  4  3
SELECT ROUND(328947, -2) FROM DUAL; --328900
SELECT ROUND(328467, -2) FROM DUAL; --328500

SELECT ROUND(AVG(SAL), 0), CEIL(AVG(SAL)), FLOOR(AVG(SAL)) FROM EMP;

-- POWER(M,N) > M^N값을 구함, MOD(M,N) > M // N
SELECT POWER(3, 3), MOD(10, 3) FROM DUAL;--27  1

-- 문자함수 CONCAT(두문자더하기),LOWER(소문자),UPPER(대문자),INITCAP(첫글자만대문자)
SELECT ENAME,CONCAT(ENAME,'님'),LOWER(ENAME),UPPER(ENAME),INITCAP(ENAME) FROM EMP;

SELECT LPAD(SAL,10,'*') FROM EMP; --총 10자리에 남는부분을 * 채움(왼쪽부터채움)
SELECT RPAD(SAL,10,'*') FROM EMP; --총 10자리에 남는부분을 * 채움(오른쪽부터채움)

SELECT SUBSTR('HAPPY DAY',7,3) FROM DUAL;--7번글자부터 3글자 추출
SELECT SUBSTR('HAPPY DAY',-6,3) FROM DUAL;--뒤에서부터 6번째글자부터 3글자 추출

-- EMP 테이블의 ENAME에서 왼쪽에서 3글자를 추출후 총 7자리중 우측 빈공간은 *로 채워서 출력
SELECT RPAD(SUBSTR(ENAME,1,3),7,'*'),SAL FROM EMP;

-- LENGTH  길이구하기
SELECT ENAME 이름, LENGTH(ENAME) 문자길이 FROM EMP;

-- REPLACE > HAPPY 를 GOOD 으로 변경
SELECT REPLACE('HAPPY DAY', 'HAPPY', 'GOOD') FROM DUAL;

-- TRIM > 앞뒤 공백제거
SELECT '*'||'  LEE SU JI  '||'*' FROM DUAL;
SELECT '*'||TRIM('  LEE SU JI  ')||'*' FROM DUAL;--앞뒤 공백이 제거됨

-- 일단 현재 날짜를 나타내는 sysdate
SELECT sysdate FROM dual;--현재 날짜
SELECT sysdate+7 FROM dual; --오늘로부터 7일뒤 날짜
SELECT sysdate+1 FROM dual;--내일 날짜

-- to_char 함수를 이용해서 원하는 날짜 모양으로 출력
SELECT to_char(sysdate,'yyyy-mm-dd') FROM dual; -- 2024-12-30
-- mm: 월  mi: 분  hh: 12시간표시  am/pm :오전/오후 표시
SELECT to_char(sysdate,'yyyy-mm-dd am hh:mi') FROM dual; -- 2024-12-30 오후 04:41
SELECT to_char(sysdate,'yyyy-mm-dd hh24:mi') FROM dual; -- 2024-12-30 16:41
SELECT to_char(sysdate,'month') FROM dual; --12월(지역화에 따라 다르게 나오므로 잘 사용안함)

-- 현재 년도 4자리만 추출
SELECT to_char(sysdate,'yyyy') FROM dual;

-- 현재 월 추출
SELECT to_char(sysdate,'mm') FROM dual;
SELECT to_char(to_date('2024-5-10'),'mm') FROM dual; -- 05

-- emp 의 hiredate 는 날짜타입이다
SELECT to_char(hiredate,'yyyy-mm-dd') 입사일 FROM emp;

