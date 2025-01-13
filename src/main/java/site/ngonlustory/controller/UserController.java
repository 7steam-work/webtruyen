package site.ngonlustory.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import site.ngonlustory.dto.CreateUserDto;
import site.ngonlustory.response.ResponseMsg;
import site.ngonlustory.services.UserService;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
@CrossOrigin
public class UserController {
    private final UserService userService;

    @GetMapping("/getAllUser")
    public ResponseMsg getAllUser(
            @RequestParam(required = false) Integer id,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction
    ) {
        Sort.Direction dir = Sort.Direction.fromString(direction.toUpperCase());
        Pageable pageable = PageRequest.of(page, size, Sort.by(dir, sortBy));
        return userService.getUser(id, pageable);
    }

    @PostMapping("/createUser")
    public ResponseMsg createUser(@RequestBody CreateUserDto createUserDto) {
        return userService.createUser(createUserDto);
    }

    @DeleteMapping("/deleteUser")
    public ResponseMsg deleteUser(@PathVariable Integer id) {
        return userService.deleteUser(id);
    }

}
