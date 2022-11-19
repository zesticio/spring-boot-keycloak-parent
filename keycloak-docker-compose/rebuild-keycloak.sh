#!/bin/bash
sudo docker-compose stop keycloak
sudo docker-compose rm -f keycloak
sudo docker-compose build keycloak
sudo docker-compose up -d keycloak
