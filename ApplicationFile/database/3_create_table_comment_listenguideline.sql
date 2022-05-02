use toeiconline;

create table listenguideline(
    listenguidelineid bigint       not null primary key auto_increment,
    title            varchar(512) null,
    image            varchar(255) null,
    context          text         null,
    createddate      timestamp    null,
    modifieddate     timestamp    null
);
create table comment(
    commentid bigint not null primary key auto_increment,
    content text null,
    userid BIGINT NULL ,
    listenguidelineid BIGINT NULL,
    createddate timestamp null
)