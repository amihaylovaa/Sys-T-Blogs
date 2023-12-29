package aggm.personal.consumer.dto;

import lombok.Data;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

@Data
public class CommentDto {

    private ObjectId blogId;
    private String content;
    private String user;
    private List<String> attachmentsUrl = new ArrayList<>();
}