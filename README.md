###[Eureka Service]

* 端口范围:<br/>
</t>20000 - 20009
* 启动命令:<br/>
</t>`nohup java -jar eureka-1.0.0.0.jar --server.port=20000 --eureka.instance.hostname=ioteureka1.com --eureka.client.serviceUrl.defaultZone=http://ioteureka1.com:20000/eureka/,http://ioteureka2.com:20001/eureka/ >> eureka-20000.out &`
</t>`nohup java -jar eureka-1.0.0.0.jar --server.port=20001 --eureka.instance.hostname=ioteureka2.com --eureka.client.serviceUrl.defaultZone=http://ioteureka1.com:20000/eureka/,http://ioteureka2.com:20001/eureka/ >> eureka-20001.out &`