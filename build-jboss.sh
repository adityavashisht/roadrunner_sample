#!/bin/bash
echo "Road Runner.. Deploying to Jboss As 7..."
mvn -Pproduction clean install -Dmaven.test.skip=true

echo "Descending into parent module..."
echo "Cleaning up jboss..."
# remove stale wars
sudo rm -rf /opt/jboss-as/standalone/deployments/rr.war
# rmeove all failed artifacts
sudo rm -rf /opt/jboss-as/standalone/deployments/*.failed
# remove all deployed artifacts
sudo rm -rf /opt/jboss-as/standalone/deployments/*.deployed

echo "removed previous installations..."


sleep 2

sudo cp ./rr-web/target/rr.war /opt/jboss-as/standalone/deployments
echo "Copied new artifacts over...."
sleep 2

echo "Done"
