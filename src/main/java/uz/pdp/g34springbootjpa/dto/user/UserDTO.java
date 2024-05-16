package uz.pdp.g34springbootjpa.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.pdp.g34springbootjpa.domain.User;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String username;
    private String email;

    public UserDTO(final User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.username = user.getUsername();
    }
}
