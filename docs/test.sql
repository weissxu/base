CREATE TABLE `person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(8) NOT NULL,
  `gender` tinyint(3) unsigned DEFAULT '0',
  `birthday` datetime NOT NULL,
  `phone` varchar(16) NOT NULL DEFAULT '',
  `address` varchar(32) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;



insert into person(name,birthday,phone,address) values('siwei','1998-10-10 00:00:00','15700115969','杭州');