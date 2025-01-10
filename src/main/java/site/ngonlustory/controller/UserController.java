package site.ngonlustory.controller;

import lombok.RequiredArgsConstructor;
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
    public ResponseMsg getAllUser() {
        return ResponseMsg.success(userService.getAllUser());
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
