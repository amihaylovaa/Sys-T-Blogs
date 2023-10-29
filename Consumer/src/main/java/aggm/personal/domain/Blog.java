package aggm.personal.domain;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("blogs")
@Getter
@Setter
public class Blog {

    @Id
    private long id;
    private String title;
    private String subtitle;
    private String content;
    private List<String> attachmentsUrl;
}