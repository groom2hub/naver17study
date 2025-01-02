-- join table 연습 - on delete cacade로 자식 테이블을 생성

-- 부모테이블인 shop을 만들어보자 - 상품을 등록하는 테이블
CREATE TABLE shop (
     sangcode varchar2(10) constraint pk_shop_sangcode PRIMARY key,
     sangname varchar2(30),
     sangprice number(7));
     
-- shop 의 상품코드를 참조해서 cart 에 담을수 있도록 테이블을 생성
-- 상품을 지우면 cart 의 데이타도 자동으로 지워지도록 on delete cascade 를 설정해서 생성하자
CREATE TABLE cart (
    cartnum number(3) CONSTRAINT pk_cart_cartnum PRIMARY key,
    sangcode varchar2(10),
    cntnum number(3) DEFAULT 1,
    cartday date,
    CONSTRAINT fk_cart_sangcode FOREIGN key(sangcode) REFERENCES shop(sangcode) on delete cascade);

-- cart 에 들어갈 시퀀스 생성
CREATE SEQUENCE seqcart nocache;

--상품등록을 하자
INSERT INTO shop VALUES ('A100', '체크블라우스', 23000);
INSERT INTO shop VALUES ('A200', '브이넥티셔츠', 19000);
INSERT INTO shop VALUES ('A300', '레이스블라우스', 34000);
INSERT INTO shop VALUES ('A400', '블랙진바지', 56000);
INSERT INTO shop VALUES ('A500', '실크스카프', 12000);
INSERT INTO shop VALUES ('A600', '인견자켓', 59000);
INSERT INTO shop VALUES ('A700', '롱오리털코트', 123000);
INSERT INTO shop VALUES ('A800', '체크티셔츠', 35000);
INSERT INTO shop VALUES ('A900', '실크블라우스', 89000);
COMMIT;
SELECT * FROM shop;--확인

--cart 에 원하는 상품을 담아보자
INSERT INTO cart (cartnum, sangcode, cartday) VALUES (seqcart.nextval, 'A500', sysdate);
INSERT INTO cart (cartnum, sangcode, cartday) VALUES (seqcart.nextval, 'A700', sysdate);
INSERT INTO cart (cartnum, sangcode, cntnum, cartday) VALUES (seqcart.nextval, 'A800', 3, sysdate);
INSERT INTO cart (cartnum, sangcode, cntnum, cartday) VALUES (seqcart.nextval,' A100', 2, sysdate);
INSERT INTO cart (cartnum, sangcode, cntnum, cartday) VALUES (seqcart.nextval, 'A500', 1, sysdate);
INSERT INTO cart (cartnum, sangcode, cntnum, cartday) VALUES (seqcart.nextval, 'A400', 2, sysdate);
COMMIT;
SELECT * FROM cart;

-- join sql 문을 이용해서 다음 순서로 출력해보세요
-- cartnum, sangcode, sangname, sangprice, cntnum, cartday(yyyy-mm-dd hh24:mi)
SELECT
   c.cartnum, s.sangcode, s.sangname, s.sangprice, c.cntnum, 
   TO_CHAR(cartday, 'yyyy-mm-dd hh24:mi') cartday
FROM shop s,cart c
WHERE s.sangcode = c.sangcode;

-- outer join 을 이용해서 아무도 카트에 담지 않은 상품을 알아보자
SELECT
   c.cartnum, s.sangcode, s.sangname, s.sangprice, c.cntnum,
   TO_CHAR(cartday, 'yyyy-mm-dd hh24:mi') cartday
FROM shop s, cart c
WHERE s.sangcode = c.sangcode(+) AND cartnum IS NULL;

-- on delete cascade 로 생성한 경우 카트에 담긴 데이터도 부모 테이블인 shop 에서 삭제 가능
-- 이때 상품 삭제 시 카트에 담긴 상품은 자동으로 삭제

-- shop 에서 A500을 제거 (카트에 두개가 담겨 있음)
DELETE FROM shop WHERE sangcode = 'A500';
-- 다시 join 으로 cart 확인하기
SELECT
   c.cartnum, s.sangcode, s.sangname, s.sangprice, c.cntnum,
   TO_CHAR(cartday, 'yyyy-mm-dd hh24:mi') cartday
FROM shop s, cart c
WHERE s.sangcode = c.sangcode;

