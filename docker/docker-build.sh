#!/bin/sh
# 각 어플리케이션에 존재하는 Dockerfile 을 기준으로 이미지를 빌드
# setting version
VERSION='1.0.1'

cd ..
./gradlew clean build -x test

ROOT_PATH=`pwd`
echo $ROOT_PATH # 위치 잘 찍히는지 test

# api application
echo 'api docker image build...'
cd $ROOT_PATH/api && docker build -t api:$VERSION -f .
#echo $ROOT_PATH/api
echo 'api docker image build... Done'


echo 'consumer docker image build...'
cd $ROOT_PATH/consumer && docker build -t consumer:$VERSION -f .


echo 'css docker image build...'
cd $ROOT_PATH/css && docker build -t css:$VERSION -f .
echo 'css docker image build... Done'


echo 'nginx docker image build...'
cd $ROOT_PATH/nginx && docker build -t nginx:$VERSION -f .
echo 'nginx docker image build... Done'