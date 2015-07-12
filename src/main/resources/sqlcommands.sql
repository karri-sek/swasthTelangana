CREATE DATABASE DEMO;

use DEMO;

DROP TABLE T_PATIENT;

CREATE TABLE T_PATIENT
( 
  F_PATIENT_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
  F_PATIENT_NAME VARCHAR(100),
  F_CREATED_TIMESTAMP DATETIME,
  F_AGE BIGINT,
  F_TXN_ID BIGINT,
  F_GENDER VARCHAR(100),
  F_CREATED_BY VARCHAR(100),
  F_DOWNLOAD_PATH     varchar(1000),
  F_AADHAR_NO         varchar(15),
  F_STATUS			  varchar(15),
  F_UPDATED_TIMESTAMP date   
);

DROP TABLE T_PATIENT_ADDRESS;

CREATE TABLE T_PATIENT_ADDRESS
(
	F_PATIENT_ID      BIGINT PRIMARY KEY,
	F_DISTRICT        VARCHAR(50),
	F_STATE           VARCHAR(40),
	F_PINCODE         BIGINT,
	F_CONTACT_NO      BIGINT,
	F_ADDRESS_ID      BIGINT,
	F_ADDRESS         VARCHAR(1000),
	F_CITY            VARCHAR(50)
);

DROP TABLE T_PATIENT_CURRENT_ADDRESS;

CREATE
  TABLE T_PATIENT_CURRENT_ADDRESS
  (
    F_PATIENT_ID BIGINT PRIMARY KEY,
    F_DISTRICT_CURRENT VARCHAR(50),
    F_STATE_CURRENT    VARCHAR(40),
    F_PINCODE_CURRENT BIGINT,
    F_CONTACT_NO_CURRENT BIGINT,
    F_ADDRESS_ID BIGINT,
    F_ADDRESS_CURRENT         VARCHAR(1000),
    F_CITY_CURRENT            VARCHAR(50),
    F_SAME_AS_PRESENT_ADDRESS VARCHAR(10)
  );

DROP TABLE T_CLINIC_DETAILS;

CREATE TABLE T_CLINIC_DETAILS
(   
  F_CLINIC_OWNER_NAME VARCHAR(100),
  F_TYPE     VARCHAR(500),
  F_REG_NO  VARCHAR(50),
  F_ADDRESS   VARCHAR(1000),
  F_DISTRICT  VARCHAR(50),
  F_STATE     VARCHAR(40),
  F_PINCODE       BIGINT,
  F_CONTACT_NO    BIGINT,
  F_CLINIC_NAME VARCHAR(500),
  F_PATIENT_ID BIGINT PRIMARY KEY
);

DROP TABLE T_FORM;

CREATE TABLE T_FORM
(
	  F_NO_OF_CHILDREN INT,
	  F_GUARDIAN_NAME VARCHAR(300),
	  F_REFERRED_BY VARCHAR(100),
	  F_SELF_REFERRED_BY VARCHAR(100),
	  F_PATIENT_ADDRESS VARCHAR(400),
	  F_REFERRAL_ADDRESS VARCHAR(400),
	  F_LAST_MENSTRUAL_PERIOD INT,
	  F_WEEKS_OF_PREGNANCY INT,
	  F_MEDICAL_DISEASE VARCHAR(400),
	  F_PARENTAL_DIAGNOSIS VARCHAR(400),
	  F_GYNA_DETAILS VARCHAR(500),
	  F_CREATED_TIMESTAMP DATE,
	  F_NO_OF_MALE_KIDS INT,
	  F_NO_OF_FEMALE_KIDS INT,
	  F_ADDRESS_ID BIGINT,
	  F_INVASIVE_ID BIGINT,
	  F_NON_INVASIVE_ID BIGINT,
	  F_CLINIC_ID BIGINT,
	  F_PATIENT_ID BIGINT PRIMARY KEY
  );

DROP TABLE T_NON_INVASIVE_PROCEDURES;

CREATE TABLE T_NON_INVASIVE_PROCEDURES
  (
   F_FORM_ID BIGINT,
   F_PATIENT_ID BIGINT PRIMARY KEY,
   F_PATIENT_NAME VARCHAR(100),
   F_DOCTOR_NAME VARCHAR(100),
   F_DIAGNOSIS_INDICATION varchar(200),
   F_CARRIED_NON_INVASIVE_PROCEDURE  VARCHAR(200),
   F_DECLARATION_DATE   DATE,
   F_PROCEDURE_CARRIED_DATE DATE,
   F_PROCEDURE_RESULT VARCHAR(100),
   F_CONVEY_ID BIGINT,
   F_MTP_INDICATION VARCHAR(100),
   F_DATE DATE,
   F_PLACE VARCHAR(100),
   F_OTHER_DIAGNOSE  varchar(500),
   F_OTHER_PROCEDURE  varchar(500)
  );
  
