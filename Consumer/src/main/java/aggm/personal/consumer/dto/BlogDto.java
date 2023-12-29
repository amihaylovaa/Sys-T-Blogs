package aggm.personal.consumer.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BlogDto {

    private String title;
    private String subtitle;
    private String content;
    private List<String> attachmentsUrl = new ArrayList<>();
}