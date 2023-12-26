package aggm.personal.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document("blogs")
@Getter
@Setter
public class Blog {

    @Id
    private String id;
    private String title;
    private String subtitle;
    private String content;
    private LocalDateTime publishingTimestamp;
    private List<String> attachmentsUrl = new ArrayList<>();

    @DBRef
    private List<Comment> comments = new ArrayList<>();
}