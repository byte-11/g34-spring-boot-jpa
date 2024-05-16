package uz.pdp.g34springbootjpa.projection;

import org.springframework.beans.factory.annotation.Value;

public interface CommentProjection {
    Long getId();
    String getContent();
    @Value("#{target.author.username}")
    String getAuthor();
}

