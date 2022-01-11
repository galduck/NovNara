
CREATE TABLE tblProduct (
	no                  int(5)                      auto_increment  ,
	name            varchar(20)           NULL      ,
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



insert tblProduct(name,price,detail,date,stock,image)
VALUES ('����������',150000,'������ ����  �󼼼���',
now(), 100, 'DaisyCab.png');

insert tblProduct(name,price,detail,date,stock,image)
VALUES ('���� ������ ����',150000,'���� ������ ����  �󼼼���',
now(), 100, 'RibonWall.png');

insert tblProduct(name,price,detail,date,stock,image)
VALUES ('�����ĳ��',35000,'���� ��ĳ��  �󼼼���',
now(), 100, 'Butterfly.png');

insert tblProduct(name,price,detail,date,stock,image)
VALUES ('����̽�ĳ��',37000,'����� ��ĳ�� �󼼼���',
now(), 100, 'CheezeCat.png');

insert tblProduct(name,price,detail,date,stock,image)
VALUES ('�����׽��ĵ�',200000,'������ ���ĵ�  �󼼼���',
now(), 100, 'DafneStd.png');