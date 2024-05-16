package uz.pdp.g34springbootjpa.dto.comment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import uz.pdp.g34springbootjpa.domain.User;

@Getter
@AllArgsConstructor
public class CommentDTO {
    private Long id;
    private String content;
    private User author;

    public String getAuthor() {
        return author.getUsername();
    }
}
