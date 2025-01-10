package site.ngonlustory.services;

import org.springframework.stereotype.Service;
import site.ngonlustory.dto.CreateUserDto;
import site.ngonlustory.models.UserEntity;
import site.ngonlustory.response.ResponseMsg;

import java.util.List;

@Service
public interface UserService {
    List<UserEntity> getAllUser();
    ResponseMsg createUser(CreateUserDto createUserDto);
    ResponseMsg deleteUser(int id);
}
