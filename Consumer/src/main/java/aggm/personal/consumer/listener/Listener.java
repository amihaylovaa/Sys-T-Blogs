package aggm.personal.consumer.listener;

import aggm.personal.consumer.dto.BlogDto;
import aggm.personal.consumer.dto.CommentDto;
import aggm.personal.consumer.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

@Component
public class Listener {

    @Autowired
    private BlogService blogService;

@KafkaListener(
        topicPartitions = @TopicPartition(topic = "comments",
        partitionOffsets = { @PartitionOffset(partition = "0", initialOffset = "0")}),
        containerFactory = "kafkaListenerContainerFactoryComment")
    void commentsListener(CommentDto commentDto) {
        blogService.saveComment(commentDto);
    }

    @KafkaListener(
            topicPartitions = @TopicPartition(topic = "blogs",
            partitionOffsets = { @PartitionOffset(partition = "0", initialOffset = "0")}))
    void blogsListener(BlogDto blogDto) {
        blogService.saveBlog(blogDto);
    }
}