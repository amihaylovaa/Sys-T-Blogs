package aggm.personal.consumer.service;

import aggm.personal.consumer.dto.BlogDto;
import aggm.personal.consumer.dto.CommentDto;
import aggm.personal.consumer.domain.Blog;
import aggm.personal.consumer.domain.Comment;
import aggm.personal.consumer.repository.BlogRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;

    public void saveBlog(BlogDto blogDto) {
        Blog blog = convertBlogDtoToBlog(blogDto);

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

    private Blog convertBlogDtoToBlog(BlogDto dto) {
        Blog blog = new Blog();

        // TODO - add converter
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
