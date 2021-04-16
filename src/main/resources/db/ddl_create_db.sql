-- creare uno script dove sono elencati i drop table e create table

create table course (    
    ID number, 
    NAME varchar2(100 byte) not null, 
    DESCRIPTION varchar2(500 byte),
    ENABLED	BOOLEAN,
        
    PRIMARY KEY (ID)
);
 
create table student (	
    ID number, 
    NAME varchar2(100 byte) not null, 
    SURNAME varchar2(100 byte) not null,
    EMAIL varchar2(100 byte),
    JOB_TITLE varchar2(100 byte),
    PAYMENT_TYPE varchar2(100 byte),
    SEX	varchar2(1 byte) not null,
        
    PRIMARY KEY (ID)
);
 
create table topic (	
    ID number, 
    NAME varchar2(100 byte) not null, 
    DESCRIPTION varchar2(500 byte),
    COURSE_ID number,
        
    PRIMARY KEY (ID),
    CONSTRAINT topic_course_fk FOREIGN KEY (COURSE_ID) REFERENCES course(ID)
);
  
create sequence seq_student
    START WITH 1000
    INCREMENT BY 1;
        
create sequence seq_course
    START WITH 1000
    INCREMENT BY 1;
        
create sequence seq_topic
    START WITH 1000
    INCREMENT BY 1;
    
create view vw_course_topics
as
select c.name courseName, count(*) nrTopics 
from topic t
    right join course c 
    on t.course_id = c.id
group by c.name;
    
create view vw_course_students
as
select c.name courseName, count(*) nrStudentsSignedUp 
from subscriptions sub
    right join student s 
    on sub.student_id = s.id
    right join course c 
    on sub.course_id = c.id 
group by c.name;
    
create view vw_course_details
as 
select vwc.coursename, vwt.nrtopics, vwc.nrStudentsSignedUp 
from (
select c.name courseName, count(*) nrStudentsSignedUp 
from subscriptions sub
    right join student s 
    on sub.student_id = s.id
    right join course c 
    on sub.course_id = c.id
group by c.name
) vwc 
    inner join (
select c.name courseName, count(*) nrTopics 
from topic t
    right join course c 
    on t.course_id = c.id
group by c.name 
) vwt 
    on vwt.coursename = vwc.coursename;