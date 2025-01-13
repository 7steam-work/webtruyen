package site.ngonlustory.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import site.ngonlustory.dto.CreateUserDto;
import site.ngonlustory.dto.UpdateUserDto;
import site.ngonlustory.models.UserEntity;
import site.ngonlustory.repository.UserRepository;
import site.ngonlustory.response.ResponseMsg;
import site.ngonlustory.services.UserService;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public ResponseMsg getUser(Integer id,Pageable pageable) {
        if (id == null) {
            return ResponseMsg.success(userRepository.findAll(pageable));
        } else {
            return ResponseMsg.success(userRepository.findById(id).orElse(null));
        }
    }

    @Override
    public ResponseMsg createUser(CreateUserDto input, Integer roleValue) {
        UserEntity userEntity = UserEntity.builder()
                .username(input.getUsername())
                .password(input.getPassword())
                .email(input.getEmail())
                .roleId(roleValue)
                .createdAt(Timestamp.valueOf(LocalDateTime.now()))
                .avatar(input.getAvatar())
                .lastLogin(null)
                .bio(input.getBio())
                .updatedAt(Timestamp.valueOf(LocalDateTime.now()))
                .updatedBy(null)
                .build();
        return ResponseMsg.success(userRepository.save(userEntity));
    }

    @Override
    public ResponseMsg updateUser(Integer id, UpdateUserDto input) {
        Optional<UserEntity> userOptional = userRepository.findById(id);

        if (userOptional.isEmpty()) {
            return ResponseMsg.error(404, "User not found");
        }

        UserEntity existingUser = userOptional.get();

        // Chỉ update các trường không null
        if (input.getUsername() != null) {
            existingUser.setUsername(input.getUsername());
        }
        if (input.getPassword() != null) {
            existingUser.setPassword(input.getPassword());
        }
        if (input.getEmail() != null) {
            existingUser.setEmail(input.getEmail());
        }
        if (input.getAvatar() != null) {
            existingUser.setAvatar(input.getAvatar());
        }
        if (input.getBio() != null) {
            existingUser.setBio(input.getBio());
        }

        existingUser.setUpdatedAt(Timestamp.valueOf(LocalDateTime.now()));

        UserEntity updatedUser = userRepository.save(existingUser);
        return ResponseMsg.success(updatedUser);
    }

    @Override
    public ResponseMsg deleteUser(int id) {
        userRepository.deleteById(id);
        return ResponseMsg.success("Drop user " + id + " success");
    }

}
