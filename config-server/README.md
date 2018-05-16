http请求地址和资源文件映射如下: 

**/{application}/{profile}[/{label}]**

/{application}-{profile}.yml

/{label}/{application}-{profile}.yml

/{application}-{profile}.properties

/{label}/{application}-{profile}.properties

=======================================
Spring Cloud Bus做配置更新步骤如下：


1、提交代码触发post请求给bus/refresh

2、server端接收到请求并发送给Spring Cloud Bus

3、Spring Cloud bus接到消息并通知给其它客户端

4、其它客户端接收到通知，请求Server端获取最新配置

5、全部客户端均获取到最新的配置

=========================================
局部刷新

某些场景下（例如灰度发布），我们可能只想刷新部分微服务的配置，此时可通过/bus/refresh端点的destination参数来定位要刷新的应用程序。

例如：/bus/refresh?destination=customers:8000，这样消息总线上的微服务实例就会根据destination参数的值来判断是否需要要刷新。其中，customers:8000指的是各个微服务的ApplicationContext ID。

destination参数也可以用来定位特定的微服务。例如：/bus/refresh?destination=customers:**，这样就可以触发customers微服务所有实例的配置刷新。

跟踪总线事件

一些场景下，我们可能希望知道Spring Cloud Bus事件传播的细节。此时，我们可以跟踪总线事件（RemoteApplicationEvent的子类都是总线事件）。

跟踪总线事件非常简单，只需设置spring.cloud.bus.trace.enabled=true，这样在/bus/refresh端点被请求后，访问/trace端点就可获得。











