DROP TABLE IF EXISTS tblProduct;
CREATE TABLE tblProduct (
	no                  int(5)                      auto_increment  ,
	sort						INT(5)								NULL		 ,
	name            VARCHAR(50)           NULL      ,
	price             int                           NULL      ,
	detail            text                          NULL      ,
	date              varchar(20)           NULL      ,
	stock            int                            NULL      ,
	image           varchar(20)           NULL      ,
	PRIMARY KEY ( no )
)COLLATE='euckr_korean_ci';

CREATE TABLE tblOrder (
	no                    int                          auto_increment  ,
	productNo      int                            NULL  ,
	quantity          int                           NULL      ,
	date                varchar(20)           NULL      ,
	state               varchar(10)           NULL      ,
	id                     varchar(10)           NULL      ,
	PRIMARY KEY ( no )
)COLLATE='euckr_korean_ci';

CREATE TABLE tblMember (
  id char(20) NOT NULL,
  pwd char(20) NOT NULL,
  email char(30) NOT NULL,
  
  PRIMARY KEY (id)
)COLLATE='euckr_korean_ci';

CREATE TABLE tblAdmin (
	admin_id                 varchar(20)          NOT NULL  ,
	admin_pwd     varchar(20)          NOT NULL      ,
	PRIMARY KEY       ( admin_id )
)COLLATE='euckr_korean_ci';


insert tblProduct(sort, NAME, price,detail,date,stock,image)
VALUES (1,'����������',150000,'������ ����  �󼼼���',
now(), 100, 'DaisyCab.png');

insert tblProduct(sort, name,price,detail,date,stock,image)
VALUES (1,'���� ������ ����',150000,'���� ������ ����  �󼼼���',
now(), 100, 'RibonWall.png');

insert tblProduct(sort, name,price,detail,date,stock,image)
VALUES (1, '�����ĳ��',35000,'���� ��ĳ��  �󼼼���',
now(), 100, 'Butterfly.png');

insert tblProduct(sort, name,price,detail,date,stock,image)
VALUES (1, '����̽�ĳ��',37000,'����� ��ĳ�� �󼼼���',
now(), 100, 'CheezeCat.png');

insert tblProduct(sort, name,price,detail,date,stock,image)
VALUES (2, '�����׽��ĵ�',200000,'������ ���ĵ�  �󼼼���',
now(), 100, 'DafneStd.png');

insert tblProduct(sort, name,price,detail,date,stock,image)
VALUES (2, '����ȭ���ĵ�',200000,'����ȭ  ���ĵ�  �󼼼���',
now(), 100, 'PaperwhiteStd.png');

insert tblProduct(sort, name,price,detail,date,stock,image)
VALUES (2, '���������',200000,'����� ����   �󼼼���',
now(), 100, 'Waterdrop.png');

insert tblProduct(sort, name,price,detail,date,stock,image)
VALUES (2, 'ü������',180000,'ü������  �󼼼���',
now(), 100, 'Cherry.png');