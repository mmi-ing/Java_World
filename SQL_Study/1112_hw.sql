Select * from emp;

-- 문제 1
-- emp테이블에서 급여가2000이상인 사원의 정보를 사원번호,이름,직종,급여를 출력하는 SELECT 문장을 작성하시오.
SELECT empno, ename, job, sal
FROM emp
WHERE sal >= 2000;

-- 문제 2
-- emp테이블에서 사원번호가7788인 사원의 이름과 부서번호를 출력하는 SELECT 문장을 작성하시오.
SELECT ename, deptno
FROM emp
WHERE empno = 7788;

-- 문제 3
-- emp테이블에서 입사일이1980-2-1과1981-5-31사이에 입사한 사원의 이름,업무,입사일을 출력하는 SELECT 문장을 작성하시오. 단 입사일이 최근인 사원부터 출력하시오.
SELECT ename, job, hiredate
FROM emp
WHERE hiredate BETWEEN '1980-02-01' AND '1981-05-31';

-- 문제 4
-- emp테이블에서 부서번호가 10,20인 사원의 모든 정보를 출력하는 SELECT 문장을 작성하시오. 단 이름순으로 정렬하여라.
SELECT * FROM emp
WHERE deptno = 10 OR deptno = 20
ORDER BY ename; -- ASC

-- 문제 5
-- emp테이블에서 급여가3000이상이고 부서번호가20,10인 사원의 이름과 급여를 출력하는 SELECT 문장을 작성하여라.
-- 단 컬럼명을 Employee와 EmpSalary로 출력하여라.
SELECT ename AS Employee, sal AS EmpSalary, deptno
FROM emp
WHERE deptno IN (10, 20) AND sal >= 3000;

-- 문제 6
-- emp테이블에서 1982년에 입사한 사원의 모든 정보를 출력하는 SELECT 문을 작성하여라.
SELECT * FROM emp
WHERE hiredate Like '1982%';

-- 문제 7
-- emp테이블에서 보너스에 NULL이 아닌 사원의 모든 정보를 출력하는 SELECT 문을 작성하여라.
SELECT * FROM emp
WHERE comm LIKE '%';

SELECT * FROM emp WHERE comm IS NOT NULL;

-- 문제 8
-- emp테이블에서 직종이 CLERK이거나 ANALYST이고 급여가 1000,3000,5000이 아닌(not) 모든 사원의 정보를 출력하는 SELECT 문을 작성하여라.
SELECT * FROM emp
WHERE (job = 'CLERK' OR job = 'ANALYST') 
AND sal NOT IN (1000, 3000, 5000);

-- 문제 9
-- 각 사원들의 근무 월수를 알고자 한다. 사원들의 정보들 중 사번,이름,입사일,근무월수 순으로 출력! 
-- 단, date_format을 사용하여 결과를 내야 한다.
SELECT empno, ename, hiredate, period_diff(date_format(Now(), '%Y%m'), date_format(hiredate, '%Y%m')) AS workMonth
FROM emp


-- 문제 10
-- 현재날짜를 먼저 출력한 후 현재날짜만 년/월/일 형식으로 출력하여 컬럼명을 c_date로 수정하여 출력하고,이어서 시:분:초 형식으로 출력하여 컬럼명을 c_time이라는 명칭으로 출력하여라.
SELECT now(), date_format(now(), '%Y/%m/%d') as c_date, date_format(now(), '%H:%i:%s') as c_time;