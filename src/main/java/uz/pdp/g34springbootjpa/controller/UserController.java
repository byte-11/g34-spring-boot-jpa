package uz.pdp.g34springbootjpa.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.g34springbootjpa.dto.user.UserDTO;
import uz.pdp.g34springbootjpa.dto.user.UserRegistrationDTO;
import uz.pdp.g34springbootjpa.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody final UserRegistrationDTO dto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userService.register(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable final Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @GetMapping
    public ResponseEntity<Page<UserDTO>> getUsers(
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer size,
            @RequestParam(required = false) String... sortBy
    ) {
        return ResponseEntity.ok(userService.getUsersByPage(page, size, sortBy));
    }

    @GetMapping("/find")
    public ResponseEntity<UserDTO> getUserByUsername(@RequestParam String username, @RequestParam(required = false) Integer type) {
        return ResponseEntity.ok(userService.getUserByUsername(username, type));
    }

}
