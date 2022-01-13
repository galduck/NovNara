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
VALUES (1,'데이지찬장',150000,'데이지 찬장  상세설명',
now(), 100, 'DaisyCab.png');

insert tblProduct(sort, name,price,detail,date,stock,image)
VALUES (1,'리본 벽걸이 찬장',150000,'리본 벽걸이 찬장  상세설명',
now(), 100, 'RibonWall.png');

insert tblProduct(sort, name,price,detail,date,stock,image)
VALUES (1, '나비썬캐쳐',35000,'나비 썬캐쳐  상세설명',
now(), 100, 'Butterfly.png');

insert tblProduct(sort, name,price,detail,date,stock,image)
VALUES (1, '고양이썬캐쳐',37000,'고양이 썬캐쳐 상세설명',
now(), 100, 'CheezeCat.png');

insert tblProduct(sort, name,price,detail,date,stock,image)
VALUES (2, '다프네스탠드',200000,'다프테 스탠드  상세설명',
now(), 100, 'DafneStd.png');

insert tblProduct(sort, name,price,detail,date,stock,image)
VALUES (2, '수선화스탠드',200000,'수선화  스탠드  상세설명',
now(), 100, 'PaperwhiteStd.png');

insert tblProduct(sort, name,price,detail,date,stock,image)
VALUES (2, '물방울조명',200000,'물방울 조명   상세설명',
now(), 100, 'Waterdrop.png');

insert tblProduct(sort, name,price,detail,date,stock,image)
VALUES (2, '체리조명',180000,'체리조명  상세설명',
now(), 100, 'Cherry.png');