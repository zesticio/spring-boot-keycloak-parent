#!/bin/bash
sudo docker-compose stop authy-app
sudo docker-compose rm -f authy-app
sudo docker-compose build authy-app
sudo docker-compose up -d authy-app
