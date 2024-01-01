package aggm.personal.consumer.service;

import aggm.personal.consumer.converter.Converter;
import aggm.personal.consumer.dto.BlogDto;
import aggm.personal.consumer.dto.CommentDto;
import aggm.personal.consumer.domain.Blog;
import aggm.personal.consumer.domain.Comment;
import aggm.personal.consumer.exception.DocumentNotFoundException;
import aggm.personal.consumer.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;

    public void saveBlog(BlogDto blogDto) {
        Blog blog = Converter.convertBlogDtoToBlog(blogDto);

        blogRepository.save(blog);
    }

    public void saveComment(CommentDto commentDto) {
        Optional<Blog> blogOptional = blogRepository.findById(commentDto.getBlogId());

        if (!blogOptional.isPresent()) {
            throw new DocumentNotFoundException();
        }
        Comment comment = Converter.convertCommentDtoToComment(commentDto);

        Blog blog = blogOptional.get();
        blog.addComment(comment);
        // TODO - is it efficient?
        blogRepository.save(blog);
    }
}
