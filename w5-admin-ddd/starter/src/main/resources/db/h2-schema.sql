DROP TABLE `t_w5_user` if exists;

CREATE TABLE IF NOT EXISTS `t_w5_user`
(
    `id`            INTEGER PRIMARY KEY auto_increment,
    `phone`         VARCHAR(100),
    `password`      VARCHAR(100),
    `name`          VARCHAR(100),
    `age`           INTEGER,
    `birthday`      DATETIME
);
