
insert into student (ID, NAME, SURNAME, EMAIL, JOB_TITLE, PAYMENT_TYPE, SEX) values (01, 'Sandro', 'Gargano', 'sandrus88@hotmail.it', 'Waiter', 'OK', 'M');
insert into student (ID, NAME, SURNAME, EMAIL, JOB_TITLE, PAYMENT_TYPE, SEX) values (02, 'Mario', 'Rossi', 'mariorossi@hotmail.it', '', 'OK', 'M');
insert into student (ID, NAME, SURNAME, EMAIL, JOB_TITLE, PAYMENT_TYPE, SEX) values (03, 'Ermal', 'Aliraj', 'ermalaliraj@gmail.com', 'Web Developer', 'OK', 'M');
insert into student (ID, NAME, SURNAME, EMAIL, JOB_TITLE, PAYMENT_TYPE, SEX) values (04, 'Student4', 'Surname4', null, 'Job4', 'OK', 'M');
insert into student (ID, NAME, SURNAME, EMAIL, JOB_TITLE, PAYMENT_TYPE, SEX) values (05, 'Student5', 'Surname5', null, 'Job5', 'OK', 'M');
insert into student (ID, NAME, SURNAME, EMAIL, JOB_TITLE, PAYMENT_TYPE, SEX) values (06, 'Student6', 'Surname6', null, 'Job6', 'OK', 'M');
insert into student (ID, NAME, SURNAME, EMAIL, JOB_TITLE, PAYMENT_TYPE, SEX) values (07, 'Student7', 'Surname7', null, 'Job7', 'OK', 'M');
insert into student (ID, NAME, SURNAME, EMAIL, JOB_TITLE, PAYMENT_TYPE, SEX) values (08, 'Student8', 'Surname8', null, 'Job8', 'OK', 'M');
insert into student (ID, NAME, SURNAME, EMAIL, JOB_TITLE, PAYMENT_TYPE, SEX) values (09, 'Student9', 'Surname9', null, 'Job9', 'OK', 'M');
insert into student (ID, NAME, SURNAME, EMAIL, JOB_TITLE, PAYMENT_TYPE, SEX) values (10, 'Student10', 'Surname10', null, 'Job10', 'OK', 'M');
insert into student (ID, NAME, SURNAME, EMAIL, JOB_TITLE, PAYMENT_TYPE, SEX) values (21, 'Armela', 'Xhaxho', 'armelaxhaxho@hotmail.com', 'Shop Assistant', 'UNKNOWN', 'F');
insert into student (ID, NAME, SURNAME, EMAIL, JOB_TITLE, PAYMENT_TYPE, SEX) values (22, 'Aida', 'Xhaxho', 'aidaxhaxho@gmail.com', 'Beauty Consultant', 'NOTOK', 'F');
insert into student (ID, NAME, SURNAME, EMAIL, JOB_TITLE, PAYMENT_TYPE, SEX) values (23, 'Andrea', 'Bonfanti', null, 'Engineer', 'UNKNOWN', 'M');
insert into student (ID, NAME, SURNAME, EMAIL, JOB_TITLE, PAYMENT_TYPE, SEX) values (24, 'Francesca', 'Morbillo', null, 'Lawyer', 'OK', 'F');
insert into student (ID, NAME, SURNAME, EMAIL, JOB_TITLE, PAYMENT_TYPE, SEX) values (25, 'Penelope', 'Fatima', null, 'Project Manager', 'NOTOK', 'F');
insert into student (ID, NAME, SURNAME, EMAIL, JOB_TITLE, PAYMENT_TYPE, SEX) values (26, 'Student26', 'Surname26', null, 'Job26', 'OK', 'M');
insert into student (ID, NAME, SURNAME, EMAIL, JOB_TITLE, PAYMENT_TYPE, SEX) values (27, 'Student27', 'Surname27', null, 'Job27', 'OK', 'M');
insert into student (ID, NAME, SURNAME, EMAIL, JOB_TITLE, PAYMENT_TYPE, SEX) values (28, 'Student28', 'Surname28', null, 'Job28', 'OK', 'M');
insert into student (ID, NAME, SURNAME, EMAIL, JOB_TITLE, PAYMENT_TYPE, SEX) values (29, 'Student29', 'Surname29', null, 'Job29', 'OK', 'M');
insert into student (ID, NAME, SURNAME, EMAIL, JOB_TITLE, PAYMENT_TYPE, SEX) values (30, 'Student30', 'Surname30', null, 'Job30', 'OK', 'M');

