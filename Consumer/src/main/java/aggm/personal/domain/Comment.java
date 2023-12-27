package aggm.personal.domain;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "comments")
@Data
public class Comment {

    @Id
    private ObjectId id;
    private String title;
    private String content;
    private String user;
    private LocalDateTime publishingTimestamp;
    private List<String> attachmentsUrl = new ArrayList<>();
}