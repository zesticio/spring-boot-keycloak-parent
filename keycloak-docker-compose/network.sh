#!/bin/bash
echo "Creating docker network"
sudo docker network create --scope=swarm \
--driver=bridge \
--subnet=172.1.1.0/24 \
--gateway=172.1.1.1 \
keycloak

sudo docker network create --scope=swarm \
--driver=bridge \
--subnet=192.168.50.0/24 \
--gateway=192.168.50.1 \
zestic.external

sudo docker network ls
