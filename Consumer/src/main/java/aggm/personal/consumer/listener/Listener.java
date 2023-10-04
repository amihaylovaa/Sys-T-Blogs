package aggm.personal.consumer.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

@Component
public class Listener {

@KafkaListener(
        topicPartitions = @TopicPartition(topic = "comments",
        partitionOffsets = { @PartitionOffset(partition = "0", initialOffset = "0")}))
    void commentsListener(String data) {
        // SAVE
    }

    @KafkaListener(
            topicPartitions = @TopicPartition(topic = "blogs",
            partitionOffsets = { @PartitionOffset(partition = "0", initialOffset = "0")}))
    void blogsListener(String data) {
        // SAVE
    }
}
