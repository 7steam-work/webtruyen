package site.ngonlustory.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import site.ngonlustory.dto.LoginDto;
import site.ngonlustory.models.UserEntity;
import site.ngonlustory.repository.UserRepository;
import site.ngonlustory.response.ResponseMsg;
import site.ngonlustory.services.AuthService;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;

    @Override
    public ResponseMsg login(LoginDto loginDto, Boolean isUser) {
        if (loginDto.getUsername() == null || loginDto.getPassword() == null || loginDto.getRePassword() == null) {
            return ResponseMsg.badRequest("Trường bắt buộc thiếu!");
        }
        if (!loginDto.getRePassword().equals(loginDto.getPassword())) {
            return ResponseMsg.badRequest("Mật khẩu không trùng nhau!");
        }
        UserEntity userEntity;
        if (isUser) {
            userEntity = userRepository.findByUsernameAndRoleId(loginDto.getUsername(), 1);
        } else {
            userEntity = userRepository.findByUsernameAndRoleId(loginDto.getUsername(), 2);
        }
        if (userEntity == null) {
            return ResponseMsg.notFound("Không tìm thấy user này!");
        }
        if (!userEntity.getPassword().equals(loginDto.getPassword())) {
            return ResponseMsg.badRequest("Mật khẩu không chính xác!");
        }
        return ResponseMsg.success("Success!", null);
    }
}
