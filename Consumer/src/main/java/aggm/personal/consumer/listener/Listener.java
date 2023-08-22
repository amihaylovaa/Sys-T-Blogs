package aggm.personal.consumer.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Listener {

    @KafkaListener(topicPattern = "comments", groupId = "groupId")
    void commentsListener(String data) {

    }

    @KafkaListener(topicPattern = "blogs", groupId = "groupId")
    void blogsListener(String data) {

    }
}
