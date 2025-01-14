package site.ngonlustory.services;

import org.springframework.stereotype.Service;
import site.ngonlustory.dto.LoginDto;
import site.ngonlustory.response.ResponseMsg;

@Service
public interface AuthService {
    ResponseMsg login(LoginDto loginDto, Boolean isUser);

}
