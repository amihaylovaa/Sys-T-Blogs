package aggm.personal.consumer.service;

import aggm.personal.consumer.dto.CommentDto;
import aggm.personal.consumer.domain.Blog;
import aggm.personal.consumer.domain.Comment;
import aggm.personal.consumer.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
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
        Optional<Blog> blogOptional = blogRepository.findById(commentDto.getBlogId());

        if (!blogOptional.isPresent()) {
            // TODO throw exception
        }
        Comment comment = convertCommentDtoToComment(commentDto);

        Blog blog = blogOptional.get();
        blog.addComment(comment);
        // TODO - is it efficient?
        blogRepository.save(blog);
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
