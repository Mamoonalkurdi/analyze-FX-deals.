#FROM tomcat
#ADD /target/Mamoun-Alkurdi-Task-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/
#CMD ["/bin/sh"]

#$ ls
#Dockerfile  /target/Mamoun-Alkurdi-Task-1.0-SNAPSHOT.war
#$ cat Dockerfile 
FROM tomcat

COPY /target/Mamoun-Alkurdi-Task-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/