package uz.pdp.g34springbootjpa.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.g34springbootjpa.domain.Comment;
import uz.pdp.g34springbootjpa.domain.User;
import uz.pdp.g34springbootjpa.dto.CommentCreationDTO;
import uz.pdp.g34springbootjpa.dto.comment.CommentDTO;
import uz.pdp.g34springbootjpa.exception.UserNotFoundException;
import uz.pdp.g34springbootjpa.projection.CommentProjection;
import uz.pdp.g34springbootjpa.repository.CommentRepository;
import uz.pdp.g34springbootjpa.repository.UserRepository;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;

    @PostMapping
    public Comment createComment(@RequestBody CommentCreationDTO dto) {
        User user = userRepository.findById(dto.authorId()).orElseThrow(
                () -> new UserNotFoundException("ID", dto.authorId())
        );
        Comment comment = Comment.builder()
                .content(dto.content())
                .author(user)
                .build();
        return commentRepository.save(comment);
    }

    @GetMapping("/users/{userId}")
    public List<CommentDTO> getComments(@PathVariable Long userId) {
//        return commentRepository.getCommentsByUserId(userId);
//        return commentRepository.getCommentsByUserIdNative(userId);
        return commentRepository.findByAuthorId(userId);
    }
}
