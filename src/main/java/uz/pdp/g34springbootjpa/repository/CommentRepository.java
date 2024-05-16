package uz.pdp.g34springbootjpa.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.pdp.g34springbootjpa.domain.Comment;
import uz.pdp.g34springbootjpa.dto.comment.CommentDTO;
import uz.pdp.g34springbootjpa.projection.CommentProjection;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query("SELECT c FROM Comment c WHERE c.author.id = :userId")
    List<Comment> getCommentsByUserId(Long userId);

    @Query(value = "SELECT c.* FROM comment c  WHERE c.author_id = :userId" , nativeQuery = true)
    List<Comment> getCommentsByUserIdNative(Long userId);

//    List<CommentProjection> findByAuthorId(Long authorId);

    List<CommentDTO> findByAuthorId(Long authorId);
}
