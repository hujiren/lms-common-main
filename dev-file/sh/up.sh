#!/bin/bash

read -t 30 -p "Please choose host 1、192.168.1.185    2、8.129.236.174:" hostIndex

echo "Please input your password:"
read -t 30 -s password


source ./up-start.sh  "apl-lms-common-impl-master/apl-lms-common-service-impl/src/main/resources/mapper" "/*.xml"  "resources/mapper/lms-common"

source ./up-start.sh  "apl-lms-common-impl-master/apl-lms-common-manage-app/target/" "apl-lms-common-manage-app-1.0.0.jar" ""

source ./up-start.sh  "apl-lms-common-impl-master/apl-lms-common-query-app/target/"  "apl-lms-common-query-app-1.0.0.jar"   ""