DROP TABLE T_DIAGNOSE_DETAILS;  
  
CREATE
  TABLE T_DIAGNOSE_DETAILS
  (
    F_PATIENT_ID BIGINT PRIMARY KEY,
    F_GESTATIONAL               VARCHAR(100),
    F_INTRAUTERINE              VARCHAR(100),
    F_CHORIONICITY              VARCHAR(100),
    F_VAGINAL_BLEEDING          VARCHAR(100),
    F_ABORTION                  VARCHAR(100),
    F_IUCD_IN_SITU              VARCHAR(100),
    F_ASSESSMENT_OF_CERVICAL    VARCHAR(100),
    F_UTERINESIZE_AMENORRHEA    VARCHAR(100),
    F_SUSPECTED_ADENEXAL        VARCHAR(100),
    F_CHROMOSOMAL_ABNORMALITIES VARCHAR(100),
    F_FETAL_POSITION            VARCHAR(100),
    F_LIQUOR_AMNII              VARCHAR(100),
    F_PRETERM_LABOR             VARCHAR(100),
    F_PLACENTAL_POSITION        VARCHAR(100),
    F_UMBILICAL_CORD            VARCHAR(100),
    F_PREVIOUS_CAESAREAN        VARCHAR(100),
    F_FETAL_GROWTH               VARCHAR(100),
    F_DUPLEX_DOPPLER            VARCHAR(100),
    F_TERMINATION_OF_PREGNANCY  VARCHAR(100),
    F_CHORIONIC_VILLUS          VARCHAR(100),
    F_INTRA_PARTUM_EVENTS       VARCHAR(100),
    F_COMPLICATING_PREGNANCY    VARCHAR(100),
    F_RESEARCH_SCIENTIFIC       VARCHAR(100)
  );

DROP TABLE T_INVASIVE_PROCEDURES;

CREATE
  TABLE T_INVASIVE_PROCEDURES
  (
    F_PATIENT_ID BIGINT PRIMARY KEY,
    F_DOCTOR_NAME                VARCHAR(100),
    F_HISTORY_OF_GENETIC_DISEASE VARCHAR(200),
    F_ADVANCED_MATERNAL_AGE      VARCHAR(100),
    F_GENETIC_DISEASE            VARCHAR(200),
    F_PREVIOUS_COMPLICATION      VARCHAR(200),
    F_FORM_G_DATE                DATE,
    F_COMPLICATIONS              VARCHAR(500),
    F_PROCEDURE_RESULT           VARCHAR(100),
    F_PROCEDURE_CARRIED_DATE     DATE,
    F_MTP_INDICATION             VARCHAR(100)
  );
  
DROP TABLE T_CONVEY_DETAILS;
  
CREATE TABLE T_CONVEY_DETAILS
( 
  F_PATIENT_ID BIGINT,  
  F_CONVEY_NAME VARCHAR(100),
  F_CONVEY_DATE DATE,
  F_TYPE VARCHAR(20),
  PRIMARY KEY (F_PATIENT_ID, F_TYPE)
);

DROP TABLE T_DIAGNOSIS_BASIS;

CREATE
  TABLE T_DIAGNOSIS_BASIS
  (
    F_PATIENT_ID BIGINT PRIMARY KEY,
    F_CLINICAL    VARCHAR(10),
    F_BIOCHEMICAL VARCHAR(10),
    F_CYTOGENETIC VARCHAR(10),
    F_ANY_OTHER       VARCHAR(300)
  );

DROP TABLE T_DIAGNOSIS_INDICATION;  
  
CREATE
  TABLE T_DIAGNOSIS_INDICATION
  (
    F_PATIENT_ID BIGINT PRIMARY KEY,
    F_CHROMOSOMAL_DISORDERS VARCHAR(10),
    F_METABOLIC_DISORDERS   VARCHAR(10),
    F_CONGENITAL_ANOMALY    VARCHAR(10),
    F_SINGLEGENE_DISORDER   VARCHAR(10),
    F_MENTAL_RETARDATION    VARCHAR(10),
    F_HAEMOGLOBINOPATHY     VARCHAR(10),
    F_SEXLINKED_DISORDERS   VARCHAR(10),
    F_ANY_OTHER             VARCHAR(200)
  );  

DROP TABLE T_INVASIVE_PRO;  
  
CREATE
  TABLE T_INVASIVE_PRO
  (
    F_PATIENT_ID BIGINT PRIMARY KEY,
    F_AMNIOCENTESIS   VARCHAR(10),
    F_CHORIONIC_VILLI VARCHAR(10),
    F_FETAL_BIOPSY    VARCHAR(10),
    F_CORDOCENTESIS   VARCHAR(10),
    F_ANY_OTHER       VARCHAR(200)
  ); 
  
