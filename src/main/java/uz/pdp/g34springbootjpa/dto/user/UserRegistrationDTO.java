package uz.pdp.g34springbootjpa.dto.user;

public record UserRegistrationDTO(
        String username,
        String email,
        String password
) {
}
