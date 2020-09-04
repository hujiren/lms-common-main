
#项目绝对路径
MYPATH="/Volumes/data/java/apl-lms/apl-lms-common-java"

# mybatis mpper
 scp  $MYPATH/apl-lms-common-impl-master/apl-lms-common-service-impl/src/main/resources/mapper/*.xml  root@192.168.1.185:/usr/local/java/basic/resource/mapper/lms-common


# 公共模块管理
# scp  $MYPATH/apl-lms-common-impl-master/apl-lms-common-manage-app/target/apl-lms-common-manage-app-1.0.0.jar  root@192.168.1.185:/usr/local/java/basic/

# 公共模块查询
 scp  $MYPATH/apl-lms-common-impl-master/apl-lms-common-query-app/target/apl-lms-common-query-app-1.0.0.jar root@192.168.1.185:/usr/local/java/basic/
