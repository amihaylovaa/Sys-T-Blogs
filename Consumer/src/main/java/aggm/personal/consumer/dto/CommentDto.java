package aggm.personal.consumer.dto;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CommentDto {

    private ObjectId blogId;
    private String content;
    private String user;
    private List<String> attachmentsUrl = new ArrayList<>();
}