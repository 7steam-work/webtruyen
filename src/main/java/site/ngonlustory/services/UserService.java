package site.ngonlustory.services;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import site.ngonlustory.dto.CreateUserDto;
import site.ngonlustory.dto.UpdateUserDto;
import site.ngonlustory.response.ResponseMsg;

@Service
public interface UserService {
    ResponseMsg getUser(Integer id, Pageable pageable);
    ResponseMsg createUser(CreateUserDto createUserDto, Integer id);
    ResponseMsg updateUser(Integer id, UpdateUserDto updateUserDto);
    ResponseMsg deleteUser(int id);

}
