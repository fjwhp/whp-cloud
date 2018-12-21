FROM mysql:5.7

MAINTAINER whp(1032998173@qq.com)

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

COPY ./doc/db/1schema.sql /docker-entrypoint-initdb.d

COPY ./doc/db/2whp.sql /docker-entrypoint-initdb.d

COPY ./doc/db/3whp_ac.sql /docker-entrypoint-initdb.d