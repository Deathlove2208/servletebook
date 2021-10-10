create database ebook;
use ebook;
create table books(
	id int NOT NULL AUTO_INCREMENT,
    title nvarchar(50) NOT NULL,
    link nvarchar(500),
    thumbnail nvarchar(100),
    views int,
    primary key(id)
    
);

create table users(
	id int NOT NULL AUTO_INCREMENT,
    fullname nvarchar(50) NOT NULL,
    username nvarchar(50),
    pword nvarchar(50),
    avatar nvarchar(100),
    primary key(id)
    
);

create table categorys(
	id int NOT NULL AUTO_INCREMENT,
    catename nvarchar(50) NOT NULL,
    primary key(id)
    
);


INSERT INTO `books` VALUES (1,'Apply These 9 Secret Techniques To Improve Book','','https://cdn.pixabay.com/photo/2021/08/06/05/04/mountain-6525356_960_720.jpg',2),(4,'How 9 Things Will Change The Way You Approach Book','','https://cdn.pixabay.com/photo/2021/09/26/14/37/milky-way-6657951_960_720.jpg',2),(6,'Book Doesn\'t Have To Be Hard. Read These 9 Tips','','https://cdn.pixabay.com/photo/2017/03/15/18/13/lantern-2146997_960_720.jpg',2),(7,'Book Is Your Worst Enemy. 9 Ways To Defeat It','','https://cdn.pixabay.com/photo/2020/06/13/03/40/flower-5292556_960_720.jpg',2),(8,'Book On A Budget: 9 Tips From The Great Depression','','https://cdn.pixabay.com/photo/2020/09/12/21/12/tomatoes-5566741_960_720.jpg',2),(10,'Master The Art Of Book With These 9 Tips','','https://cdn.pixabay.com/photo/2021/09/09/10/20/promenade-6610125_960_720.jpg',2);

INSERT INTO `users` VALUES (1,'Le Minh Sang','msang','2403',NULL),(2,'tran gia bao','giabao','2403',NULL);