DROP TABLE T_ADDITIONAL_TESTS;  
  
CREATE
  TABLE T_ADDITIONAL_TESTS
  (
    F_PATIENT_ID BIGINT PRIMARY KEY,
    F_CHROMOSOMAL_STUDIES    VARCHAR(10),
    F_BIOCHEMICAL_STUDIES    VARCHAR(10),
    F_MOLECULAR_STUDIES      VARCHAR(10),
    F_PREIMPLANTATION_GENDER VARCHAR(10),
    F_ANY_OTHER              VARCHAR(200)
  );  
  
DROP TABLE T_DOCTOR_DECLARATION;

CREATE TABLE T_DOCTOR_DECLARATION
( 
  F_PATIENT_ID BIGINT PRIMARY KEY,
  F_PATIENT_NAME   varchar(500),
  F_DOCTOR_NAME VARCHAR(100),
  F_DATE DATE,
  F_PLACE VARCHAR(100)
);

DROP TABLE T_REFERRAL_ADDRESS;

CREATE TABLE T_REFERRAL_ADDRESS
  (
    F_PATIENT_ID    BIGINT PRIMARY KEY,
    F_REFERRAL_NAME VARCHAR(100),
	F_REFERRAL_ADDRESS_ID BIGINT,
    F_ADDRESS       VARCHAR(1000),
    F_DISTRICT      VARCHAR(50),
    F_STATE         VARCHAR(40),
    F_PINCODE       BIGINT,
    F_CONTACT_NO    BIGINT
  ); 
  
---------------- User tables-------------------
DROP TABLE T_USER_DETAILS;

CREATE TABLE T_USER_DETAILS
  (
    F_LOGIN_ID      VARCHAR(20) NOT NULL PRIMARY KEY,
    F_PASSWORD      VARCHAR(50) NOT NULL,
    F_IS_ENABLED    VARCHAR(20),
    F_MOBILE_NUMBER VARCHAR(11),
    F_DISPLAY_NAME  VARCHAR(20),
    F_CREATED_BY    VARCHAR(20),
    F_CREATION_DATE DATE
  );

DROP TABLE T_USER_ADDRESS;

CREATE
  TABLE T_USER_ADDRESS
  (
    F_LOGIN_ID VARCHAR(20) NOT NULL PRIMARY KEY,
    F_DISTRICT VARCHAR(50),
    F_STATE    VARCHAR(30)
  );

DROP TABLE T_USER_ROLES;

CREATE TABLE T_USER_ROLES
  (
    F_LOGIN_ID VARCHAR(20) NOT NULL PRIMARY KEY,
    F_ROLE     VARCHAR(30)
  );

INSERT
INTO
  T_USER_DETAILS
  (
    F_LOGIN_ID,
    F_PASSWORD,
    F_IS_ENABLED,
    F_DISPLAY_NAME,
    F_MOBILE_NUMBER,
    F_CREATED_BY,
    F_CREATION_DATE
  )
  VALUES
  (
    'Administrator',
    'd16c36ef27272d2df565632f8595504f',
    'true',
    'Administrator',
    '9849440930',
    'Superuser',
    sysdate()
  );

INSERT
INTO
  T_USER_ADDRESS
  (
    F_LOGIN_ID,
    F_DISTRICT,
    F_STATE
  )
  VALUES
  (
    'Administrator',
    'Hyderabad',
    'Telangana'
  );

INSERT
INTO
  T_USER_ROLES
  (
    F_LOGIN_ID,
    F_ROLE
  )
  VALUES
  (
    'Administrator',
    'Administrator'
  );

INSERT
INTO
  T_USER_DETAILS
  (
    F_LOGIN_ID,
    F_PASSWORD,
    F_IS_ENABLED,
    F_DISPLAY_NAME,
    F_MOBILE_NUMBER,
    F_CREATED_BY,
    F_CREATION_DATE
  )
  VALUES
  (
    'sekhar',
    '202cb962ac59075b964b07152d234b70',
    'true',
    'BabuSek',
    '8978399338',
    'Superuser',
    sysdate()
  );

INSERT
INTO
  T_USER_ADDRESS
  (
    F_LOGIN_ID,
    F_DISTRICT,
    F_STATE
  )
  VALUES
  (
    'sekhar',
    'Hyderabad',
    'Telangana'
  );

INSERT
INTO
  T_USER_ROLES
  (
    F_LOGIN_ID,
    F_ROLE
  )
  VALUES
  (
    'sekhar',
    'Administrator'
  );

COMMIT;
