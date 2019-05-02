user
create table user
(
   user_id              varchar(48) not null,
   user_email           varchar(24),
   user_name            varchar(128),
   password             varchar(128),
   create_time          timestamp default current_timestamp,
   update_time          timestamp default current_timestamp on update current_timestamp,
   primary key (user_id)
);

product
设定说明
product_type(金币0，货币1，账号2，礼包3）目前暂定
game_server(游戏服务器，有些游戏存在，没有即可填无，包括渠道服算作游戏分区）
game_operating(安卓，ios，PC）
create table product
(
   product_id           int not null auto_increment,
   product_user_id      varchar(48),
   product_name         varchar(256),
   product_price        decimal,
   product_stock        int,
   product_type         varchar(8),
   product_describe     varchar(512),
   game_name            varchar(32),
   game_server          varchar(16),
   game_operating       varchar(4),
   create_time          timestamp default current_timestamp,
   update_time          timestamp default current_timestamp on update current_timestamp,
   primary key (product_id)
);

order
create table receive
(
   receive_id           int not null auto_increment,
   iphone               varchar(16),
   qq                   varchar(16),
   game_server          varchar(32),
   game_role_name       varchar(32),
   game_account         varchar(32),
   game_password        varchar(64),
   game_rank            varchar(8),
   create_time          timestamp default current_timestamp,
   update_time          timestamp default current_timestamp on update current_timestamp,
   primary key (receive_id)
);

order
设定说明
order_status(0交易成功，1交易失败）
create table order_info
(
   order_id             varchar(16) not null,
   user_id              varchar(48),
   product_id           int,
   receive_id           int,
   product_num          int,
   create_time          timestamp default current_timestamp,
   update_time          timestamp default current_timestamp on update current_timestamp,
   order_status         varchar(4),
   primary key (order_id)
);

alter table order_info add constraint FK_Reference_1 foreign key (receive_id)
      references receive (receive_id) on delete restrict on update restrict;