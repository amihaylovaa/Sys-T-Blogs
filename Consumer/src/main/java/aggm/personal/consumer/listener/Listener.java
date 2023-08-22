package aggm.personal.consumer.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Listener {

    @KafkaListener(topics = "comments", groupId = "groupId")
    void commentsListener(String data) {

    }

    @KafkaListener(topics = "blogs", groupId = "groupId")
    void blogsListener(String data) {

    }
}
