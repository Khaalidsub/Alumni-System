FROM tomee:8-jre-7.0.9-plus

# add dependencies
COPY ./integratedallsysmtem/Document/jars/*.jar /usr/local/tomee/lib/

COPY ./integratedallsysmtem/dist/integratedallsysmtem.war /usr/local/tomee/webapps/alumni_system.war

EXPOSE 8080