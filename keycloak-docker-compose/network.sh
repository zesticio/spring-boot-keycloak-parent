#!/bin/bash
echo "Creating docker network"
sudo docker network create --driver=bridge \
--subnet=192.168.10.0/24 \
--gateway=192.168.10.1 \
zestic.internal

sudo docker network create --driver=bridge \
--subnet=192.168.50.0/24 \
--gateway=192.168.50.1 \
zestic.external

sudo docker network ls
