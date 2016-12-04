CREATE TABLE DEVELOPERS (
IMP_ID NUMBER PRIMARY KEY,
FORNAME VARCHAR2(20),
SURNAME VARCHAR2(20) NOT NULL,
DATE_OF_EMP DATE NOT NULL,
POS_IN_PROJECT VARCHAR2(20),
CONSTRAINT CHECK_CORRECT_DATE CHECK 
(DATE_OF_EMP <= '10-OCT-2016'));
 
CREATE TABLE SKILLS (
IMP_ID NUMBER(10) NOT NULL,
SKILL VARCHAR(15)  NOT NULL,
CONSTRAINT FK_SKILLS FOREIGN KEY (IMP_ID) REFERENCES DEVELOPERS (IMP_ID),
CONSTRAINT PK_SKILLS PRIMARY KEY (SKILL));

    
 
CREATE TABLE PROJECTS (
IMP_ID NUMBER(4) NOT NULL,
PROJECT_NAME VARCHAR2(10)  NOT NULL,
PROJECT_DESC VARCHAR2(10),
Q_EMP NUMBER(5),
PROFIT NUMBER(6)  NOT NULL,
SKILL VARCHAR2(15)  NOT NULL,
CONSTRAINT FK_PROJECTS_DEV FOREIGN KEY (IMP_ID) REFERENCES DEVELOPERS (IMP_ID),
CONSTRAINT FK_SKILLS_SK FOREIGN KEY (SKILL) REFERENCES SKILLS (SKILL),
CONSTRAINT PK_PROJECTS PRIMARY KEY (PROJECT_NAME),
PRIMARY KEY (PROFIT));

ALTER TABLE PROJECTS
ADD CONSTRAINT PK_PROJECTS1 PRIMARY KEY (PROJECT_NAME, PROFIT);



CREATE TABLE CUSTOMERS (
CUST_ID NUMBER(4),
PROJECT_NAME VARCHAR2(10) NOT NULL,
PROFIT NUMBER(6),
CONSTRAINT FK_CUSTOMERS FOREIGN KEY (PROJECT_NAME, PROFIT) REFERENCES PROJECTS (PROJECT_NAME, PROFIT),
CONSTRAINT PK_CUSTOMERS PRIMARY KEY (CUST_ID));
 
CREATE TABLE COMPANIES (
IT_COMP_NAME VARCHAR2(10),
PROJECT_NAME VARCHAR2(10) NOT NULL,
PROFIT NUMBER(6) NOT NULL,
CUST_ID NUMBER(4) UNIQUE,
CONSTRAINT PK_COMPANIES PRIMARY KEY (IT_COMP_NAME),
CONSTRAINT FK_COMPANIES FOREIGN KEY (PROJECT_NAME, PROFIT) REFERENCES PROJECTS (PROJECT_NAME, PROFIT),
CONSTRAINT FR_COMPANIES_TWO FOREIGN KEY (CUST_ID) REFERENCES CUSTOMERS (CUST_ID));

ALTER TABLE DEVELOPERS
ADD SALARY NUMBER (7);

ALTER TABLE PROJECTS
ADD COST NUMBER (7);

INSERT ALL
INTO DEVELOPERS (IMP_ID,FORNAME,SURNAME,DATE_OF_EMP,POS_IN_PROJECT,SALARY)
VALUES(0001,'PETER','PETROV','12-DEC-2015','C++DEV',2000)
INTO DEVELOPERS (IMP_ID,FORNAME,SURNAME,DATE_OF_EMP,POS_IN_PROJECT,SALARY)
VALUES(0002,'KATE','PETROVA','15-SEP-2013','FRONT_END_DEV',2040)
INTO DEVELOPERS (IMP_ID,FORNAME,SURNAME,DATE_OF_EMP,POS_IN_PROJECT,SALARY)
VALUES(0003,'LARISSA','IVANOVA','09-SEP-2015','QA_MANUAL',1400)
INTO DEVELOPERS (IMP_ID,FORNAME,SURNAME,DATE_OF_EMP,POS_IN_PROJECT,SALARY)
VALUES(0004,'KATIA','ZAICHENKO','08-SEP-2013','QA-AUTOMATION',1600)
INTO DEVELOPERS (IMP_ID,FORNAME,SURNAME,DATE_OF_EMP,POS_IN_PROJECT,SALARY)
VALUES(0005,'IVAN','KUZNETSOV','12-JUN-2014','JAVA_DEV',2600)
INTO DEVELOPERS (IMP_ID,FORNAME,SURNAME,DATE_OF_EMP,POS_IN_PROJECT,SALARY)
VALUES(0006,'ALEX','RAZUMOVSKIY','25-DEC-2012','BA',2000)
INTO DEVELOPERS (IMP_ID,FORNAME,SURNAME,DATE_OF_EMP,POS_IN_PROJECT,SALARY)
VALUES(0007,'PAVEL','PETROV','08-AUG-2011','JS_DEV',3000)
SELECT 1 FROM DUAL;

