#!/bin/bash
sudo docker-compose stop authy-nginx
sudo docker-compose rm -f authy-nginx
sudo docker-compose build authy-nginx
sudo docker-compose up -d authy-nginx
