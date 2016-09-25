FROM glassfish/server:4.1.1
# See: https://hub.docker.com/r/glassfish/server/~/dockerfile/
# See: https://github.com/glassfish/docker/tree/master/4.1.1


MAINTAINER Olivier Liechti <olivier.liechti@heig-vd.ch>

# ADD appwar.war /as-install/domains/domain1/autodeploy/
ADD appwar.war /glassfish4/glassfish/domains/domain1/autodeploy/
ADD drivers/mysql-connector-java-5.1.39-bin.jar /glassfish4/glassfish/lib/

