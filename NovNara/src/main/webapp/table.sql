
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
VALUES ('데이지찬장',150000,'데이지 찬장  상세설명',
now(), 100, 'DaisyCab.png');

insert tblProduct(name,price,detail,date,stock,image)
VALUES ('리본 벽걸이 찬장',150000,'리본 벽걸이 찬장  상세설명',
now(), 100, 'RibonWall.png');

insert tblProduct(name,price,detail,date,stock,image)
VALUES ('나비썬캐쳐',35000,'나비 썬캐쳐  상세설명',
now(), 100, 'Butterfly.png');

insert tblProduct(name,price,detail,date,stock,image)
VALUES ('고양이썬캐쳐',37000,'고양이 썬캐쳐 상세설명',
now(), 100, 'CheezeCat.png');

insert tblProduct(name,price,detail,date,stock,image)
VALUES ('다프네스탠드',200000,'다프테 스탠드  상세설명',
now(), 100, 'DafneStd.png');