package uz.pdp.g34springbootjpa.dto;

public record CommentCreationDTO(
        Long authorId,
        String content
) {
}