INSERT ALL
INTO SKILLS (IMP_ID,SKILL)
VALUES(0001,'MANUAL_TEST')
INTO SKILLS (IMP_ID,SKILL)
VALUES(0002,'AUTOMATION_TEST')
INTO SKILLS (IMP_ID,SKILL)
VALUES(0003,'JS_DEV')
INTO SKILLS (IMP_ID,SKILL)
VALUES(0004,'JAVA_DEV')
INTO SKILLS (IMP_ID,SKILL)
VALUES(0005,'C_DEV')
INTO SKILLS (IMP_ID,SKILL)
VALUES(0006,'DEV-OPPS')
INTO SKILLS (IMP_ID,SKILL)
VALUES(0007,'BA')
INTO SKILLS (IMP_ID,SKILL)
VALUES(0004,'DBA')
INTO SKILLS (IMP_ID,SKILL)
VALUES(0005,'ENGLISH')
SELECT 1 FROM DUAL;

INSERT ALL
INTO PROJECTS (IMP_ID,PROJECT_NAME,PROJECT_DESC,Q_EMP,PROFIT,SKILL,COSTS)
VALUES(0002,'BANK2','INTEGRATION',30,30000,'MANUAL_TEST',43000)
INTO PROJECTS (IMP_ID,PROJECT_NAME,PROJECT_DESC,Q_EMP,PROFIT,SKILL,COSTS)
VALUES(0007,'TRAVEL1','ENGLISH_TRAV',10,20000,'MANUAL_TEST',53000)
INTO PROJECTS (IMP_ID,PROJECT_NAME,PROJECT_DESC,Q_EMP,PROFIT,SKILL,COSTS)
VALUES(0005,'TRAVEL2','SCOTISH_TRAV',15,12000,'JAVA_DEV',23000)
INTO PROJECTS (IMP_ID,PROJECT_NAME,PROJECT_DESC,Q_EMP,PROFIT,SKILL,COSTS)
VALUES(0003,'BANK3','IRELAND',15,12000,'MANUAL_TEST',53000)
INTO PROJECTS (IMP_ID,PROJECT_NAME,PROJECT_DESC,Q_EMP,PROFIT,SKILL,COSTS)
VALUES(0007,'BANK1','ACCOUNTING',20,20000,'MANUAL_TEST',93900)
SELECT 1 FROM DUAL;

INSERT ALL
INTO CUSTOMERS (CUST_ID,PROJECT_NAME,PROFIT)
VALUES(3001,'BANK2',30000)
INTO CUSTOMERS (CUST_ID,PROJECT_NAME,PROFIT)
VALUES(3002,'TRAVEL1',20000)
INTO CUSTOMERS (CUST_ID,PROJECT_NAME,PROFIT)
VALUES(3003,'BANK3',12000)
SELECT 1 FROM DUAL;

INSERT ALL
INTO CUSTOMERS (CUST_ID,PROJECT_NAME,PROFIT)
VALUES(3004,'BANK1',20000)
INTO CUSTOMERS (CUST_ID,PROJECT_NAME,PROFIT)
VALUES(3005,'TRAVEL2',12000)
SELECT 1 FROM DUAL;

INSERT ALL 
INTO COMPANIES (IT_COMP_NAME,PROJECT_NAME,PROFIT,CUST_ID)
VALUES('COMPANY_ONE','BANK2',30000,3001)
INTO COMPANIES (IT_COMP_NAME,PROJECT_NAME,PROFIT,CUST_ID)
VALUES('COMPANY_TWO','BANK3',12000,3003)
INTO COMPANIES (IT_COMP_NAME,PROJECT_NAME,PROFIT,CUST_ID)
VALUES('COMPANY_TWO','TRAVEL1',20000,3002)
INTO COMPANIES (IT_COMP_NAME,PROJECT_NAME,PROFIT,CUST_ID)
VALUES('COMPANY_ONE','TRAVEL2',12000,3005)
INTO COMPANIES (IT_COMP_NAME,PROJECT_NAME,PROFIT,CUST_ID)
VALUES('COMPANY_ONE','BANK1',20000,3004)
SELECT 1 FROM DUAL;

ALTER TABLE COMPANIES 
DROP CONSTRAINT PK_COMPANIES;