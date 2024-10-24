package site.ngonlustory.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import site.ngonlustory.dto.ResponseObject;
import site.ngonlustory.dto.UserDto;
import site.ngonlustory.exception.ErrorCode;
import site.ngonlustory.models.UserModel;
import site.ngonlustory.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;

    public ResponseObject login(UserDto userDto) {
        UserModel usermodel = userRepository.findByUsernameOrEmail(userDto.username);
        if(userDto.username == null || userDto.password == null || usermodel==null || !userDto.password.equals(usermodel.getPassword())) {
            return ResponseObject.error(ErrorCode.UNAUTHENTICATION.getCode(), ErrorCode.UNAUTHENTICATION.getMessage());
        } else {
            return ResponseObject.success("success");
        }
    }
}
