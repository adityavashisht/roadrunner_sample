#!/bin/bash
echo "Road Runner.. Build System...initiating build sequence..."
mvn -Pdevelopment clean install -Dmaven.test.skip=true -U

echo "Descending into parent module..."
echo "Cleaning up tomcat..."
sudo rm -rf /opt/tomcat-instance/tomcat-7081/rr.war
sudo rm -rf /opt/tomcat-instance/tomcat-7081/webapps/rr
echo "Removing existing work directory"
sudo rm -rf /opt/tomcat-instance/tomcat-7081/work/Catalina/localhost/rr

echo "Removed previous installations..."
sleep 5

sudo cp ./rr-web/target/rr.war /opt/tomcat-instance/tomcat-7081/webapps
echo "Done copying binary for Road Runner...."

echo "Done"
