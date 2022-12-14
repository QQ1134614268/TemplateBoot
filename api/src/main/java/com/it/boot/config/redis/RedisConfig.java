package com.it.boot.config.redis;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;


@Configuration
public class RedisConfig {
    public final static String TOPIC_NAME1 = "TEST_TOPIC1"; // 订阅主题
    public final static String TOPIC_NAME2 = "TEST_TOPIC2"; // 订阅主题
    public final static String TOPIC_NAME3 = "TEST_TOPIC3"; // 订阅主题
    public final static String TOPIC_NAME4 = "TEST_TOPIC4"; // 订阅主题

    //编写配置类，可模仿RedisAutoConfiguration配置类，该类在开发中可直接使用
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        //由于源码autoConfig中是<Object, Object>，开发中一般直接使用<String,Object>
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);

        //Json序列化配置
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);

        //String的序列化
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();

        //key采用string的序列化
        template.setKeySerializer(stringRedisSerializer);
        //hash的key采用string的序列化
        template.setKeySerializer(stringRedisSerializer);
        //value序列化采用jackson
        template.setValueSerializer(jackson2JsonRedisSerializer);
        //hash的value序列化方式采用jackson
        template.setValueSerializer(jackson2JsonRedisSerializer);
        template.afterPropertiesSet();
        return template;
    }

    /**
     * Redis消息监听器容器
     * 这个容器加载了RedisConnectionFactory和消息监听器
     * 可以添加多个监听不同话题的redis监听器，只需要把消息监听器和相应的消息订阅处理器绑定，该消息监听器
     * 通过反射技术调用消息订阅处理器的相关方法进行一些业务处理
     *
     * @param redisConnectionFactory 连接工厂
     * @return redis消息监听容器
     */
    @Bean
    public RedisMessageListenerContainer container(RedisConnectionFactory redisConnectionFactory,
                                                   RedisMessageListener listener,
                                                   MessageListenerAdapter listenerAdapter,
                                                   MessageListenerAdapter listenerAdapter2,
                                                   RedisMessageListener2 redisMessageListener2) {



        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        // 监听所有库的key过期事件
        container.setConnectionFactory(redisConnectionFactory);
        // 所有的订阅消息，都需要在这里进行注册绑定,new PatternTopic(TOPIC_NAME1)表示发布的主题信息
        // 可以添加多个 messageListener，配置不同的通道
        container.addMessageListener(listener, new PatternTopic(TOPIC_NAME1));
        container.addMessageListener(listenerAdapter, new PatternTopic(TOPIC_NAME2));

        container.addMessageListener(redisMessageListener2, new PatternTopic(TOPIC_NAME1));
        container.addMessageListener(listenerAdapter2, new PatternTopic(TOPIC_NAME3));

        /**
         * 设置序列化对象
         * 特别注意：1. 发布的时候需要设置序列化；订阅方也需要设置序列化
         *         2. 设置序列化对象必须放在[加入消息监听器]这一步后面，否则会导致接收器接收不到消息
         */
        Jackson2JsonRedisSerializer<String> seria = new Jackson2JsonRedisSerializer<>(String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        seria.setObjectMapper(objectMapper);
        container.setTopicSerializer(seria);

        return container;
    }

    /**
     * 这个地方是给 messageListenerAdapter 传入一个消息接受的处理器，利用反射的方法调用“receiveMessage”
     * 也有好几个重载方法，这边默认调用处理器的方法 叫OnMessage
     *
     * @param printMessageReceiver
     * @return
     */
    @Bean
    public MessageListenerAdapter listenerAdapter(PrintMessageReceiver printMessageReceiver) {
        MessageListenerAdapter receiveMessage = new MessageListenerAdapter(printMessageReceiver, "receiveMessage");

        Jackson2JsonRedisSerializer<Object> serializer = new Jackson2JsonRedisSerializer<>(Object.class);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        serializer.setObjectMapper(objectMapper);
        receiveMessage.setSerializer(serializer);
        return receiveMessage;
    }
    @Bean
    public MessageListenerAdapter listenerAdapter2(PrintMessageReceiver2 printMessageReceiver) {
        MessageListenerAdapter receiveMessage = new MessageListenerAdapter(printMessageReceiver, "receiveMessage");

        Jackson2JsonRedisSerializer<Object> serializer = new Jackson2JsonRedisSerializer<>(Object.class);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        serializer.setObjectMapper(objectMapper);
        receiveMessage.setSerializer(serializer);
        return receiveMessage;
    }
}

