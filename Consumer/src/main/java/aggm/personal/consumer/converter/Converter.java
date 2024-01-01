package aggm.personal.consumer.converter;

import aggm.personal.consumer.domain.Blog;
import aggm.personal.consumer.domain.Comment;
import aggm.personal.consumer.dto.BlogDto;
import aggm.personal.consumer.dto.CommentDto;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;

public final class Converter {

    private Converter() {

    }

    public static Comment convertCommentDtoToComment(CommentDto dto) {
        Comment comment = new Comment();

        comment.setContent(dto.getContent());
        comment.setTitle(comment.getTitle());
        comment.setUser(dto.getUser());
        comment.setPublishingTimestamp(LocalDateTime.now());
        comment.setAttachmentsUrl(dto.getAttachmentsUrl());

        return comment;
    }

    public static Blog convertBlogDtoToBlog(BlogDto dto) {
        Blog blog = new Blog();

        blog.setBlogId(new ObjectId());
        blog.setContent(dto.getContent());
        blog.setTitle(dto.getTitle());
        blog.setSubtitle(dto.getSubtitle());
        blog.setUser(dto.getUser());
        blog.setAttachmentsUrl(dto.getAttachmentsUrl());
        blog.setPublishingTimestamp(LocalDateTime.now());

        return blog;
    }
}