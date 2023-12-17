package aggm.personal.service;

import aggm.personal.domain.Blog;
import aggm.personal.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;

    public void saveBlog(Blog blog) {
        blogRepository.save(blog);
    }
}
