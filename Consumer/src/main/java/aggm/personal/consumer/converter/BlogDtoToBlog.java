package aggm.personal.consumer.converter;

import aggm.personal.consumer.domain.Blog;
import aggm.personal.consumer.dto.BlogDto;
import org.bson.types.ObjectId;
import org.springframework.core.convert.converter.Converter;

import java.time.LocalDateTime;

public class BlogDtoToBlog implements Converter<BlogDto, Blog> {

    @Override
    public Blog convert(BlogDto dto) {
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