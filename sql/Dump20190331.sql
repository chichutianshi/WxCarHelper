CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nikename` varchar(50) DEFAULT NULL,
  `gender` int(11) DEFAULT NULL,
  `province` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `country` varchar(45) DEFAULT NULL,
  `openid` varchar(70) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
SELECT * FROM cargg.user;