package site.ngonlustory.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import site.ngonlustory.dto.LoginDto;
import site.ngonlustory.response.ResponseMsg;
import site.ngonlustory.services.AuthService;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@CrossOrigin
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseMsg userLogin(@RequestBody LoginDto loginDto) {
        return authService.login(loginDto, true);
    }

    @PostMapping("/adminLogin")
    public ResponseMsg adminLogin(@RequestBody LoginDto loginDto) {
        return authService.login(loginDto, false);
    }


}