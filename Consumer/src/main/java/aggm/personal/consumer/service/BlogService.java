package aggm.personal.consumer.service;

import aggm.personal.consumer.dto.BlogDto;
import aggm.personal.consumer.dto.CommentDto;
import aggm.personal.consumer.domain.Blog;
import aggm.personal.consumer.domain.Comment;
import aggm.personal.consumer.exception.DocumentNotFoundException;
import aggm.personal.consumer.repository.BlogRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private ConversionService conversionService;

    public void saveBlog(BlogDto blogDto) {
        Blog blog = conversionService.convert(blogDto, Blog.class);

        blogRepository.save(blog);
    }

    public void saveComment(CommentDto commentDto) {
        ObjectId blogId = new ObjectId(commentDto.getBlogId());
        Optional<Blog> blogOptional = blogRepository.findById(blogId);

        if (!blogOptional.isPresent()) {
            throw new DocumentNotFoundException();
        }
        Comment comment = conversionService.convert(commentDto, Comment.class);

        Blog blog = blogOptional.get();
        blog.addComment(comment);
        // TODO - is it efficient?
        blogRepository.save(blog);
    }
}