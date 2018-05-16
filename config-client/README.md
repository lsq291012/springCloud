1.用application.properties，可以用这个默认的配置文件，但必须将服务端口配置为8888，这是默认端口

2.如果用了bootstrap.properties，则可以自定义端口，因为bootstrap.* 命名的文件会被优先读取和配置
spring-cloud相关的属性必须配置在bootstrap.properties中，config部分内容才能被正确加载。
因为config的相关配置会先于application.properties，
而bootstrap.properties的加载也是先于application.properties。


spring-cloud-starter-bus-amqp
只需要发送post请求：http://localhost:8881/bus/refresh，你会发现config-client会重新读取配置文件

另外，/bus/refresh接口可以指定服务，即使用”destination”参数，
比如 “/bus/refresh?destination=customers:**” 即刷新服务名为customers的所有服务，不管ip。

