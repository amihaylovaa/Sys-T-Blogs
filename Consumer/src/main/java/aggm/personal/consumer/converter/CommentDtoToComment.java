package aggm.personal.consumer.converter;

import aggm.personal.consumer.domain.Comment;
import aggm.personal.consumer.dto.CommentDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CommentDtoToComment implements Converter<CommentDto, Comment> {

    @Override
    public Comment convert(CommentDto dto) {
        Comment comment = new Comment();

        comment.setContent(dto.getContent());
        comment.setTitle(comment.getTitle());
        comment.setUser(dto.getUser());
        comment.setPublishingTimestamp(LocalDateTime.now());
        comment.setAttachmentsUrl(dto.getAttachmentsUrl());

        return comment;
    }
}