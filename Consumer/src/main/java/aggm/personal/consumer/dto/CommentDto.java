package aggm.personal.consumer.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CommentDto {

    private String blogId;
    private String content;
    private String user;
    private List<String> attachmentsUrl = new ArrayList<>();
}