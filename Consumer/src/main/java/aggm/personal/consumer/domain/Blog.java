package aggm.personal.consumer.domain;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "blogs")
@Data
public class Blog {

    @Id
    @Field("blog_id")
    private ObjectId id;
    private String title;
    private String subtitle;
    private String content;
    private String user;
    private LocalDateTime publishingTimestamp;
    private List<String> attachmentsUrl = new ArrayList<>();

    @DBRef(lazy = true)
    private List<Comment> comments = new ArrayList<>();

    public void addComment(Comment comment) {
        comments.add(comment);
    }
}