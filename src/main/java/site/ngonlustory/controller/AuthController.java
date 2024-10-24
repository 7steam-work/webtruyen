package site.ngonlustory.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import site.ngonlustory.dto.ResponseObject;
import site.ngonlustory.dto.UserDto;
import site.ngonlustory.exception.ErrorCode;
import site.ngonlustory.models.UserModel;
import site.ngonlustory.repository.UserRepository;
import site.ngonlustory.service.AuthService;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
@Slf4j
@CrossOrigin
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseObject login(@RequestBody UserDto userDto) {
        return authService.login(userDto);
    }

}
