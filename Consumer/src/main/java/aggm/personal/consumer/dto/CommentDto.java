package aggm.personal.consumer.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CommentDto {

    private Object blogId;
    private String content;
    private String user;
    private List<String> attachmentsUrl = new ArrayList<>();
}