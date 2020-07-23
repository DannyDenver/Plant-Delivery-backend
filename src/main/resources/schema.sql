create table if not exists candy (
   id bigint not null,
   name nvarchar(255),
   price decimal(12,4),
   primary key (id)
);

create table if not exists candy_delivery (
    delivery_id bigint not null,
    candy_id bigint not null
)

