[//]: # (todo websocket 与 socketIo)
原生WebSocket与Spring Boot的集成主要涉及到在Spring Boot项目中引入WebSocket的支持，并通过配置和编码实现WebSocket的连接、消息处理等功能。以下是一些关键步骤和考虑因素：

1. **依赖引入**：首先，在Spring Boot项目的`pom.xml`文件中添加WebSocket的依赖。例如：


```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-websocket</artifactId>
</dependency>
```
2. **配置WebSocket**：在Spring Boot项目中，需要配置WebSocket端点（Endpoint），这可以通过注解或编程方式实现。例如，使用`@EnableWebSocket`注解启用WebSocket支持，并定义`@Controller`来处理WebSocket消息。
3. **处理WebSocket消息**：定义处理器类来处理WebSocket连接、消息发送和接收等事件。这可以通过实现`WebSocketHandler`接口或使用`@MessageMapping`、`@SendTo`等注解来完成。
4. **线程安全**：由于WebSocket连接是长时间存在的，因此必须确保相关的处理逻辑是线程安全的。避免在处理器中使用非线程安全的资源或状态。
5. **配置CORS**：如果你的WebSocket服务需要跨域访问，还需要配置CORS（跨源资源共享）支持。这可以通过实现`WebMvcConfigurer`接口并覆盖`addCorsMappings`方法来完成。
6. **安全性考虑**：对于生产环境，还需要考虑WebSocket连接的安全性，例如使用WSS（WebSocket Secure）进行加密通信，以及实施适当的认证和授权机制。

通过以上步骤，你可以将原生WebSocket与Spring Boot成功集成，实现实时、双向的通信功能。请注意，具体的实现细节可能会因项目需求和Spring Boot版本而有所不同，因此建议参考官方文档和相关教程以获得更详细和准确的信息。
