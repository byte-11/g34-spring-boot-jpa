package uz.pdp.g34springbootjpa.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import uz.pdp.g34springbootjpa.domain.User;
import uz.pdp.g34springbootjpa.dto.user.UserDTO;
import uz.pdp.g34springbootjpa.dto.user.UserRegistrationDTO;
import uz.pdp.g34springbootjpa.exception.UserNotFoundException;
import uz.pdp.g34springbootjpa.repository.UserRepository;
import static uz.pdp.g34springbootjpa.util.AppDefaults.DEFAULT_PAGE_NUMBER;
import static uz.pdp.g34springbootjpa.util.AppDefaults.DEFAULT_PAGE_SIZE;
import static uz.pdp.g34springbootjpa.util.AppDefaults.DEFAULT_USER_SORTING_FIELD;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO register(final UserRegistrationDTO dto) {
        User user = User.builder()
                .username(dto.username())
                .email(dto.email())
                .password(dto.password())
                .build();
        user = userRepository.save(user);
        return new UserDTO(user);
    }

    public UserDTO getUserById(final Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new UserNotFoundException("ID", id)
        );
        return new UserDTO(user);
    }

    public Page<UserDTO> getUsersByPage(Integer page, Integer size, String... sortBy) {
        if (page == null) {
            page = DEFAULT_PAGE_NUMBER;
        }

        if (size == null) {
            size = DEFAULT_PAGE_SIZE;
        }
        if (sortBy == null) {
            sortBy = new String[]{DEFAULT_USER_SORTING_FIELD};
        }

        return userRepository.findAll(PageRequest.of(
                        page,
                        size,
                        Sort.by(Sort.Direction.DESC, sortBy)
                ))
                .map(UserDTO::new);
    }

}
