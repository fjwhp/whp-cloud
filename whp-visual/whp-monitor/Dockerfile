FROM anapsix/alpine-java:8_server-jre_unlimited

MAINTAINER 1032998173@qq.com

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

RUN mkdir -p /whp-monitor

WORKDIR /pigx-monitor

EXPOSE 5001

ADD ./whp-visual/whp-monitor/target/whp-monitor.jar ./

CMD java -Djava.security.egd=file:/dev/./urandom -jar whp-monitor.jar
