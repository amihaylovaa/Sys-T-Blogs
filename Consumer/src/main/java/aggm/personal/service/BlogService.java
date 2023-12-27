package aggm.personal.service;

import aggm.personal.consumer.dto.CommentDto;
import aggm.personal.domain.Blog;
import aggm.personal.domain.Comment;
import aggm.personal.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;

    public void saveBlog(Blog blog) {
        blog.setPublishingTimestamp(LocalDateTime.now());

        blogRepository.save(blog);
    }

    public void saveComment(CommentDto commentDto) {
        Optional<Blog> blog = blogRepository.findById(commentDto.getBlogId());

        if (!blog.isPresent()) {

        }
        Comment comment = convertCommentDtoToComment(commentDto);

        // TODO - add save
    }

    private Comment convertCommentDtoToComment(CommentDto dto) {
        Comment comment = new Comment();

        // TODO - add converter
        comment.setContent(dto.getContent());
        comment.setTitle(comment.getTitle());
        comment.setUser(dto.getUser());
        comment.setPublishingTimestamp(LocalDateTime.now());
        comment.setAttachmentsUrl(dto.getAttachmentsUrl());

        return comment;
    }
}
