package site.ngonlustory.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import site.ngonlustory.dto.CreateUserDto;
import site.ngonlustory.dto.UpdateUserDto;
import site.ngonlustory.response.ResponseMsg;
import site.ngonlustory.services.UserService;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
@CrossOrigin
@Tag(name = "Quản lý người dùng")
public class UserController {
    private final UserService userService;

    @Operation(
            description = "Url truy cập: /api/v1/auth/getUser?id=1&page=0&size=10&sortBy=name&direction=desc"
    )
    @GetMapping("/getUser")
    public ResponseMsg getUser(
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

    @PutMapping("/updateUser/{id}")
    public ResponseMsg updateUser(@PathVariable Integer id, @RequestBody UpdateUserDto updateUserDto) {
        return userService.updateUser(id, updateUserDto);
    }

    @PostMapping("/createUser")
    public ResponseMsg createUser(@RequestBody CreateUserDto createUserDto) {
        return userService.createUser(createUserDto, 1);
    }

    @PostMapping("/createAdmin")
    public ResponseMsg createAdmin(@RequestBody CreateUserDto createAdminDto) {
        return userService.createUser(createAdminDto, 2);
    }

    @DeleteMapping("/deleteUser")
    public ResponseMsg deleteUser(@PathVariable Integer id) {
        return userService.deleteUser(id);
    }

}
