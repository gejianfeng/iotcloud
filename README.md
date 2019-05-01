### Eureka Service

* 端口范围:<br/>
</t>20000 - 20009
* 启动命令:<br/>
</t>`nohup java -jar eureka-1.0.0.0.jar --server.port=20000 --eureka.instance.hostname=ioteureka1.com --eureka.client.serviceUrl.defaultZone=http://ioteureka1.com:20000/eureka/,http://ioteureka2.com:20001/eureka/ >> eureka-20000.out &`<br/>
</t>`nohup java -jar eureka-1.0.0.0.jar --server.port=20001 --eureka.instance.hostname=ioteureka2.com --eureka.client.serviceUrl.defaultZone=http://ioteureka1.com:20000/eureka/,http://ioteureka2.com:20001/eureka/ >> eureka-20001.out &`

### Gaetway Service

* 端口范围:<br/>
</t>20010 - 20019
* 启动命令:<br/>
</t>`nohup java -jar gateway-1.0.0.0.jar --server.port=20010 --eureka.instance.hostname=iotgateway1.com --eureka.client.serviceUrl.defaultZone=http://ioteureka1.com:20000/eureka/,http://ioteureka2.com:20001/eureka/ >> gateway-20010.out &`<br/>
</t>`nohup java -jar gateway-1.0.0.0.jar --server.port=20011 --eureka.instance.hostname=iotgateway2.com --eureka.client.serviceUrl.defaultZone=http://ioteureka1.com:20000/eureka/,http://ioteureka2.com:20001/eureka/ >> gateway-20011.out &`

### Test Service

* 端口范围:<br/>
</t>20020 - 20029
* 启动命令:<br/>
</t>`nohup java -jar test-1.0.0.0.jar --server.port=20020 --iotcloud.serviceId=cbd2989e-33e3-433c-bc05-27f26311dffb --eureka.instance.hostname=iottest1.com --eureka.client.serviceUrl.defaultZone=http://ioteureka1.com:20000/eureka/,http://ioteureka2.com:20001/eureka/ >> test-20020.out &`<br/>
</t>`nohup java -jar test-1.0.0.0.jar --server.port=20021 --iotcloud.serviceId=d2e20270-30ca-4b87-ac20-53b776fa08c5 --eureka.instance.hostname=iottest2.com --eureka.client.serviceUrl.defaultZone=http://ioteureka1.com:20000/eureka/,http://ioteureka2.com:20001/eureka/ >> test-20021.out &`