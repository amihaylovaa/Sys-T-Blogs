package aggm.personal.consumer.config;

import aggm.personal.consumer.dto.BlogDto;
import aggm.personal.consumer.dto.CommentDto;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class CustomKafkaConsumerConfig {
    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServer;

    @Value("${kafka.group_id}")
    private String groupId;

    @Bean
    public Map<String, Object> blogConsumerConfig() {
        Map<String, Object> properties = new HashMap<>();

        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);

        return properties;
    }

    @Bean
    public ConsumerFactory<String, BlogDto> blogConsumerFactory() {
        return new DefaultKafkaConsumerFactory<>(blogConsumerConfig(), new StringDeserializer(),
                new JsonDeserializer<>(BlogDto.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, BlogDto> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, BlogDto> factory = new ConcurrentKafkaListenerContainerFactory<>();

        factory.setConsumerFactory(blogConsumerFactory());

        return factory;
    }

    @Bean
    public Map<String, Object> commentConsumerConfig() {
        Map<String, Object> properties = new HashMap<>();

        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);

        return properties;
    }

    @Bean
    public ConsumerFactory<String, CommentDto> commentConsumerFactory() {
        return new DefaultKafkaConsumerFactory<>(commentConsumerConfig(), new StringDeserializer(),
                new JsonDeserializer<>(CommentDto.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, CommentDto> kafkaListenerContainerFactoryComment() {
        ConcurrentKafkaListenerContainerFactory<String, CommentDto> factory = new ConcurrentKafkaListenerContainerFactory<>();

        factory.setConsumerFactory(commentConsumerFactory());

        return factory;
    }
}
