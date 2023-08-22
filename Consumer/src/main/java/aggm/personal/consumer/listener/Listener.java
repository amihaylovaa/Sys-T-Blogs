package aggm.personal.consumer.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Listener {

    @KafkaListener(topics = "comments")
    void commentsListener(String data) {

    }

    @KafkaListener(topics = "blogs")
    void blogsListener(String data) {

    }
}