insert into course (ID, NAME, DESCRIPTION, ENABLED) values (1, 'Java', 'Basic concepts and Java fundamentals', true);
insert into course (ID, NAME, DESCRIPTION, ENABLED) values (2, 'Java advanced programming', '', true);
insert into course (ID, NAME, DESCRIPTION, ENABLED) values (3, 'Operating Systems', 'This course will introduce you to modern operating systems', false);
insert into course (ID, NAME, DESCRIPTION, ENABLED) values (4, 'Computer Network', '', true);
insert into course (ID, NAME, DESCRIPTION, ENABLED) values (5, 'Javascript', 'Concetti base di Javascript', false);
insert into course (ID, NAME, DESCRIPTION, ENABLED) values (6, 'XML', 'XMLSchema e parsing con Java', false);
insert into course (ID, NAME, DESCRIPTION, ENABLED) values (7, 'Data Structures and Algorithms', '', false);
insert into course (ID, NAME, DESCRIPTION, ENABLED) values (8, 'Course 8', 'Description of course 8', false);
insert into course (ID, NAME, DESCRIPTION, ENABLED) values (9, 'Course 9', 'Description of course 9', true);
insert into course (ID, NAME, DESCRIPTION, ENABLED) values (10, 'Course 10', 'Description of course 10', true);

insert into topic (ID, NAME, DESCRIPTION, COURSE_ID) values (301, 'Objects Oriented Paradigm', 'OOPS concepts (Data Abstraction, Encapsulation, Inheritance, Polymorphism)', 1);
insert into topic (ID, NAME, DESCRIPTION, COURSE_ID) values (302, 'Basic Java constructs like loops and data types', '', 1);
insert into topic (ID, NAME, DESCRIPTION, COURSE_ID) values (303, 'String handling', '', 1);
insert into topic (ID, NAME, DESCRIPTION, COURSE_ID) values (304, 'Collection framework', 'List, ArrayList, LinkedList', 1);
insert into topic (ID, NAME, DESCRIPTION, COURSE_ID) values (305, 'Exception handling', '', null);
insert into topic (ID, NAME, DESCRIPTION, COURSE_ID) values (306, 'Servlet', '', 1);
insert into topic (ID, NAME, DESCRIPTION, COURSE_ID) values (307, 'JSP', '', null);
insert into topic (ID, NAME, DESCRIPTION, COURSE_ID) values (308, 'What is an Operating System?', '', 3);
insert into topic (ID, NAME, DESCRIPTION, COURSE_ID) values (309, 'Operating System history', '', 3);
insert into topic (ID, NAME, DESCRIPTION, COURSE_ID) values (310, 'Operating System concepts', 'CPU, file storage, input/output (I/O) devices, and network connections', 3);
insert into topic (ID, NAME, DESCRIPTION, COURSE_ID) values (311, 'Operating System structures', '', 3);
insert into topic (ID, NAME, DESCRIPTION, COURSE_ID) values (312, 'Local Area Network (LAN) Technologies', '', 4);
insert into topic (ID, NAME, DESCRIPTION, COURSE_ID) values (313, 'Introduction of MAC Address', '', 4);
insert into topic (ID, NAME, DESCRIPTION, COURSE_ID) values (314, 'Multiple Access Protocols', '', null);
insert into topic (ID, NAME, DESCRIPTION, COURSE_ID) values (315, 'Ethernet Frame Format', '', 6);
insert into topic (ID, NAME, DESCRIPTION, COURSE_ID) values (316, 'Basic Data Structures', 'Arrays, Strings, Stacks, Queues', 6);
insert into topic (ID, NAME, DESCRIPTION, COURSE_ID) values (317, 'Basic math operations', 'addition, subtraction, multiplication, division, exponentiation', 6);
insert into topic (ID, NAME, DESCRIPTION, COURSE_ID) values (318, 'Euclid s GCD Algorithm', '', null);
insert into topic (ID, NAME, DESCRIPTION, COURSE_ID) values (319, 'Greedy Algorithms', '', null);
insert into topic (ID, NAME, DESCRIPTION, COURSE_ID) values (320, 'Binary Searching', '', null);
insert into topic (ID, NAME, DESCRIPTION, COURSE_ID) values (321, 'Multithreading', '', 2);
insert into topic (ID, NAME, DESCRIPTION, COURSE_ID) values (322, 'Programmazione di stringa', '', 2);
