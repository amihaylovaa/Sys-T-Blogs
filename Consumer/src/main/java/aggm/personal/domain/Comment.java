package aggm.personal.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document("comments")
@Getter
@Setter
public class Comment {

    @Id
    private long id;
    private String title;
    private String content;
    private String user;
    private List<String> attachmentsUrl = new ArrayList<>();
}